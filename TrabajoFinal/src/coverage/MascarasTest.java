package coverage;

import model.Mascaras;

import static org.junit.Assert.*;
import org.junit.Test;

public class MascarasTest extends AbstractTest
{
    
    @Test
    public void testGenId()
    {
        assertEquals("El id generado no es el esperado", "ALU1000", Mascaras.genId(1000, "ALU"));
    }
    
    @Test
    public void testEmailValido()
    {
        assertTrue("El email deberia ser valido", Mascaras.emailValido("justinbieber@gmail.com"));
    }
    
    @Test
    public void testPeriodoValido()
    {
        assertTrue("El periodo deberia ser valido", Mascaras.periodoValido("01-2017"));
    }
    
    @Test
    public void testHoraValida1()
    {
        assertFalse("La hora no deberia ser valida", Mascaras.horaValida("00-00"));
    }
    
    @Test
    public void testHoraValida2()
    {
        assertFalse("La hora no deberia ser valida", Mascaras.horaValida("pe:00"));
    }
    
    @Test
    public void testHoraValida3()
    {
        assertTrue("La hora deberia ser valida", Mascaras.horaValida("00:00"));
    }
    
}
