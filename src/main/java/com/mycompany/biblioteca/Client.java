/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Client extends Person{
    private String email;
    private List<Client> listClients;

    public Client() {
        this.listClients = new ArrayList<>();
    }

    public Client(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
