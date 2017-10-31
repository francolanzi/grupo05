package trabajofinal;

public class Mascaras
{
    
    private Mascaras(){}
    
    public static String genId(int id, String prefijo)
    {
        return String.format(prefijo + "%04d", id);
    }
    
    public static boolean emailValido(String email)
    {
        int i = 1, max = email.length() - 1;
        while (i < max && email.charAt(i) != '@')
            i++;
        return i < max;
    }
    
    public static boolean periodoValido(String periodo)
    {
        boolean retorno = periodo.length() == 7 && periodo.charAt(0) == '0' &&
        (periodo.charAt(1) == '1' || periodo.charAt(1) == '2') && periodo.charAt(2) == '-';
        int i = 3;
        while (retorno && i < 7)
        {
            retorno = retorno && periodo.charAt(i) >= '0' && periodo.charAt(i) <= '9';
            i++;
        }
        return retorno;
    }
    
    public static boolean horaValida(String hora)
    {
        boolean retorno;
        if (hora.length() != 5 || hora.charAt(2) != ':')
            retorno = false;
        else
        {
            try
            {
                int horas = Integer.parseInt(hora.substring(0, 2));
                int minutos = Integer.parseInt(hora.substring(3, 5));
                retorno = horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59;
            }
            catch (NumberFormatException e)
            {
                retorno = false;
            }
        }
        return retorno;
    }
    
}
