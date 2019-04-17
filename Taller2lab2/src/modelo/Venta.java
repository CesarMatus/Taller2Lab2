
package modelo;

import java.util.Date;


public class Venta {
    private String vendedor;
    private String sucursal;
    private Date fecha;
    private int monto;

    public Venta(String vendedor, String sucursal, Date fecha, int monto) {
        this.vendedor = vendedor;
        this.sucursal = sucursal;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
}
