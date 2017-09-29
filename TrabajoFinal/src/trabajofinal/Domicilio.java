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

    public String getCalle()
    {
        return this.calle;
    }

    public int getNumero()
    {
        return this.numero;
    }

}
