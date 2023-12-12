package com.codingnomads.springweb.wrappingup.multipartdata.models;

import lombok.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "database_files")
public class DatabaseFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;
    private String fileType;
    private Long size;

    @Lob
    private byte[] data;

    @Transient
    private String downloadUrl;

    public String getDownloadUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(String.valueOf(this.id))
                .toUriString();
    }
}
