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
}
