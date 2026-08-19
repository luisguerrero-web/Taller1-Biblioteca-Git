package com.mycompany.biblioteca;

public class Client extends Person {
    private String email;

    public Client() {
        super();
    }

    public Client(String email, int id, String name, String phone) {
        super(id, name, phone);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}