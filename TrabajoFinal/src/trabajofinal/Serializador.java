package trabajofinal;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Serializador
{
    
    private static final String ARCH_NAME = "pga.xml";
    
    private Serializador(){}
    
    public static void serializar()
    {
        XMLEncoder encoder = null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(ARCH_NAME)));
        }
        catch (FileNotFoundException e)
        {
            throw new InternalError();
        }
        encoder.writeObject(Controlador.getInstance());
        encoder.close();
    }
    
    public static Controlador deserializar()
    {
        XMLDecoder decoder = null;
        try
        {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(ARCH_NAME)));
        }
        catch (FileNotFoundException e)
        {
            throw new InternalError();
        }
        return (Controlador) decoder.readObject();
    }  
    
}
