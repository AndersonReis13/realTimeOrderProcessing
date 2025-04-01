package com.as._3.realtimeorderprocessing.infrastructure.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionResponse {

    private String message;
    private Integer status;
    private HttpStatus httpStatus;
    private String path;
    private Date timeInstant;

    public ExceptionResponse(String message, Integer status, HttpStatus httpStatus, String path, Date timeInstant) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
        this.path = path;
        this.timeInstant = timeInstant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimeInstant() {
        return timeInstant;
    }

    public void setTimeInstant(Date timeInstant) {
        this.timeInstant = timeInstant;
    }
}
