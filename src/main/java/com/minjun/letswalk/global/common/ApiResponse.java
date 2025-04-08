package com.minjun.letswalk.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiResponse<T> {
    private int code;
    private HttpStatus status;
    private String message;
    private T data;

    public static <T> ApiResponse<T> of(int code, HttpStatus httpStatus, String message, T data) {
        return new ApiResponse<>(code, httpStatus, message, data);
    }

    public static <T> ApiResponse<T> of(HttpStatus httpStatus, T data) {
        return of(httpStatus.value(), httpStatus, httpStatus.name(), data);
    }


    public static <T> ApiResponse<T> ok(T data) {
        return of(HttpStatus.OK.value(), HttpStatus.OK, HttpStatus.OK.name(), data);
    }
}
