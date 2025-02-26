package com.projeto.projeto.models;

public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    PACIENT("pacient"),
    DOCTOR("doctor");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
