package ar.edu.unahur.obj2.catering;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.adicionales.MozoAdicional;
import ar.edu.unahur.obj2.catering.propuestas.Menu;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;

public class ContratoTest {

    @Test
    public void dadoUnContratoCreadoConUnaPropuesta_alConsultarSusDatos_fijaImporteYDescripcion() {
        Menu menu = new Menu("Menú Parrillero", 10.0);
        menu.agregarPropuesta(new Servicio("Entrada", 80000.0));
        menu.agregarPropuesta(new Servicio("Parrilla", 240000.0));
        menu.agregarPropuesta(new Servicio("Postre", 60000.0));
        MozoAdicional propuesta = new MozoAdicional(menu);

        Contrato contrato = new Contrato("Lucia", propuesta);

        assertEquals("Lucia", contrato.getNombreCliente());
        assertEquals(360000.0, contrato.getImporte());
        assertEquals("Menú Parrillero + mozos adicionales", contrato.getDescripcion());
    }

    @Test
    public void dadoUnContratoCreado_alActualizarElPrecioDeUnServicioElImporteContratado_noCambia() {
        Servicio parrillada = new Servicio("Parrilla completa", 240000.0);
        Menu menu = new Menu("Menu Parrillero", 10.0);
        menu.agregarPropuesta(new Servicio("Entrada", 80000.0));
        menu.agregarPropuesta(parrillada);
        menu.agregarPropuesta(new Servicio("Postre", 60000.0));
        Contrato contrato = new Contrato("Lucia", menu);

        parrillada.actualizarPrecio(260000.0);

        assertEquals(342000.0, contrato.getImporte());
    }

}
