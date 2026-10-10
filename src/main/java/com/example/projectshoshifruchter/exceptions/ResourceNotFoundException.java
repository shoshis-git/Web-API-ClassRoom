package com.example.projectshoshifruchter.exceptions;

/**
 * נזרק כשמחפשים ClassRoom לפי ID ולא מוצאים אותו.
 * @ResponseStatus לא שמים כאן — ה-GlobalExceptionHandler הוא שמחזיר את ה-404.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
