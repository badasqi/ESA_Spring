package com.example.esaSpring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "provider")
public class Provider implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprovider")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Client> clients = new ArrayList<>();

    public Provider (){}

    public Provider(String name){
        this.name = name;
    }

    public static Provider create(Map<String, String> map) {
        Provider provider = new Provider();
        if (map.containsKey("name")) {
            provider.setName(map.get("name"));
        }

        return provider;
    }
    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    // Геттер и сеттер для списка клиентов
    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }


    // Методы для добавления и удаления клиентов
    public void addClient(Client client) {
        clients.add(client);
        client.setNameProvider(this.name);
    }
    public void removeClient(Client client) {
        clients.remove(client);
        client.setNameProvider(null);
    }

}