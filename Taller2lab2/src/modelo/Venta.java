
package modelo;

import java.util.Date;


public class Venta {
    private Vendedor vendedor;
    
    private int id_venta;
    private String sucursal;
    private int monto;
    private Date fecha;
    private int id_vendedor;

    public Venta(Vendedor vendedor, String sucursal, Date fecha, int monto) {
        this.vendedor = vendedor;
        this.sucursal = sucursal;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Venta(int id_venta, String sucursal, int monto, Date fecha, int id_vendedor) {
        this.id_venta = id_venta;
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.id_vendedor = id_vendedor;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
    
    
    
}
