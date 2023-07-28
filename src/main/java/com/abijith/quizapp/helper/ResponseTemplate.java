package com.abijith.quizapp.helper;

import lombok.Data;

@Data
public class ResponseTemplate<T> {
    private Integer statusCode = null;
    private String message = null;
    private T response = null;
}
