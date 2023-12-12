package com.codingnomads.springsecurity.recipeapi.exceptions;


public class NoSuchRecipeException extends Exception{

    public NoSuchRecipeException(String message) {
        super(message);
    }

    public NoSuchRecipeException() {

    }
}
