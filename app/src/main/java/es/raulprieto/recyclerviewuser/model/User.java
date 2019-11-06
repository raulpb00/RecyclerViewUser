package es.raulprieto.recyclerviewuser.model;

import androidx.annotation.NonNull;

public class User {
    private String user;
    private String email;

    public User(String user, String email) {
        this.user = user;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "user:'" + user + '\'' +
                ", email:'" + email + '\'' +
                '}';
    }
}
