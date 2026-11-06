package ar.edu.unahur.obj2.catering.excepciones;


public class PrecioEsNegativoException extends RuntimeException {
    public PrecioEsNegativoException(String mensaje) {
        super(mensaje);
    }
}
