
package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
        
public class Main {
    
    static ArrayList<Client> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Aquí va el menú (fase 8)");
    }
    
    void CREATE(){
        System.out.println("Registrar nuevo cliente");
        System.out.println("Ingrese el id: ");
        String id = sc.nextLine();
    }
    
}
