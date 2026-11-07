package ar.edu.unahur.obj2.catering.modificaciones;

import ar.edu.unahur.obj2.catering.propuestas.Menu;
import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class AgregarPropuestaAlMenu implements Modificacion {
    private final Menu menu;
    private final Propuesta propuesta;

    public AgregarPropuestaAlMenu(Menu menu, Propuesta propuesta) {
        this.menu = menu;
        this.propuesta = propuesta;
    }

    @Override
    public void aplicar(){
        menu.agregarPropuesta(propuesta);
    }

    @Override
    public void deshacer() {
        menu.quitarPropuesta(propuesta);
    }
}

