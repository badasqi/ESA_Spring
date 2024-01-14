package com.example.esaSpring.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclient")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    @Column(name = "tariff")
    private String tariff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idprovider")
    private Provider provider;

    public Client() {
    }

    public Client(String name, String address, String contact, String tariff, Provider provider) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.tariff = tariff;
        this.provider = provider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getNameProvider() {
        return this.provider.getName();
    }

    public void setNameProvider(String nameProvider) {
        this.provider.setName(nameProvider);
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
