package com.spring.graphql.mysql.GraphQl.entity;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_client;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "excluded")
    private Boolean excluded;

    @ManyToOne
    @JoinColumn(name = "master_id", nullable = false)
    private Master master;

    public Client() {
    }

    public Client(String name, String surname, Boolean excluded, Master master) {
        this.name = name;
        this.surname = surname;
        this.excluded = excluded;
        this.master = master;
    }

    public Long getId_client() {
        return id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getExcluded() {
        return excluded;
    }

    public void setExcluded(Boolean excluded) {
        this.excluded = excluded;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Client [id=" + id_client + ", name=" + name + ", surname=" + surname + ", excluded=" + excluded + ", master=" + master + "]";
    }
}