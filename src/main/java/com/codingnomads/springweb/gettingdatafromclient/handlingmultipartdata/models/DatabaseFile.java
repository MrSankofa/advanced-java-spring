/* CodingNomads (C)2023 */
package com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.models;

import jakarta.persistence.*;
import lombok.*;

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

    @Lob
    private byte[] data;

    @Transient
    private String downloadUrl;
}
