package trabajofinal;

public class EntidadNoEncontradaException extends Exception {
    
    private String apellido;
    private String nombre;

    public EntidadNoEncontradaException(String apellido, String nombre)
    {
        this.apellido=apellido;
        this.nombre=nombre;
    }

    public EntidadNoEncontradaException(String nombre)
    {
        this.nombre=nombre;
    }

}
