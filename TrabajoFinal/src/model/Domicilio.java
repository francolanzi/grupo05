package model;

public class Domicilio
{
    
    private String calle;
    private int numero;

    /**
     * Constructor de la clase Domicilio
     * <b>Pre:</b> calle y numero son validos
     * <b>Post:</b> se ha creado un nuevo domicilio
     * @param calle Calle del domicilio
     * @param numero Numero del domicilio
     */
    public Domicilio(String calle, int numero)
    {
        this.calle = calle;
        this.numero = numero;
    }
    
/*.........................................Constructor vacío, getters y setters.........................................
.............................................Necesarios para serializar en XML........................................*/
    
    public Domicilio(){}

    public void setCalle(String calle)
    {
        this.calle = calle;
    }

    public String getCalle()
    {
        return this.calle;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public int getNumero()
    {
        return this.numero;
    }

}
