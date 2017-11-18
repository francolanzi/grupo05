package test;

public class IdValido
{
    
    private IdValido(){}
    
    public static boolean idValido(String prefijo, String id)
    {
        boolean retorno = id.length() == 7 && prefijo.equals(id.substring(0, 3));
        int i = 3;
        while (retorno && i < 7)
        {
            char x = id.charAt(i++);
            retorno = x >= '0' && x <= '9';
        }
        return retorno;
    }
}
