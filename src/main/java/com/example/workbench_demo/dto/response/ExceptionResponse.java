package com.example.workbench_demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private Integer status;
    private String developerMessage;
    private String userMessage;
    private Integer errorCode;
    private Object data;
}