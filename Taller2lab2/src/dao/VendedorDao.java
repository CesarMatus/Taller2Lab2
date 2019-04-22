/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Vendedor;

/**
 *
 * @author cesar
 */
public class VendedorDao {
    Conexion con;
    private VendedorDao vDao; 

    public VendedorDao(/*Conexion con*/) {
        this.con = new Conexion();
    }
    
    public ArrayList<Vendedor> getVendedores(){
        ArrayList<Vendedor> vendedores = vDao.getVendedores();
        Connection accesoBD = con.getConexion();
        try{
            String sql="SELECT * FROM vendedor ";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while ( resultados.next() ) {
                int id_vendedor= Integer.parseInt(resultados.getString("id_vendedor"));
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String rut = resultados.getString("rut");               
                
                vendedores.add(new Vendedor(id_vendedor, nombre, apellido, rut));
            }
            accesoBD.close();
            return vendedores;
            
        }catch(Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
        
        
    } 
}
