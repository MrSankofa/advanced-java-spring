/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.controllers;

import com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.models.DatabaseFile;
import com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.models.FileResponse;
import com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.repositories.DatabaseFileRepository;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/images")
public class HandleMultipartDataController {

    @Autowired
    DatabaseFileRepository fileRepository;

    // @PostMapping("/uploadSingleFile")
    @PostMapping()
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file) {

        final long MAX_FILE_SIZE = 5L * 1024 * 1024 * 1024; // 5 GB

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest()
                .body("File is empty. Please upload a valid file.");
        }

        if (file.getSize() > MAX_FILE_SIZE) {
            return ResponseEntity.badRequest()
                .body("File size exceeds the limit of 5GB.");
        } else {
            System.out.println("File size is " + file.getSize() + "this isn't too large at all");
        }


        String fileName;
        // get the original file name
        if (file == null) {
            return ResponseEntity.badRequest()
                    .body(new IllegalStateException("Sorry did not receive a file, please try again!"));
        } else {
            fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        }

        try {
            // create a new DatabaseFile with the file information
            final DatabaseFile databaseFile = DatabaseFile.builder()
                    .data(file.getBytes())
                    .fileName(fileName)
                    .fileType(file.getContentType())
                    .build();

            // save to the database
            final DatabaseFile savedFile = fileRepository.save(databaseFile);

            // create the download URI
            savedFile.setDownloadUrl(ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/images/")
                    .path(String.valueOf(savedFile.getId()))
                    .toUriString());

            // create a FileResponse object using file info and wrap it in a ResponseEntity
            return ResponseEntity.ok(FileResponse.builder()
                    .fileName(databaseFile.getFileName())
                    .fileDownloadUri(savedFile.getDownloadUrl())
                    .fileType(file.getContentType())
                    .size(file.getSize())
                    .build());

        } catch (IOException ex) {
            // wraps exception with custom message in a ResponseEntity to be returned to the user.
            return ResponseEntity.badRequest()
                    .body(new IllegalStateException("Sorry could not store file " + fileName + "Try again!", ex));
        }
    }

    // @GetMapping("/download/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<?> downloadFileById(@PathVariable(name = "id") Long fileId) {

        final Optional<DatabaseFile> optional = fileRepository.findById(fileId);

        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found with id: " + fileId);
        }

        DatabaseFile databaseFile = optional.get();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                // display the file inline
                // .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                // download file, without setting file name
                // .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
                // download file, and specify file name
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        String.format("attachment; filename=\"%s\"", databaseFile.getFileName()))
                .body(new ByteArrayResource(databaseFile.getData()));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getFileDetails(@PathVariable(name = "id") Long fileId) {
        final Optional<DatabaseFile> optional = fileRepository.findById(fileId);

        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found with id: " + fileId);
        }

        DatabaseFile databaseFile = optional.get();

        return ResponseEntity.ok(databaseFile);
    }


    // @PutMapping("/uploadSingleFile/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFileById(@PathVariable(name = "id") Long fileId, @RequestBody MultipartFile file) {

        final Optional<DatabaseFile> optional = fileRepository.findById(fileId);

        if (optional.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new NoSuchFileException(
                            "The ID you passed in was not valid. " + "Where you trying to upload a new file?"));
        } else if (file == null) {
            return ResponseEntity.badRequest().body(new NoSuchFileException("No file was received, please try again."));
        }

        DatabaseFile databaseFile = optional.get();
        try {
            databaseFile.setData(file.getBytes());
            databaseFile.setFileName(file.getOriginalFilename());
            databaseFile.setFileType(file.getContentType());
        } catch (IOException ex) {
            return ResponseEntity.badRequest()
                    .body(new IllegalStateException(
                            "Sorry could not update file " + file.getOriginalFilename() + "Try again!", ex));
        }

        final DatabaseFile savedFile = fileRepository.save(databaseFile);

        savedFile.setDownloadUrl(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(String.valueOf(savedFile.getId()))
                .toUriString());

        return ResponseEntity.ok(FileResponse.builder()
                .fileName(databaseFile.getFileName())
                .fileDownloadUri(savedFile.getDownloadUrl())
                .fileType(file.getContentType())
                .size(file.getSize())
                .build());
    }

    // @DeleteMapping("/deleteFile/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFileById(@PathVariable("id") Long fileId) {
        final Optional<DatabaseFile> optional = fileRepository.findById(fileId);

        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body(new NoSuchFileException("The ID passed in was not valid."));
        }

        fileRepository.deleteById(fileId);
        return ResponseEntity.ok(
                "File with ID " + fileId + " and name " + optional.get().getFileName() + " was deleted");
    }
}
