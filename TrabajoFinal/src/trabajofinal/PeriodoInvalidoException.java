package trabajofinal;

public class PeriodoInvalidoException extends Exception
{
    
    //..........................................INSPECCION..........................................
    //Si bien en la interfaz la informacion de las excepciones es irrelevante, salvo por elmensaje,
    //es necesario que brinden dicha informacion ya que podrian llegar hasta una zona del codigo
    //donde sea importante conocer los detalles sobre lo que dio origen a la excepcion
    
    private String periodo;

    public PeriodoInvalidoException(String periodo, String mensaje)
    {
        super(mensaje);
        this.periodo = periodo;
    }
    
    public PeriodoInvalidoException(String periodo)
    {
        this.periodo = periodo;
    }

    public PeriodoInvalidoException(){}

    public void setPeriodo(String periodo)
    {
        this.periodo = periodo;
    }

    public String getPeriodo()
    {
        return this.periodo;
    }

}
