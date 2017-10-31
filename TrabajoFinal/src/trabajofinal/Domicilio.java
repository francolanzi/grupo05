package trabajofinal;

public class Domicilio
{
    
    private String calle;
    private int numero;

    public Domicilio(String calle, int numero)
    {
        this.calle = calle;
        this.numero = numero;
    }
    
    //Constructor vacío, getters y setters
    //Necesarios para serializar en XML
    
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
