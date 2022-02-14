package com.uniovi.notaneitor.entities;

public class Professor {
    private Long id;
    private String dni;
    private String name;
    private String apellidos;
    private String categoria;


    public Professor(){

    }
    public Professor(Long id, String dni, String name, String apellidos, String categoria){
        setId(id);
        setDni(dni);
        setName(name);
        setApellidos(apellidos);
        setCategoria(categoria);
    }
    @Override
    public String toString(){
        return "Profesor con dni: "+dni+", con nombre "+name+" y apellidos: "+apellidos+". Categoria: "+categoria;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}


