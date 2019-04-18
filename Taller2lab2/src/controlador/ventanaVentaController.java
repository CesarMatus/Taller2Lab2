
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import modelo.Vendedor;
import modelo.Venta;
import vista.ventanaVenta;


public final class ventanaVentaController implements ActionListener{
    
    private ventanaVenta vv;
    private javax.swing.JComboBox<String> vendedorBox;
    private javax.swing.JComboBox<String> sucursalBox;
    ArrayList <Venta> ventas = new ArrayList<>(); 
    ArrayList<Vendedor> vendedores = new ArrayList<>();
    
    public ventanaVentaController(ventanaVenta vv, javax.swing.JComboBox<String> vendedorBox,javax.swing.JComboBox<String> sucursalBox) {
        this.vv=vv;
        this.vendedorBox = vendedorBox; 
        
//        String v1 = vendedores.get(0).getNombre()+" "+vendedores.get(0).getApellido(); 
//        String v2 = vendedores.get(1).getNombre()+" "+vendedores.get(1).getApellido(); 
//        String v3 = vendedores.get(2).getNombre()+" "+vendedores.get(2).getApellido(); 
//        String v4 = vendedores.get(3).getNombre()+" "+vendedores.get(3).getApellido(); 
//        vendedorBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { v1, v2, v3, v4}));
        
        sucursalBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Portal Temuco", "Centro", "Outlet Vivo", "Outlet Easton" }));
        
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int idVendedor = vendedores.get(vv.getVendedorBox().getItemCount()).getId(); 
        
        String sucursal = vv.getSucursalBox().getItemAt(vv.getSucursalBox().getItemCount());  
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/mm/yyyy");
        String f = vv.getjTextFieldFecha().getText();
        Date fecha = null; 
        try {
            fecha = (Date) formatoDelTexto.parse(f);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        int monto = Integer.parseInt(vv.getjTextFieldMonto().getText()); 
    }
    
    
    
    
    
}
