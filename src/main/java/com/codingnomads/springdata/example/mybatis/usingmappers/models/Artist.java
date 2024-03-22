/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.usingmappers.models;

import java.util.List;
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

    private List<Song> songs;
}
