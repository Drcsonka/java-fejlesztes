package com.epam.training.ticketservice.core.user.persistence.entity;

public class Admin {
    private static final String username = "admin";
    private static final String password ="admin";

    private static boolean logedIn = false;
    public static boolean isLogedIn() {
        return logedIn;
    }
    public static void setIsLogedIn(boolean isLogedIn) {
        Admin.logedIn = isLogedIn;
    }
    public static String getUsername() {
        return username;
    }
    public static String getPassword() {
        return password;
    }
}
