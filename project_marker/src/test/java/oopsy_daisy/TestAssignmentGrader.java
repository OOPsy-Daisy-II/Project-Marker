package oopsy_daisy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAssignmentGrader {
    private Observer o;
    private AssignmentGrader ag;

    @Before
    void setUp() {
        o = new GeneratePDF();
        ag = new AssignmentGrader();
    }
    
    @Test
    public void testAddObserver(){
        ag.addObserver(o);
        assertTrue(ag.getMonitors().contains(o));
    }

    public void testDetachObserver(){
        ag.detachObserver(o);
        assertFalse(ag.getMonitors().contains(o));
    }

    

}
