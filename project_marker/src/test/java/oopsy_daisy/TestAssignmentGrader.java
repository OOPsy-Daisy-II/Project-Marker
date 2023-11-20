package oopsy_daisy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAssignmentGrader {
    private Observer o;
    private AssignmentGrader ag;

    @Before
    public void setUp() {
        o = new GeneratePDF("project_marker/src/main/java/oopsy_daisy/AssignmentSpec");
        ag = new AssignmentGrader();
    }
    
    @Test
    public void testAddObserver(){
        ag.addObserver(o);
        assertTrue(ag.getMonitors().contains(o));
    }

    @Test
    public void testDetachObserver(){
        ag.detachObserver(o);
        assertFalse(ag.getMonitors().contains(o));
    }



}
