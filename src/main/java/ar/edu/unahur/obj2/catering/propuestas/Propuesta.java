package ar.edu.unahur.obj2.catering.propuestas;

public interface Propuesta {
    Double precio();
    String descripcion();
    Integer cantidadDeServicios();
    Boolean incluyeServicio(String nombreDelServicio);

}
