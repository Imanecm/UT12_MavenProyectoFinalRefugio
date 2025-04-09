/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Animal implements Comparable<Animal>{
    //VARIABLES
    private int idRegistro;
    private String nombre;
    private String raza;
    private int anos;
    private String fechaDeIngreso;
    enum Estado {adoptado, enPaseo, reservado, rehabilitacion, enAdopcion};
    private Estado estado;

    //CONSTRUCTORES
    public Animal() {
    }

    public Animal(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }

    public Animal(int idRegistro, String nombre, String raza, int anos, String fechaDeIngreso, Estado estado) {
        this.idRegistro = idRegistro;
        this.nombre = nombre;
        this.raza = raza;
        this.anos = anos;
        this.fechaDeIngreso = fechaDeIngreso;
        this.estado = estado;
    }
    

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return "Animal{" + "idRegistro=" + idRegistro + ", nombre=" + nombre + ", raza=" + raza + ", anos=" + anos + ", fechaDeIngreso=" + fechaDeIngreso + ", estado=" + estado + '}';
    }
    
    //COMPARETO AL TENER IMPLEMENTADO EL COMPARE-TO
    @Override
    public int compareTo(Animal o) {
       return this.nombre.compareToIgnoreCase(o.nombre); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
