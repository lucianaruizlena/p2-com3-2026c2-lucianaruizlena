package ar.edu.unahur.obj2.catering.propuestas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.catering.excepciones.DescuentoEsInvalidoException;

public class Menu implements Propuesta {
    private final String nombre;
    private final Double descuento; 
    private final List<Propuesta> propuestas;

    public Menu(String nombre, Double descuento) {
        this.nombre = nombre;
        this.descuento = validarDescuento(descuento);
        this.propuestas = new ArrayList<>();
    }

    private Double validarDescuento(Double descuento){
        if (descuento < 0 || descuento > 100){
            throw new DescuentoEsInvalidoException("El descuento debe estar entre 0 y 100");
        }
        return descuento;
    }

    @Override
    public Double precio() {
        Double subtotal = 0.0;
        for(Propuesta propuesta : propuestas) {
            subtotal = subtotal + propuesta.precio();
        }
        return subtotal * (1- descuento /100);
    }

    @Override
    public String descripcion() {
        return nombre;
    }

    @Override
    public Integer cantidadDeServicios() {
        Integer cantidad = 0;
        for(Propuesta propuesta : propuestas) {
            cantidad = cantidad + propuesta.cantidadDeServicios();
        }
        return cantidad;
    }

    @Override
    public Boolean incluyeServicio(String nombreDelServicio) {
        for (Propuesta propuesta : propuestas) {
            if (propuesta.incluyeServicio(nombreDelServicio)){
                return true;
            }
        }
        return false;
    }

    public void agregarPropuesta(Propuesta propuesta) {
        propuestas.add(propuesta);
    }
    
}
