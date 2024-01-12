/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.models;

import lombok.Data;

@Data
public class ResponseObject {
    Task data;
    Error error;
    String status;
}
