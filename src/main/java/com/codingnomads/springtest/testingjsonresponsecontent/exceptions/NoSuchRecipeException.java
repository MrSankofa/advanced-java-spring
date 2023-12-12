/* CodingNomads (C)2023 */
package com.codingnomads.springtest.testingjsonresponsecontent.exceptions;

public class NoSuchRecipeException extends Exception {

    public NoSuchRecipeException(String message) {
        super(message);
    }

    public NoSuchRecipeException() {}
}
