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
    
    public static void serializar(Controlador controlador)
    {
        try
        {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(ARCH_NAME)));
            encoder.writeObject(controlador);
            encoder.writeObject(Alumno.getSigLegajo());
            encoder.writeObject(Asignatura.getSigIdentificacion());
            encoder.writeObject(Controlador.getControlador());
            encoder.writeObject(Cursada.getSigIdentificacion());
            encoder.writeObject(Profesor.getSigLegajo());
            encoder.close();
        }
        catch (FileNotFoundException e)
        {
            throw new InternalError();
        }
    }
    
    public static Controlador deserializar()
    {
        try
        {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(ARCH_NAME)));
            Controlador controlador = (Controlador) decoder.readObject();
            Alumno.setSigLegajo((int) decoder.readObject());
            Asignatura.setSigIdentificacion((int) decoder.readObject());
            Controlador.setControlador((Controlador) decoder.readObject());
            Cursada.setSigIdentificacion((int) decoder.readObject());
            Profesor.setSigLegajo((int) decoder.readObject());
            decoder.close();
            return controlador;
        }
        catch (FileNotFoundException e)
        {
            return Controlador.getInstance();
        }
    }  
    
}
