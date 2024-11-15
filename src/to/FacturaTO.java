package to;

import java.sql.Timestamp;

public class FacturaTO {

    int idfactura;
    Timestamp fechdate;
    int idcliente;
    int idempleado;
    double stotfact;
    double igvfact;
    double totafact;
    String obsvfact;

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public void setFechdate(Timestamp fechdate) {
        this.fechdate = fechdate;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public void setStotfact(double stotfact) {
        this.stotfact = stotfact;
    }

    public void setIgvfact(double igvfact) {
        this.igvfact = igvfact;
    }

    public void setTotafact(double totafact) {
        this.totafact = totafact;
    }

    public void setObsvfact(String obsvfact) {
        this.obsvfact = obsvfact;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public Timestamp getFechdate() {
        return fechdate;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public double getStotfact() {
        return stotfact;
    }

    public double getIgvfact() {
        return igvfact;
    }

    public double getTotafact() {
        return totafact;
    }

    public String getObsvfact() {
        return obsvfact;
    }
}
