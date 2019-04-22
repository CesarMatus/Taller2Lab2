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
    VendedorDao vDao; 
    VentaDao ventaDao; 
    ArrayList <Venta> ventas; 
    ArrayList<Vendedor> vendedores; 
    private javax.swing.JComboBox<String> mesesBox;
    

    public ventanaReportesController(ventanaReportes vr,ventanaInicio vi,javax.swing.JComboBox<String> mesesBox) {
        this.vr = vr;
        this.vi = vi; 
        this.mesesBox = mesesBox;
        ventas = ventaDao.getVenta(); 
        vendedores = vDao.getVendedores(); 
        
        
          mesesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero","Marzo",
              "Abril", "Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre" }));
    }
    
    //hola que tal?? estamos dao? wua xdxd

    @Override
    public void actionPerformed(ActionEvent ae) {
          
        
        
        Vendedor vendedor = buscarMejorVendedor();
        vr.getjLabelMejorVendedor().setText(vendedor.getNombre()+" "+vendedor.getApellido());
        vr.getjLabelTotalVenta().setText(totalVenta(vendedor)+"");
        
        vr.getjLabelMejorVenta().setText(mejorVenta()+"");
        Vendedor mVVendedor= vendedorMejorVenta(mejorVenta()); 
        vr.getjLabelVendedor().setText(mVVendedor.getNombre()+" "+mVVendedor.getApellido());
        
        vr.getjLabelPromedioVentas().setText(promedioVentas()+"");
    }
    
    public Vendedor buscarMejorVendedor (){
        
        Vendedor vAux = null; 
        
        Vendedor ve = null;
        int mayor = 0; 
        int aux = 0; 
        
        for (int j = 0; j < vendedores.size(); j++) {
            ve = vendedores.get(j);
            for (int i = 0; i < ventas.size(); i++) {
                Venta v = ventas.get(i);
                if(v.getVendedor().equals(ve)){
                    aux++; 
                    if(mayor<aux){
                       mayor=aux;
                       vAux=ve; 
                    }
                }
            
            }
        }
        
        return vAux;
    }
    
    public int totalVenta(Vendedor ve){
        int total=0; 
        
        for (int i = 0; i < ventas.size(); i++) {
            if(ventas.get(i).getVendedor().equals(ve)){
                total=total+ventas.get(i).getMonto();
            }
        }
        return total; 
    }
    
    public int mejorVenta(){
        int mVenta = 0; 
        Vendedor ve; 
        for (int j = 0; j < vendedores.size(); j++) {
            ve = vendedores.get(j);
            for (int i = 0; i < ventas.size(); i++) {
                if(ventas.get(i).getVendedor().equals(ve)){
                    if(mVenta<ventas.get(i).getMonto()){
                        mVenta=ventas.get(i).getMonto(); 
                    }
                }
            }
        }
        return mVenta; 
    }
    
    public Vendedor vendedorMejorVenta(int monto){
        Vendedor v= null;  
        for (int i = 0; i < ventas.size(); i++) {
            if(ventas.get(i).getMonto()==monto){
                v = ventas.get(i).getVendedor(); 
            }
            
        }
        return v; 
    }
    
    public int promedioVentas(){
        int total=0; 
        for (int i = 0; i < ventas.size(); i++) {
            total = total + ventas.get(i).getMonto(); 
        }
        total = total/ventas.size(); 
        
        return total; 
    }
}
