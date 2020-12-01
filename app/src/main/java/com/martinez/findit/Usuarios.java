package com.martinez.findit;

public class Usuarios {
    String Nombre;
    String Email;
    String Password;

    public Usuarios(String nombre, String email, String password) {
        this.Nombre = nombre;
        this.Email = email;
        this.Password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
