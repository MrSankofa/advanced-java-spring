/* CodingNomads (C)2023 */
package com.codingnomads.springweb.resttemplate.PATCH.models;

import lombok.Data;

@Data
public class ResponseObject {
    Task data;
    Error error;
    String status;
}
