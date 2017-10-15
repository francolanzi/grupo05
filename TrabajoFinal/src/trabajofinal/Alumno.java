    package trabajofinal;

import java.util.TreeMap;

public class Alumno
{
    
    private static int sigLegajo = 0;
    private static final String prefijo = "ALU";
    
    private String legajo;
    private String apellido;
    private String nombre;
    private Domicilio domicilio;
    private String email;
    private ObserverTreeMap<Asignatura> historia;

    public Alumno(String apellido, String nombre, Domicilio domicilio, String email)
    {
        this.legajo = Identificador.genIdentificador(sigLegajo++, prefijo);
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.historia = new ObserverTreeMap<Asignatura>();
    }


    public String getLegajo() {
        return legajo;
    }
    
    public boolean equals (Object obj) {
        Alumno alu= (Alumno) obj;
        if (this.nombre==alu.nombre && this.apellido==alu.apellido && this.email==alu.email && this.domicilio.getCalle()==alu.domicilio.getCalle() && this.domicilio.getNumero()==alu.domicilio.getNumero())
            return true;     
        else       
            return false;
    }


}
