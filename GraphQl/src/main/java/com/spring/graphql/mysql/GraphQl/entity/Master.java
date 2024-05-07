package com.spring.graphql.mysql.GraphQl.entity;

import jakarta.persistence.*;

@Entity
public class Master
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_master;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "excluded")
    private Boolean excluded;

    public Master()
    {
    }

    public Master(Long id_master)
    {
        this.id_master = id_master;
    }

    public Master(String name, String surname, Boolean excluded) {
        this.name = name;
        this.surname = surname;
        this.excluded = excluded;
    }
    public Long getId_master() {
        return id_master;
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

    @Override
    public String toString() {
        return "Master [id=" + id_master + ", name=" + name + ", surname=" + surname + ", excluded=" + excluded + "]";
    }

}
