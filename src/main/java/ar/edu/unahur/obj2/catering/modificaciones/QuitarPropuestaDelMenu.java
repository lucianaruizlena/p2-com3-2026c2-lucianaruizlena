package ar.edu.unahur.obj2.catering.modificaciones;

import ar.edu.unahur.obj2.catering.propuestas.Menu;
import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class QuitarPropuestaDelMenu implements Modificacion {
    private final Menu menu;
    private final Propuesta propuesta;
    private Integer indiceAnterior;

    public QuitarPropuestaDelMenu(Menu menu, Propuesta propuesta) {
        this.menu = menu;
        this.propuesta = propuesta;
    }

    @Override
    public void aplicar() {
        indiceAnterior = menu.indiceDe(propuesta);
        menu.quitarPropuesta(propuesta);
    }

    @Override
    public void deshacer() {
        menu.agregarPropuestaEn(indiceAnterior, propuesta);
    }
}
