package com.example.parcialmovil2;

public class Usuarios {
    private String Nombre,Apellido,Teléfono,Dirección,EstadoCivil,Profesión,Estrato,Cargo,NivelEstudio,Id;

    public Usuarios(){

    }
    public Usuarios(String nombre, String apellido, String teléfono, String dirección, String estadoCivil, String profesión, String estrato,String cargo,String nivelestudio,String id) {
        Nombre = nombre;
        Apellido = apellido;
        Teléfono = teléfono;
        Dirección = dirección;
        EstadoCivil = estadoCivil;
        Profesión = profesión;
        Estrato = estrato;
        Cargo = cargo;
        NivelEstudio = nivelestudio;
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTeléfono() {
        return Teléfono;
    }

    public void setTeléfono(String teléfono) {
        Teléfono = teléfono;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String dirección) {
        Dirección = dirección;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        EstadoCivil = estadoCivil;
    }

    public String getProfesión() {
        return Profesión;
    }

    public void setProfesión(String profesión) {
        Profesión = profesión;
    }

    public String getEstrato() {
        return Estrato;
    }

    public void setEstrato(String estrato) {
        Estrato = estrato;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getNivelEstudio() {
        return NivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        NivelEstudio = nivelEstudio;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
