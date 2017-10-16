package trabajofinal;

public class OperacionException extends Exception
{
    
    private Entidad entidad;
    private String operacion;
    
    public static final String ALTA = "ALTA";
    public static final String BAJA = "BAJA";
    public static final String MODIFICACION = "MODIFICACION";
    public static final String CONSULTA = "CONSULTA";

    public OperacionException(Entidad entidad, String operacion)
    {
        this.entidad = entidad;
        this.operacion = operacion;
    }

}
