package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.adicionales.MozoAdicional;
import ar.edu.unahur.obj2.catering.adicionales.ServicioNocturno;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;

public class AdicionalesTest {

    @Test
    public void dadoUnServicio_alAgregarMozosAdicionales_aumentaElPrecioYLaDescripcion() {
        Servicio servicio = new Servicio("Entrada", 80000.0);
        MozoAdicional propuesta = new MozoAdicional(servicio);

        Double precio = propuesta.precio();
        String descripcion = propuesta.descripcion();

        assertEquals(98000.0, precio, 0.0001);
        assertEquals("Entrada + mozos adicionales", descripcion);
    }

    @Test
    public void dadoUnServicio_alAgregarServicioNocturnoYLuegoMozos_elOrdenCambiaElPrecioFinal() {

        Servicio servicio = new Servicio("Postre", 60000.0);
        ServicioNocturno nocturno = new ServicioNocturno(servicio);
        MozoAdicional propuesta = new MozoAdicional(nocturno);

        Double precio = propuesta.precio();

        assertEquals(90000.0, precio, 0.0001);
    }

    @Test
    public void dadoUnServicio_alAgregarMozosAdicionales_noCambiaLaCantidadNiLaInclusion() {
        Servicio servicio = new Servicio("Entrada", 80000.0);
        MozoAdicional propuesta = new MozoAdicional(servicio);

        Integer cantidad = propuesta.cantidadDeServicios();
        boolean incluye = propuesta.incluyeServicio("Entrada");

        assertEquals(1, cantidad);
        assertEquals(true, incluye);
    }

    @Test
    public void dadoUnServicioDecorado_alConsultarElDecorador_elServicioOriginalNoCambia() {
        Servicio servicio = new Servicio("Postre", 60000.0);
        MozoAdicional propuesta = new MozoAdicional(servicio);

        propuesta.precio();
        propuesta.descripcion();

        assertEquals(60000.0, servicio.precio(), 0.0001);
        assertEquals("Postre", servicio.descripcion());
    }

}
