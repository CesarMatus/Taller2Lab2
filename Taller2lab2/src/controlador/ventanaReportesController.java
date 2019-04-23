/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.VendedorDao;
import dao.VentaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Vendedor;
import modelo.Venta;
import vista.ventanaInicio;
import vista.ventanaReportes;

/**
 *
 * @author cesar
 */
public class ventanaReportesController implements ActionListener{
    ventanaReportes vr;
    ventanaInicio vi; 
    ArrayList <Venta> ventas; 
    ArrayList<Vendedor> vendedores; 
    
    
    private javax.swing.JComboBox<String> mesesBox;
    private VendedorDao vDao = new VendedorDao(); 
    private VentaDao ventaDao = new VentaDao(); 
   
    

    public ventanaReportesController(ventanaReportes vr,ventanaInicio vi,javax.swing.JComboBox<String> mesesBox) {
        this.vr = vr;
        this.vi = vi; 
        this.mesesBox = mesesBox;
        
        
        
        
        vendedores = vDao.getVendedores();
        
          mesesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero","Marzo",
              "Abril", "Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre" }));
    }
    
    //hola que tal?? estamos dao? wua xdxd

    @Override
    public void actionPerformed(ActionEvent ae) {
         
        String nMes = (String) mesesBox.getSelectedItem();
        String mes = transformarMes(nMes); 
        
        ArrayList <Venta> ventillas = ventaDao.getVentasMes(mes);
                
        Vendedor vendedor = buscarMejorVendedor(vendedores,ventillas);
        vr.getjLabelMejorVendedor().setText(vendedor.getNombre()+" "+vendedor.getApellido());
        vr.getjLabelTotalVenta().setText(Integer.toString(totalVenta(vendedor,ventillas)));
        
        vr.getjLabelMejorVenta().setText(mejorVenta(ventillas)+"");
        Vendedor mVVendedor= vendedorMejorVenta(ventillas);  
        vr.getjLabelVendedor().setText(mVVendedor.getNombre()+" "+mVVendedor.getApellido());
        
        vr.getjLabelPromedioVentas().setText(promedioVentas(ventillas)+"");
    }
    
    public Vendedor buscarMejorVendedor (ArrayList<Vendedor> vendedores ,ArrayList <Venta> ventas){
        
        int montoMaximo = 0; 
        int monto; 
//        ArrayList <Venta> ventitas;
        Vendedor v; 
        Vendedor vAux = null;  
        
        for (int i = 0; i < vendedores.size(); i++) {
            v = vendedores.get(i);
            monto=0; 
            for (int j = 0; j < ventas.size(); j++) {
                if(v.getId_vendedor()==ventas.get(j).getVendedor().getId_vendedor()){
                } else { 
                    monto = monto + ventas.get(j).getMonto();
                }
            }
            if(montoMaximo < monto){
                montoMaximo = monto; 
                vAux=v; 
            }
            
        }
        
//        for (int i = 0; i < vendedores.size(); i++) {
//            for (int j = 0; j < 10; j++) {
//                for (int k = 0; k < 10; k++) {
//                    if(ventas.get(j).)
//                }
//            }
//            ventitas = ventaDao.getVentasVendedor(vendedores.get(i).getId_vendedor()); 
//            v = vendedores.get(i);
//            monto = 0;
//            for (int j = 0; j < ventitas.size(); j++) {
//                monto = monto + ventitas.get(j).getMonto(); 
//            }
//               if(montoMaximo<monto){
//                   montoMaximo = monto; 
//                   vAux = v; 
//                }
//                
//        }
//        
        return vAux; 

    }
    
    public int totalVenta(Vendedor v,ArrayList <Venta> ventas){
        int monto = 0; 
        Vendedor vAux = null;  
         
            for (int j = 0; j < ventas.size(); j++) {
                if(v.getId_vendedor() == ventas.get(j).getVendedor().getId_vendedor()){
                } else { 
                    monto = monto + ventas.get(j).getMonto();
                }
            }
        
        return monto; 
    }
    
    public int mejorVenta(ArrayList <Venta> ventas){
        int mejorVenta = 0; 
        int venta;
        Vendedor v = null; 
        Vendedor vAux = null;  
        
        for (int i = 0; i < ventas.size(); i++) {
            v = vendedores.get(i);
            venta = ventas.get(i).getMonto();
            if(mejorVenta<venta){
                mejorVenta= venta; 
                vAux=v; 
            }
            
        }
        
        return mejorVenta;  
    }
    
    public Vendedor vendedorMejorVenta(ArrayList <Venta> ventas){
        int mejorVenta = 0; 
        int venta;
        Vendedor v = null; 
        Vendedor vAux = null;  
        
        for (int i = 0; i < ventas.size(); i++) {
            v = vendedores.get(i);
            venta = ventas.get(i).getMonto();
            if(mejorVenta<venta){
                mejorVenta= venta; 
                vAux=v; 
            }
            
        }
        
        return vAux; 
    }
    
    public int promedioVentas(ArrayList <Venta> ventas){
        int total=0; 
        for (int i = 0; i < ventas.size(); i++) {
            total = total + ventas.get(i).getMonto(); 
        }
        total = total/ventas.size(); 
        
        return total; 
    }
    
    public String transformarMes(String mes){
        switch (mes) {
            case "Enero":
                return "01";
            case "Febrero":
                return "02";
            case "Marzo":
                return "03";
            case "Abril":
                return "04";
            case "Mayo":
                return "05";
            case "Junio":
                return "06";
            case "Julio":
                return "07";
            case "Agosto":
                return "08";
            case "Septiembre":
                return "09";
            case "Octubre":
                return "10";
            case "Noviembre":
                return "11";
            case "Diciembre":
                return "12";
            default:
                return null;    
        }
    }
}
