/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author Alejandro
 */
public class Libro extends Material{
    private String author;
    private boolean available;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author; 
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Libro() {
        super();
    }

    public Libro(String author, boolean available, String Code, String Tittle, String yearPublic) {
        super(Code, Tittle, yearPublic);
        this.author = author;
        this.available = available;
    }
    
    
    
}
