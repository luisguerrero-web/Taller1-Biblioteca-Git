package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Aquí va el menú (fase 8)");
    }

    public static void createClient(Client client) {
        clients.add(client);
        System.out.println("Cliente creado exitosamente");
    }
    
    public static void createBook(Book book) {
        books.add(book);
        System.out.println("Libro creado exitosamente");
    }
    
    public static Client readClient(int searchedId){
        for (Client client : clients) {
            if (searchedId == client.getId()) {
                return client;
            }
        }
        System.out.println("Cliente no encontrado");
        return null;
    }
    
    public static Book readBook (String searchedCode){
        for (Book book : books) {
            if (searchedCode.equals(book.getCode())) {
                return book;
            }
        }
        System.out.println("Libro no encontrado");
        return null;
    }
    
    public static void listBook(){
        
    }
    
    public static void updateClient(int actualId, int newId){
        Client client = readClient(actualId);
        if (client != null) {
            client.setId(newId);
            System.out.println("Cliente actualizado correctamente");
        } else {
            System.out.println("No se pudo actualizar porque el cliente no existe");
        }
    }
    
    public static void updateBook(String actualCode, String newCode){
        Book book = readBook(actualCode);
        if (book != null) {
            book.setCode(newCode);
            System.out.println("Libro actualizado correctamente");
        } else {
            System.out.println("No se pudo actualizar porque el Libro no existe");
        }
    }
    
    public static void deleteClient(int deletedId){
        Client client = readClient(deletedId);
        if (client != null){
            clients.remove(client);
            System.out.println("Cliente eliminado correctamente");
        }else{
            System.out.println("No se pudo eliminar porque el cliente no existe");
        }
    }
    
    public static void deleteBook(String deletedCode){
        Book book = readBook(deletedCode);
        if (book != null){
            books.remove(book);
            System.out.println("Libro eliminado correctamente");
        }else{
            System.out.println("No se pudo eliminar porque el Libro no existe");
        }
    }
}