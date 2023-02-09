package com.phrase.demo.models;

import jakarta.validation.constraints.NotEmpty;

public class CredentialsDto {

    @NotEmpty(message = "The username is required.")
    private String userName;

    @NotEmpty(message = "The password is required.")
    private String password;

    public CredentialsDto() {}

    public CredentialsDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CredentialsDto{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public Credentials toCredentials() {
        return new Credentials()
                .setUserName(userName)
                .setPassword(password);
    }
}
