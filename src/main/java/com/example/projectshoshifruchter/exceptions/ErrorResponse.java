package com.example.projectshoshifruchter.exceptions;

import java.time.LocalDateTime;

/**
 * המחלקה שנשלחת ב-body של כל תגובת שגיאה מה-API.
 * במקום stack trace — הלקוח מקבל JSON נקי ומובן.
 */
public class ErrorResponse {

    private int status;
    private String error;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
