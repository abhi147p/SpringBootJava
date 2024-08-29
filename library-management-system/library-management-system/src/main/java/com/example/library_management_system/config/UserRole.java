package com.example.library_management_system.config;

public enum UserRole {

    /**
     * Admin --> Show, edit, delete, add books
     */
    ADMIN,

    /**
     * Publisher --> Show, edit, add books
     */
    PUBLISHER,

    /**
     * Read --> Show books
     */
    READ_ONLY

}
