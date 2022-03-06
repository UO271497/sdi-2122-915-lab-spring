package com.uniovi.notaneitor.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String name;
    private String surname;
    private String category;

    public Professor(){

    }
    public Professor(Long id, String dni, String name, String surname, String categoria){
        setId(id);
        setDni(dni);
        setName(name);
        setSurname(surname);
        setCategory(categoria);
    }
    @Override
    public String toString(){
        return "Profesor con dni: "+dni+", con nombre "+name+" y apellidos: "+ surname +". Categoria: "+ category;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public void setSurname(String apellidos) {
        this.surname = apellidos;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categoria) {
        this.category = categoria;
    }
}


