
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

    public VentaDao(Conexion con) {
        this.con = con;
    }
    
     public ArrayList<Venta> getVenta(){
        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();
        try{
            String sql="SELECT * FROM venta ";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while ( resultados.next() ) {
                
                
//                ***Vendedor vendedor = resultados.getObject(Vendedor);
//                
                
                Date fecha = resultados.getDate(sql);
                
                int id= Integer.parseInt(resultados.getString("id"));
                
                
                
//                ventas.add(new Venta(apellido, sql, fecha, id));
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
}
