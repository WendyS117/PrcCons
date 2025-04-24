package com.mycompany.gym;

public class UsuarioResumen {
    private String nombre;
    private String numeroUsuario;
    private String suscripcion;

    public UsuarioResumen(String nombre, String numeroUsuario, String suscripcion) {
        this.nombre = nombre;
        this.numeroUsuario = numeroUsuario;
        this.suscripcion = suscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroUsuario() {
        return numeroUsuario;
    }

    public String getSuscripcion() {
        return suscripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroUsuario(String numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public void setSuscripcion(String suscripcion) {
        this.suscripcion = suscripcion;
    }
}


