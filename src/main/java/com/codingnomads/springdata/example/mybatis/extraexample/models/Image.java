/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.mybatis.extraexample.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Image {

    private String name;
    private byte[] imageData;
}
