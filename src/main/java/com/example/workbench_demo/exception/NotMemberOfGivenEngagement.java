package com.example.workbench_demo.exception;

public class NotMemberOfGivenEngagement extends RuntimeException {
    public NotMemberOfGivenEngagement(String message) {
        super(message);
    }
}