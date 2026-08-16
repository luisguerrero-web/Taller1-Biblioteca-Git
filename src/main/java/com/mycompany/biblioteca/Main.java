package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Aquí va el menú (fase 8)");
    }

    public static void CREATE(Client client) {
        clients.add(client);
        System.out.println("Cliente creado exitosamente");
    }
    
    public static Client READ(int searchedId){
        for (Client client : clients) {
            if (searchedId == client.getId()) {
                return client;
            }
        }
        System.out.println("Cliente no encontrado");
        return null;
    }
    
    public static void UPDATE(int actualId, int newId){
        Client client = READ(actualId);
        if (client != null) {
            client.setId(newId);
            System.out.println("Cliente actualizado correctamente");
        } else {
            System.out.println("No se pudo actualizar porque el cliente no existe");
        }
    }
    
    public static void DELETE(int deletedId){
        Client client = READ(deletedId);
        if (client != null){
            clients.remove(client);
            System.out.println("Cliente eliminado correctamente");
        }else{
            System.out.println("No se pudo eliminar porque el cliente no existe");
        }
    }
}