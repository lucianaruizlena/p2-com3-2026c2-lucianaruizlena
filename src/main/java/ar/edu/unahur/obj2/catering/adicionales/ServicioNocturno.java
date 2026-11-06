package ar.edu.unahur.obj2.catering.adicionales;

import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class ServicioNocturno extends PropuestaDecorator {

    public ServicioNocturno(Propuesta propuesta) {
        super(propuesta);
    }

    @Override
    public Double precio() {
        return propuesta.precio() * 1.20;
    }

    @Override
    public String descripcion() {
        return propuesta.descripcion() + " + servicio nocturno";
    }
}
