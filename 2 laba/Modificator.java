package org.example;

public enum Modificator {
    PUBLIC("public"),
    PRIVATE("private");

    private final String value;

    Modificator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}