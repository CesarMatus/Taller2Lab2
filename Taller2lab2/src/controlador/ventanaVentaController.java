
package controlador;

import dao.VendedorDao;
import dao.VentaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.Vendedor;
import modelo.Venta;
import vista.ventanaVenta;
import java.sql.Date;


public final class ventanaVentaController implements ActionListener{
    
    private ventanaVenta vv;
    private javax.swing.JComboBox<String> vendedorBox;
    private javax.swing.JComboBox<String> sucursalBox;
    private VendedorDao vDao = new VendedorDao(); 
    private VentaDao ventaDao =  new VentaDao(); 
    
    ArrayList<Vendedor> vendedores = new ArrayList<>(); 
    
    public ventanaVentaController(ventanaVenta vv, javax.swing.JComboBox<String> vendedorBox,javax.swing.JComboBox<String> sucursalBox) {
        this.vv=vv;
        this.vendedorBox = vendedorBox; 
        
        System.out.println("bueno");
        
        vendedores = vDao.getVendedores(); 
        
        System.out.println("bueno");
        
        String v1 = vendedores.get(0).getNombre()+" "+vendedores.get(0).getApellido(); 
        String v2 = vendedores.get(1).getNombre()+" "+vendedores.get(1).getApellido(); 
        String v3 = vendedores.get(2).getNombre()+" "+vendedores.get(2).getApellido(); 
        String v4 = vendedores.get(3).getNombre()+" "+vendedores.get(3).getApellido(); 
        vendedorBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { v1, v2, v3, v4}));
        
        sucursalBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "Portal Temuco", "Centro", "Outlet Vivo", "Outlet Easton" }));
        
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int idVendedor = vendedores.get(vv.getVendedorBox().getItemCount()-1).getId_vendedor(); 
        
        Vendedor vendedor = vendedores.get(vv.getVendedorBox().getItemCount()-1);
        
        String sucursal = vv.getSucursalBox().getItemAt(vv.getSucursalBox().getItemCount());  
       
        int monto = Integer.parseInt(vv.getjTextFieldMonto().getText()); 
        
        Venta venta = new Venta(vendedor, sucursal, fechaDate(vv.getjTextFieldFecha().getText()), monto); 
        
        ventaDao.ingresarVenta(venta); 
        
    }
    
    public java.sql.Date fechaDate(String fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Date f = null; 
        try {
            f = (Date) formato.parse(fecha);
        }catch(Exception e){
            System.out.println(e);
        }
        java.sql.Date fechaSQL = new java.sql.Date(f.getTime());
        return fechaSQL;   
    } 
    
    
    
}
