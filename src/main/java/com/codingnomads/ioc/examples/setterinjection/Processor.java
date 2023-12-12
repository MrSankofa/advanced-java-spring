/* CodingNomads (C)2023 */
package com.codingnomads.ioc.examples.setterinjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Processor {
    private Integer core;
    private String name;
}
