
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import modelo.Vendedor;
import modelo.Venta;


public class VentaDao {
    /*INSERT INTO `venta` (`id_venta`, `sucursal`, `monto`, `fecha`, `id_vendedor`)
    VALUES (NULL, 'portal', '20000', '2019-04-17', '2');*/
    
    Conexion con;

    public VentaDao(/*Conexion con*/) {
        this.con = new Conexion();
    }
    
     public ArrayList<Venta> getVenta(){
        
        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();
        
//        Venta venta= null;
//        Vendedor vendedor = null;
        
        
        try{
            String sql="SELECT * FROM venta";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while ( resultados.next() ) {
                
//                Vendedor vendedor = resultados.getObject(sql);
                
                
                int id_venta= Integer.parseInt(resultados.getString("id_venta"));
                String sucursal = resultados.getString("sucursal");
                Date fecha = resultados.getDate("fecha");
                int monto = Integer.parseInt(resultados.getString("monto"));
               
                ventas.add(new Venta(id_venta, sucursal, monto, fecha, monto));
                
            }
            accesoBD.close();
            return ventas;
            
        }catch(Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
        
        
    } 
     
      public boolean ingresarVenta(Venta vnt){
        Connection accesoBD = con.getConexion();
        boolean resp = false;
        
        try{
            String sql= "INSERT INTO venta VALUES ( NULL ,'"+vnt.getSucursal()+"', '"+vnt.getMonto()+"', '"+vnt.getFecha()+"','"+vnt.getId_vendedor()+"')";
            
            Statement st = accesoBD.createStatement();
            
            st.executeUpdate(sql);
            
            resp = true;
            accesoBD.close();
            
        } catch (Exception e){
            
            System.out.println("Error");
            e.printStackTrace();
        }
        return resp;    
    }
      public ArrayList<Venta> getVentasMes(String mes){
        
        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM venta WHERE fecha BETWEEN '2019-"+mes+"-01' and '2018-10-31'";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                
                int idVenta = Integer.parseInt(resultados.getString("id_venta"));
                String sucursal = resultados.getString("sucursal");
                int monto = Integer.parseInt(resultados.getString("monto"));
                Date fecha = resultados.getDate("fecha");
                int idVendedor = Integer.parseInt(resultados.getString("id_vendedor"));
                
                ventas.add(new Venta(idVenta,sucursal,monto,fecha,idVendedor));
            }
            accesoBD.close();
            return ventas;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
      }
      
      public ArrayList<Venta> getVentasVendedor(int idVndr){
        
        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM venta WHERE id_vendedor='"+idVndr+"'";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int idVenta = Integer.parseInt(resultados.getString("id_venta"));
                String sucursal = resultados.getString("sucursal");
                int monto = Integer.parseInt(resultados.getString("monto"));
                Date fecha = resultados.getDate("fecha");
                int idVendedor = Integer.parseInt(resultados.getString("id_vendedor"));
                ventas.add(new Venta(idVenta,sucursal,monto,fecha,idVendedor));
            }
            accesoBD.close();
            return ventas;
            
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }
}
