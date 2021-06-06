package com.example.model;

public enum Response {
    SUCESS, ERROR;

    @Override
    public String toString() {
        return name();
    }
}
