package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.TreeMap;

public class Serializador
{
    
    private static final String ARCH_NAME = "pga.xml";
    
    private Serializador(){}
    
    public static void serializar() throws FileNotFoundException
    {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(ARCH_NAME)));
        encoder.writeObject(Controlador.getInstance().getAlumnos());
        encoder.writeObject(Controlador.getInstance().getProfesores());
        encoder.writeObject(Controlador.getInstance().getAsignaturas());
        encoder.writeObject(Controlador.getInstance().getCursadas());
        encoder.writeObject(Alumno.getSigLegajo());
        encoder.writeObject(Profesor.getSigLegajo());
        encoder.writeObject(Asignatura.getSigIdentificacion());
        encoder.writeObject(Cursada.getSigIdentificacion());
        encoder.close();
    }
    
    @SuppressWarnings("unchecked")
	public static void deserializar() throws FileNotFoundException
    {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(ARCH_NAME)));
        Controlador.getInstance().setAlumnos((TreeMap<String, Alumno>) decoder.readObject());
        Controlador.getInstance().setProfesores((TreeMap<String, Profesor>) decoder.readObject());
        Controlador.getInstance().setAsignaturas((TreeMap<String, Asignatura>) decoder.readObject());
        Controlador.getInstance().setCursadas((TreeMap<String, Cursada>) decoder.readObject());
        Alumno.setSigLegajo((Integer) decoder.readObject());
        Profesor.setSigLegajo((Integer) decoder.readObject());
        Asignatura.setSigIdentificacion((Integer) decoder.readObject());
        Cursada.setSigIdentificacion((Integer) decoder.readObject());
        decoder.close();
    }  
    
}
