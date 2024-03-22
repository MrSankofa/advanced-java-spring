/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.DELETE.models;

import lombok.Data;

@Data
public class ResponseObject {
    Task data;
    Error error;
    String status;
}
