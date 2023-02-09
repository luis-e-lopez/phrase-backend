package com.phrase.demo.models;

public class UserAuth {

    private User user;
    private String token;

    public UserAuth() {}

    public UserAuth(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}
