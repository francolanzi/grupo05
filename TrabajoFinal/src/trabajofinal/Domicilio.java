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

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Domicilio))
        {
            return false;
        }
        final Domicilio other = (Domicilio) object;
        if (!(calle == null? other.calle == null: calle.equals(other.calle)))
        {
            return false;
        }
        if (numero != other.numero)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((calle == null)? 0: calle.hashCode());
        result = PRIME * result + numero;
        return result;
    }
    
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
