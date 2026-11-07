package ar.edu.unahur.obj2.catering;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.modificaciones.ActualizarPrecioDeServicio;
import ar.edu.unahur.obj2.catering.modificaciones.Modificacion;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;

public class ModificacionesTest {

    @Test
    public void dadoUnServicio_alAplicarUnaActualizacion_dejaElNuevoPrecio() {
        // Arrange
        Servicio servicio = new Servicio("Parrillada completa", 240000.0);
        Modificacion modificacion = new ActualizarPrecioDeServicio(servicio, 260000.0);

        // Act
        modificacion.aplicar();

        // Assert
        assertEquals(260000.0, servicio.precio());
    }
}
