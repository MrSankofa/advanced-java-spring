/* CodingNomads (C)2024 */
package com.codingnomads.springtest.mockingmethods.exceptions;

public class NoSuchRecipeException extends Exception {

    public NoSuchRecipeException(String message) {
        super(message);
    }

    public NoSuchRecipeException() {}
}
