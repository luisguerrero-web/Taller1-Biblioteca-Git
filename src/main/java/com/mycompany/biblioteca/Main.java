package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("aquí va el menú (fase 8)");
    }

    public static void createClient(Client client) {
        clients.add(client);
        System.out.println("cliente creado exitosamente");
    }
    
    public static void createBook(Book book) {
        books.add(book);
        System.out.println("libro creado exitosamente");
    }
    
    public static void createLoan(Loan loan) {
        if (loan.getBook().isAvailable()) {
            loan.getBook().setAvailable(false);
            loan.setStatus("activo");
            loans.add(loan);
            System.out.println("prestamo creado exitosamente");
        } else {
            System.out.println("no se pudo crear el prestamo");
        }
    }
    
    public static Client readClient(int searchedId){
        for (Client client : clients) {
            if (searchedId == client.getId()) {
                return client;
            }
        }
        System.out.println("cliente no encontrado");
        return null;
    }
    
    public static Book readBook (String searchedCode){
        for (Book book : books) {
            if (searchedCode.equals(book.getCode())) {
                return book;
            }
        }
        System.out.println("libro no encontrado");
        return null;
    }
    
    public static void listBook(){
        if (books.isEmpty()) {
            System.out.println("no hay libros registrados");
        } else {
            System.out.println("lista de libros:");
            for (Book book : books) {
                System.out.println("Codigo: " + book.getCode() + 
                                   " | Titulo: " + book.getTittle() + 
                                   " | Disponible: " + (book.isAvailable() ? "Sí" : "No"));
            }
        }
    }
    
    public static void listLoans(){
        if (loans.isEmpty()) {
            System.out.println("no hay prestamos registrados");
        } else {
            System.out.println("lista de prestamos:");
            for (Loan loan : loans) {
                System.out.println("Id del prestamo: " + loan.getLoanId() + 
                                   " | Cliente: " + loan.getClient().getName() + 
                                   " | Libro: " + loan.getBook().getTittle() +
                                   " | Fecha: " + loan.getDate() +
                                   " | Estado: " + loan.getStatus());
            }
        }
    }
    
    public static void updateClient(int actualId, int newId){
        Client client = readClient(actualId);
        if (client != null) {
            client.setId(newId);
            System.out.println("cliente actualizado correctamente");
        } else {
            System.out.println("no se pudo actualizar porque el cliente no existe");
        }
    }
    
    public static void updateBook(String actualCode, String newCode){
        Book book = readBook(actualCode);
        if (book != null) {
            book.setCode(newCode);
            System.out.println("libro actualizado correctamente");
        } else {
            System.out.println("no se pudo actualizar porque el Libro no existe");
        }
    }
    
    public static void deleteClient(int deletedId){
        Client client = readClient(deletedId);
        if (client != null){
            clients.remove(client);
            System.out.println("cliente eliminado correctamente");
        }else{
            System.out.println("no se pudo eliminar porque el cliente no existe");
        }
    }
    
    public static void deleteBook(String deletedCode){
        Book book = readBook(deletedCode);
        if (book != null){
            books.remove(book);
            System.out.println("libro eliminado correctamente");
        }else{
            System.out.println("no se pudo eliminar porque el libro no existe");
        }
    }
    
    public static void devolution(String returnedBookCode){
        Book book = readBook(returnedBookCode);
        if (book != null) {
            boolean activeLoanFound = false;
            for (Loan loan : loans) {
                if (loan.getBook().getCode().equals(returnedBookCode) && "activo".equalsIgnoreCase(loan.getStatus())) {
                    loan.setStatus("devuelto");
                    activeLoanFound = true;
                    break;
                }
            }
            if (activeLoanFound) {
                book.setAvailable(true);
                System.out.println("devolucion procesada correctamente");
            } else {
                System.out.println("el libro existe, pero no tiene un prestamo activo");
            }
            
        } else {
            System.out.println("este libro no existe en el sistema");
        }
    }
}