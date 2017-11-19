package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AltaAlumnoTest.class, AltaProfesorTest.class, AltaAsignaturaTest.class,
                BajaAlumnoTest.class, BajaProfesorTest.class, BajaAsignaturaTest.class,
                UbicaAlumnoTest.class, UbicaProfesorTest.class, UbicaAsignaturaTest.class,
                ConsultaAlumnoTest.class, ConsultaProfesorTest.class, ConsultaAsignaturaTest.class,
                ConsultaCursadaTest.class, AltaCursadaTest.class, BajaCursadaTest.class,
                ModificaAlumnoTest.class, ModificaProfesorTest.class, ModificaAsignaturaTest.class,
                ModificaCursadaTest.class, AprobarAlumnoTest.class, RemoveAsignaturaAlumnoTest.class,
                AddCompetenciaTest.class, RemoveCompetenciaTest.class, AddCorrelativaTest.class,
                RemoveCorrelativaTest.class, AddAlumnoCursadaTest.class, RemoveAlumnoCursadaTest.class,
                AddProfesorCursadaTest.class, RemoveProfesorCursadaTest.class })
public class PGATestSuite{}
