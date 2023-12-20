/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.mybatis.extraexample.models;

import java.util.List;
import lombok.Data;

@Data
public class Lesson {

    private Long id;
    private String name;
    private String text;
    private List<Image> imageList;
}
