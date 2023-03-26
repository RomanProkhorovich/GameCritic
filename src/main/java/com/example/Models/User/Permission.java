package com.example.Models.User;

public enum Permission {
    DEVELOPER_READ("developers:read"),
    DEVELOPER_WRITE("developers:write");
    private final String  permission;

    public String getPermission() {
        return permission;
    }

    Permission(String permission) {
        this.permission = permission;
    }
}
