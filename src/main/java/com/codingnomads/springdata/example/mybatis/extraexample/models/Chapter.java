/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.mybatis.extraexample.models;

import java.util.List;
import lombok.Data;

@Data
public class Chapter {

    private Long id;
    private String name;
    private List<Lesson> lessons;
}
