package ar.edu.unahur.obj2.catering.propuestas;

import ar.edu.unahur.obj2.catering.excepciones.PrecioEsNegativoException;

public class Servicio implements Propuesta {
    private final String nombre;
    private Double precio;
    
    public Servicio(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = validarPrecio(precio);
    }

    @Override
    public Double precio() {
        return precio;
    }

    @Override
    public String descripcion() {
        return nombre;
    }

    @Override
    public Integer cantidadDeServicios() {
        return 1;
    }

    @Override
    public Boolean incluyeServicio(String nombreDelServicio) {
        return nombre.equals(nombreDelServicio);
    }

    private Double validarPrecio(Double precio) {
        if (precio < 0) {
            throw new PrecioEsNegativoException("El precio no puede ser menor a 0.");
        }
        return precio;
    }

    public void actualizarPrecio(Double nuevoPrecio) {
        precio = validarPrecio(nuevoPrecio);
    }

}
