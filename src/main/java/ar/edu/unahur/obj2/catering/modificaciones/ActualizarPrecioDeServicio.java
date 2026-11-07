package ar.edu.unahur.obj2.catering.modificaciones;

import ar.edu.unahur.obj2.catering.propuestas.Servicio;

public class ActualizarPrecioDeServicio implements Modificacion {
    private Servicio servicio;
    private Double nuevoPrecio;
    private Double precioAnterior;

    public ActualizarPrecioDeServicio(Servicio servicio, Double nuevoPrecio) {
        this.servicio = servicio;
        this.nuevoPrecio = nuevoPrecio;
    }

    @Override
    public void aplicar() {
        Double precioActual = servicio.precio();
        servicio.actualizarPrecio(nuevoPrecio);
        precioAnterior = precioActual;
    }

    @Override
    public void deshacer() {
        servicio.actualizarPrecio(precioAnterior);
    }
}