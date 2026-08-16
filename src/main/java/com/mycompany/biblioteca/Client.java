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
    
    public void CREATE(Client client) {
        listClients.add(client);
        System.out.println("Cliente creado exitosamente");
    }
    
    public Client READ(int searchedId){
        for (Client client : listClients) {
            if (searchedId == client.getId()) {
                return client;
            }
        }
        System.out.println("Cliente no encontrado");
        return null;
    }
    
    public void UPDATE(int actualId, int newId){
        Client client = READ(actualId);
        if (client != null) {
            client.setId(newId);
            System.out.println("Cliente actualizado correctamente");
        } else {
            System.out.println("No se pudo actualizar porque el cliente no existe");
        }
    }
    
    public void DELETE(int deletedId){
        Client client = READ(deletedId);
        if (client != null){
            listClients.remove(client);
            System.out.println("Cliente eliminado correctamente");
        }else{
            System.out.println("No se pudo eliminar porque el cliente no existe");
        }
    }
}
