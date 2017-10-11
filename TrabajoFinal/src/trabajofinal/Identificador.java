package trabajofinal;

public class Identificador
{
    
    private Identificador(){}
    
    public static String genIdentificador(int identificador, String prefijo)
    {
        String retorno = "" + identificador;
        for (int i = 4; i > retorno.length(); i--)
            retorno = "0" + retorno;
        retorno = prefijo + retorno;
        return retorno;
    }
    
}
