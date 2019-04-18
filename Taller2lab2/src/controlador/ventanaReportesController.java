/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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

    public ventanaReportesController(ventanaReportes vr,ventanaInicio vi) {
        this.vr = vr;
        this.vi = vi; 
    }
    
    //hola que tal?? estamos dao? wua xdxd

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        
        
        
        
        /*vr.getjLabelMejorVendedor().setText(string);
        vr.getjLabelTotalVenta().setText(string);
        
        vr.getjLabelMejorVenta().setText(string);
        vr.getjLabelVendedor().setText(string);
        
        vr.getjLabelPromedioVentas().setText(string);*/
    }
    
    public Vendedor buscarMejorVendedor (){
        
        ArrayList <Venta> ventas = new ArrayList<>(); 
        ArrayList<Vendedor> vendedores = new ArrayList<>(); 
         
        Vendedor vAux = null; 
        
        Vendedor ve = null;
        int mayor = 0; 
        int aux = 0; 
        
        for (int j = 0; j < 4; j++) {
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
}
