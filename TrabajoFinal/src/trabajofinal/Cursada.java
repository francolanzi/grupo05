package trabajofinal;

import java.util.Iterator;
import java.util.TreeMap;

public class Cursada implements Entidad
{
    
    private static int sigIdentificacion = 0;
    private static final String prefijo = "CUR";
    
    private String identificacion;
    private Asignatura asignatura;
    private String periodo;
    private String dia;
    private String hora;
    private ObserverTreeMap<Profesor> profesores;
    private ObserverTreeMap<Alumno> alumnos;

    public Cursada(Asignatura asignatura, String periodo, String dia, String hora) throws PeriodoInvalidoException, HoraInvalidaException
    {
        this.modificar(asignatura, periodo, dia, hora);
        this.identificacion = Mascaras.genId(sigIdentificacion++, prefijo);
        this.profesores = new ObserverTreeMap<Profesor>();
        this.alumnos = new ObserverTreeMap<Alumno>();
    }

    @Override
    public String getId()
    {
        return this.identificacion;
    }

    public Asignatura getAsignatura() {
        return this.asignatura;
    }

    public String getPeriodo()
    {
        return this.periodo;
    }

    public String getDia()
    {
        return this.dia;
    }

    public String getHora()
    {
        return this.hora;
    }

    public void modificar(Asignatura asignatura, String periodo, String dia, String hora) throws PeriodoInvalidoException, HoraInvalidaException
    {
        if (!Mascaras.periodoValido(periodo))
            throw new PeriodoInvalidoException(periodo);
        if (!Mascaras.horaValida(hora))
            throw new HoraInvalidaException(hora);
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.hora = hora;
    }
    
    public static boolean horarioViable(String periodo, String dia, String hora, Iterator<Cursada> cursadas)
    {
        boolean retorno = true;
        while (retorno && cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            retorno = !periodo.equals(cursada.periodo) ||
            !dia.equals(cursada.dia) || !hora.equals(cursada.hora);
        }
        return retorno;
    }
}
