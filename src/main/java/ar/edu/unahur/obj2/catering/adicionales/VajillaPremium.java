package ar.edu.unahur.obj2.catering.adicionales;

import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class VajillaPremium extends PropuestaDecorator {

    public VajillaPremium(Propuesta propuesta){
        super(propuesta);
    }

    @Override
    public Double precio() {
        return propuesta.precio() + 12000.0;
    }

    @Override
    public String descripcion() {
        return propuesta.descripcion() + " + vajilla premium";
    }



}
