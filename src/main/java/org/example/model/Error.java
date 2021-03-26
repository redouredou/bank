package org.example.model;

public enum Error {
    UNAUTHORIZED_WITHDRAWAL(0, "You can't withdraw more than you have in your account balance"),
    NEGATIVE_FORBIDDEN(1, "You can't use negative value");

    private final int code;
    private final String description;

    Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}