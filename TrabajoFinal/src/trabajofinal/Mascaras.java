package trabajofinal;

public class Mascaras
{
    
    private Mascaras(){}
    
    public static String genId(int id, String prefijo)
    {
        String retorno = "" + id;
        for (int i = 4; i > retorno.length(); i--)
            retorno = "0" + retorno;
        retorno = prefijo + retorno;
        return retorno;
    }
    
    public static boolean emailValido(String email)
    {
        int i = 0, max = email.length() - 1;
        while (i < max && email.charAt(i) != '@')
            i++;
        return i < max;
    }
    
    public static boolean periodoValido(String periodo)
    {
        boolean retorno = periodo.length() == 7 && periodo.charAt(0) == '0' &&
        (periodo.charAt(1) == '1' || periodo.charAt(1) == '2') && periodo.charAt(2) == '-';
        int i = 0;
        while (retorno && i < 7)
        {
            retorno = retorno && periodo.charAt(i) >= '0' && periodo.charAt(i) <= '9';
            i++;
        }
        return retorno;
    }
    
    public static boolean horaValida(String hora)
    {
        boolean retorno = hora.length() == 5 && hora.charAt(2) == ':';
        int i = 0;
        while (retorno && i < 5)
        {
            retorno = retorno && hora.charAt(i) >= '0' && hora.charAt(i) <= '9';
            i++;
        }
        return retorno;
    }
    
}
