package to;

import java.sql.Timestamp;

public class HFacturaTO {

    int idfactura;
    String fechFact;    
    int idcliente;
    int idempleado;
    double stotfact;
    double igvfact;
    double totafact;
    String obsvfact;
    String transa;
    String usuario;
    String fecha;

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public String getFechFact() {
        return fechFact;
    }

    public void setFechFact(String fechFact) {
        this.fechFact = fechFact;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public double getStotfact() {
        return stotfact;
    }

    public void setStotfact(double stotfact) {
        this.stotfact = stotfact;
    }

    public double getIgvfact() {
        return igvfact;
    }

    public void setIgvfact(double igvfact) {
        this.igvfact = igvfact;
    }

    public double getTotafact() {
        return totafact;
    }

    public void setTotafact(double totafact) {
        this.totafact = totafact;
    }

    public String getObsvfact() {
        return obsvfact;
    }

    public void setObsvfact(String obsvfact) {
        this.obsvfact = obsvfact;
    }

    public String getTransa() {
        return transa;
    }

    public void setTransa(String transa) {
        this.transa = transa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    }

    