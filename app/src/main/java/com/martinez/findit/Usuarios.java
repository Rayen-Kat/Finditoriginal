package com.martinez.findit;

public class Usuarios {
    String Id;
    String Nombre;
    String Email;
    String Password;

    public Usuarios() {
    }

    public Usuarios(String id, String nombre, String email, String password) {
        this.Id = id;
        this.Nombre = nombre;
        this.Email = email;
        this.Password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    @Override
    public String toString() {
        return "Usuarios{" +
                "Id='" + Id + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
