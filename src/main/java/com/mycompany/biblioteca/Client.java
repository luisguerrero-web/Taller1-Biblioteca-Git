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
    
    public void SEARCHCLIENT(){
        if (listClients.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            System.out.println("Lista de clientes: ");
            for(Client client : listClients){
                System.out.println("Id: "+client.getId());
                System.out.println("Nombre: "+client.getName());
                System.out.println("TElefono: "+client.getPhone());
                System.out.println("Email: "+client.getEmail());
            }
        }
    }
}
