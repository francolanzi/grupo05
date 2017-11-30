package coverage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlumnoTest.class, ProfesorTest.class, AsignaturaTest.class, CursadaTest.class,
                MascarasTest.class, ObserverTreeMapTest.class, ControladorTest1.class, ControladorTest2.class })
public class PGACoverageTestSuite{}
