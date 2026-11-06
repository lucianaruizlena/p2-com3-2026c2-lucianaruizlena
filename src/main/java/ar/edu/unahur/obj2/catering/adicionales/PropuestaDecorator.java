package ar.edu.unahur.obj2.catering.adicionales;

import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public abstract class PropuestaDecorator implements Propuesta {

    protected final Propuesta propuesta;

    protected PropuestaDecorator(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    @Override
    public Integer cantidadDeServicios(){
        return propuesta.cantidadDeServicios();
    }

    @Override
    public Boolean incluyeServicio(String nombreDelServicio) {
        return propuesta.incluyeServicio(nombreDelServicio);
    }


    
}
