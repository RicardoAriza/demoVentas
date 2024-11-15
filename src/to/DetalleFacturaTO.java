package to;

import java.sql.Timestamp;

public class DetalleFacturaTO {

    int idfactura;
    int idproducto;
    double precio;
    int cantidad;
    double importe;

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getImporte() {
        return importe;
    }

}
