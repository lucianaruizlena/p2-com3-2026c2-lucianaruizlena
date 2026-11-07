package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.excepciones.DescuentoEsInvalidoException;
import ar.edu.unahur.obj2.catering.excepciones.PrecioEsNegativoException;
import ar.edu.unahur.obj2.catering.propuestas.Menu;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;

public class PropuestasTest {

    @Test
    public void dadoUnServicioConPrecioNegativo_alCrearlo_lanzaPrecioNegativoException() {
        Double precioNegativo = -1.0;

        assertThrows(PrecioEsNegativoException.class, () -> new Servicio("Postre", precioNegativo));
    }

    @Test 
    public void dadoUnMenuConServicios_alCaslcularElPrecio_aplicaElDescuentoDelMenu() {
        Menu menu = new Menu("Menu De Parrilla", 10.0);
        menu.agregarPropuesta(new Servicio("Entrada", 30000.0));
        menu.agregarPropuesta(new Servicio("Parrillada", 80000.0));
        menu.agregarPropuesta(new Servicio("Postre", 30000.0));

        Double precio = menu.precio();

        assertEquals(126000.0, precio);

    }

    @Test
    public void dadoUnMenuConDescuentoFueraDeRango_alCrearlo_lanzaDescuentoInvalidoException() {
        Double descuentoInvalido = 101.0;

        assertThrows(DescuentoEsInvalidoException.class, () -> new Menu("Inválido", descuentoInvalido));
    }

    @Test
    public void dadoUnMenuConServicios_alContarDosServicios_sumaDosServicios() {
        Menu menu = new Menu("Cumpleanios", 5.0);
        menu.agregarPropuesta(new Servicio("Barra ilimitada de tragos", 150000.0));
        menu.agregarPropuesta(new Servicio("Musica privada", 120000.0));

        Integer cantidad = menu.cantidadDeServicios();

        assertEquals(2, cantidad);
    }

    @Test
    public void dadoUnMenuQueContieneOtrosMenus_alContarServicios_sumaLosDeTodosLosNiveles() {

        Menu menuParrillero = new Menu("Menú Parrillero", 10.0);
        menuParrillero.agregarPropuesta(new Servicio("Entrada", 80000.0));
        menuParrillero.agregarPropuesta(new Servicio("Parrilla completa", 240000.0));
        menuParrillero.agregarPropuesta(new Servicio("Postre", 60000.0));

        Menu packCumple = new Menu("Cumpleanios", 5.0);
        packCumple.agregarPropuesta(new Servicio("Barra ilimitada de tragos", 150000.0));

        Menu packCompleto = new Menu("Pack Completo", 20.0);
        packCompleto.agregarPropuesta(menuParrillero);
        packCompleto.agregarPropuesta(packCumple);
        packCompleto.agregarPropuesta(new Servicio("Brindis de bienvenida", 50000.0));

        Integer cantidad = packCompleto.cantidadDeServicios();

        assertEquals(5, cantidad);
}

    @Test
    public void dadoUnServicio_alConsultarSiIncluyeUnServicio_soloCoincideConSuNombre() {
        Servicio servicio = new Servicio("Musica privada", 120000.0);

        boolean incluyeMismoNombre = servicio.incluyeServicio("Musica privada");
        boolean incluyeOtroNombre = servicio.incluyeServicio("Fotógrafo");

        assertEquals(true, incluyeMismoNombre);
        assertEquals(false, incluyeOtroNombre);
    }


}
