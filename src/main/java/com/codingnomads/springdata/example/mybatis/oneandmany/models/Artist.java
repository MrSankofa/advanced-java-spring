/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.mybatis.oneandmany.models;

import java.util.ArrayList;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = "songs")
public class Artist {

    private Long id;

    private String name;

    private String bio;

    private ArrayList<Song> songs;
}
