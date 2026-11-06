package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.propuestas.Menu;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;

public class ServicioTest {

    @Test 
    public void dadoUnMenuConServicios_alCaslcularElPrecio_aplicaElDescuentoDelMenu() {
        Menu menu = new Menu("Menu De Parrilla", 10.0);
        menu.agregarPropuesta(new Servicio("Entrada", 30000.0));
        menu.agregarPropuesta(new Servicio("Parrillada", 80000.0));
        menu.agregarPropuesta(new Servicio("Postre", 30000.0));

        Double precio = menu.precio();

        assertEquals(126000.0, precio);

    }

}
