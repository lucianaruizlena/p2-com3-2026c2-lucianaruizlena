package ar.edu.unahur.obj2.catering;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.modificaciones.ActualizarPrecioDeServicio;
import ar.edu.unahur.obj2.catering.modificaciones.Modificacion;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;

public class ModificacionesTest {

    @Test
    public void dadoUnServicio_alAplicarUnaActualizacion_dejaElNuevoPrecio() {
        Servicio servicio = new Servicio("Parrilla completa", 150000.0);
        Modificacion modificacion = new ActualizarPrecioDeServicio(servicio, 16000.0);

        modificacion.aplicar();

        assertEquals(16000.0, servicio.precio());
    }


    @Test
    public void dadaUnaActualizacionAplicada_alDeshacerla_recuperaElPrecioAnterior() {
        Servicio servicio = new Servicio("Parrilla completa", 150000.0);
        Modificacion modificacion = new ActualizarPrecioDeServicio(servicio, 160000.0);
        modificacion.aplicar();

        modificacion.deshacer();

        assertEquals(150000.0, servicio.precio());
    }
}
