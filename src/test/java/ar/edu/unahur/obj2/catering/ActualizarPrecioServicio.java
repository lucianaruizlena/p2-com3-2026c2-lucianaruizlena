package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.excepciones.PrecioEsNegativoException;
import ar.edu.unahur.obj2.catering.modificaciones.ActualizarPrecioDeServicio;
import ar.edu.unahur.obj2.catering.modificaciones.Modificacion;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;


public class ActualizarPrecioServicio {
    @Test
    public void dadoUnServicio_alAplicarUnaActualizacion_dejaElNuevoPrecio() {
        Servicio servicio = new Servicio("Parrilla completa", 240000.0);
        Modificacion modificacion = new ActualizarPrecioDeServicio(servicio, 260000.0);

        modificacion.aplicar();

        assertEquals(260000.0, servicio.precio());
    }

    @Test
    public void dadaUnaActualizscionConPrecioNegativo_alAplicarla_lanzaPrecioNegativoExceptionYSinCambiarElPrecio() {
        Servicio servicio = new Servicio("Parrilla completa", 240000.0);
        Modificacion modificacion = new ActualizarPrecioDeServicio(servicio, -1.0);

        assertThrows(PrecioEsNegativoException.class, modificacion::aplicar);
        assertEquals(240000.0, servicio.precio());
    }

    @Test
    public void dadaUnaActualizacionAplicada_alDeshacerla_recuperaElPrecioAnterior() {
        Servicio servicio = new Servicio("Parrilla completa", 240000.0);
        Modificacion modificacion = new ActualizarPrecioDeServicio(servicio, 260000.0);
        
        modificacion.aplicar();

        modificacion.deshacer();

        assertEquals(240000.0, servicio.precio());
    }
}
