package trabajofinal;

public class Mascaras
{

    /**
     * Constructor privado de la clase Mascaras
     * <br>
     * La clase no puede ser instanciada
     * <br>
     * Se utiliza para generar y validar mascaras
     */
    private Mascaras(){}

    /**
     * Genera un id con un prefijo y un numero
     * <b>Pre:</b> prefijo e id son validos
     * @param id Numero del id
     * @param prefijo Prefijo del id
     * @return Id con la mascara AAA9999
     */
    public static String genId(int id, String prefijo)
    {
        return String.format(prefijo + "%04d", id);
    }

    /**
     * Valida que el email cumpla con la mascara AAAAAA@AAAAAA
     * @param email Email a validar
     * @return true si el email cumple con la mascara, false en caso contrario
     */
    public static boolean emailValido(String email)
    {
        int i = 1, max = email.length() - 1;
        while (i < max && email.charAt(i) != '@')
            i++;
        return i < max;
    }
    
    //................................................INSPECCION................................................
    //El hecho de que las longitudes de la hora y el periodo sean constantes no brinda ninguna facilidad, ya que
    //si se modificaran implicaria que se modifico la mascara, por lo que el algoritmo tambien deberia cambiar

    /**
     * Valida que el periodo cumpla con la mascara CC-AAAA
     * @param periodo Periodo a validar
     * @return true si el periodo cumple con la mascara, false en caso contrario
     */
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

    /**
     * Valida que la hora exista y cumpla con la mascara 99:99
     * @param hora Hora a validar
     * @return true si la hora es valida, false en caso contrario
     */
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
