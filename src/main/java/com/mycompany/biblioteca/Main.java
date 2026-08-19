package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option = -1;

        do {
            System.out.println("\nSISTEMA DE GESTION BIBLIOTECA ");
            System.out.println("=================================");
            System.out.println("--- MENU DE CLIENTES ---");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Actualizar ID de Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("--- MENU DE LIBROS ---");
            System.out.println("5. Crear Libro");
            System.out.println("6. Buscar Libro");
            System.out.println("7. Listar Libros");
            System.out.println("8. Actualizar Código de Libro");
            System.out.println("9. Eliminar Libro");
            System.out.println("--- MENU DE PRÉSTAMOS ---");
            System.out.println("10. Registrar Préstamo");
            System.out.println("11. Listar Préstamos");
            System.out.println("12. Registrar Devolución");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                option =sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("\n--- CREAR CLIENTE ---");
                        System.out.print("Ingrese el id: ");
                        int clientId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese  el nombre: ");
                        String clientName = sc.nextLine();
                        System.out.print("Ingrese el telefono: ");
                        String clientPhone= sc.nextLine();
                        System.out.print("Ingrese el email: ");
                        String clientEmail=sc.nextLine();
                        Client newClient= new Client();
                        newClient.setId(clientId);
                        newClient.setName(clientName);
                        newClient.setPhone(clientPhone);
                        newClient.setEmail(clientEmail);
                        createClient(newClient);
                        break;
                    case 2:
                        System.out.print("\nIngrese el id del cliente a buscar: ");
                        int searchClientId =sc.nextInt();
                        sc.nextLine();
                        Client foundClient =readClient(searchClientId);
                        if (foundClient != null) {
                            System.out.println("Cliente encontrado: " + foundClient.getName() + " | Email: " + foundClient.getEmail());
                        }
                        break;
                    case 3:
                        System.out.print("\nIngrese el id actual del cliente: ");
                        int currentId = sc.nextInt();
                        System.out.print("Ingrese el nuevo id: ");
                        int newId = sc.nextInt();
                        sc.nextLine();
                        updateClient(currentId, newId);
                        break;
                    case 4:
                        System.out.print("\nIngrese el id del cliente a eliminar: ");
                        int deleteClientId = sc.nextInt();
                        sc.nextLine();
                        deleteClient(deleteClientId);
                        break;
                    case 5:
                        System.out.println("\n--- CREAR LIBRO ---");
                        System.out.print("Ingrese el codigo del libro: ");
                        String bookCode = sc.nextLine();
                        System.out.print("Ingrese el titulo del libro: ");
                        String bookTitle = sc.nextLine();
                        System.out.print("Ingrese el autor: ");
                        String bookAuthor = sc.nextLine();
                        System.out.print("Ingrese el anio de publicacion: ");
                        String yearPublic = sc.nextLine();
                        Book newBook = new Book();
                        newBook.setCode(bookCode);
                        newBook.setTittle(bookTitle);
                        newBook.setAuthor(bookAuthor);
                        newBook.setYearPublic(yearPublic);
                        newBook.setAvailable(true);
                        createBook(newBook);
                        break;
                    case 6:
                        System.out.print("\nIngrese el codigo del libro a buscar: ");
                        String searchCode = sc.nextLine();
                        Book foundBook = readBook(searchCode);
                        if (foundBook != null) {
                            System.out.println("Libro encontrado: " + foundBook.getTittle() + " | Autor: " + foundBook.getAuthor());
                        }
                        break;
                    case 7:
                        System.out.println();
                        listBook();
                        break;
                    case 8:
                        System.out.print("\nIngrese codigo actual del libro: ");
                        String currentCode = sc.nextLine();
                        System.out.print("Ingrese el nuevo Código: ");
                        String newCode = sc.nextLine();
                        updateBook(currentCode, newCode);
                        break;
                    case 9:
                        System.out.print("\nIngrese codigo del libro a eliminar: ");
                        String deleteBookCode = sc.nextLine();
                        deleteBook(deleteBookCode);
                        break;
                    case 10:
                        System.out.println("\n--- REGISTRAR PRÉSTAMO ---");
                        System.out.print("Ingrese ID del préstamo: ");
                        String loanId = sc.nextLine();
                        System.out.print("Ingrese ID del cliente: ");
                        int loanClientId = sc.nextInt();
                        sc.nextLine();
                        Client loanClient = readClient(loanClientId);
                        if (loanClient == null) {
                            System.out.println("No se puede realizar el préstamo sin un cliente válido.");
                            break;
                        }
                        System.out.print("Ingrese Código del libro a prestar: ");
                        String loanBookCode = sc.nextLine();
                        Book loanBook = readBook(loanBookCode);
                        if (loanBook == null) {
                            System.out.println("No se puede realizar el prestamo sin un libro valido.");
                            break;
                        }
                        Loan newLoan = new Loan();
                        newLoan.setLoanId(loanId);
                        newLoan.setClient(loanClient);
                        newLoan.setBook(loanBook);
                        newLoan.setDate(java.time.LocalDate.now());
                        createLoan(newLoan);
                        break;
                    case 11:
                        System.out.println();
                        listLoans();
                        break;
                    case 12:
                        System.out.print("\nIngrese el codigo del libro a devolver: ");
                        String returnCode = sc.nextLine();
                        devolution(returnCode);
                        break;
                    case 0:
                        System.out.println("\nSaliendo del programa");
                        break;
                    default:
                        System.out.println("\nOpcion no valida, intente otra vez");
                }

            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un dato válido.");
                sc.nextLine();
            }
        } while (option != 0);
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