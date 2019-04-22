/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cesar
 */
public class Vendedor {
    private int id_vendedor; 
    private String nombre;
    private String apellido; 
    private String rut; 

    public Vendedor(int id_vendedor, String nombre, String apellido, String rut) {
        this.id_vendedor = id_vendedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    
}
