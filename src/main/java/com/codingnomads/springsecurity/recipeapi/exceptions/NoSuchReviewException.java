/* CodingNomads (C)2023 */
package com.codingnomads.springsecurity.recipeapi.exceptions;

public class NoSuchReviewException extends Exception {

    public NoSuchReviewException(String message) {
        super(message);
    }

    public NoSuchReviewException() {}
}
