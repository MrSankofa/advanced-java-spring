/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.extraexample.models;

import java.util.List;
import lombok.Data;

@Data
public class Section {

    private Long id;
    private String name;
    private List<Chapter> chapters;
}
