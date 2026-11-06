package ar.edu.unahur.obj2.catering;

import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class Contrato {
    private final String nombreCliente;
    private final Double importe;
    private final String descripcion;

    public Contrato(String nombreCliente, Propuesta propuesta) {
        this.nombreCliente = nombreCliente;
        this.importe = propuesta.precio();
        this.descripcion = propuesta.descripcion();
    } 

    public String getNombreCliente(){
        return nombreCliente;
    }

    public Double getImporte(){
        return importe;
    }

    public String getDescripcion(){
        return descripcion;
    }
    
}
