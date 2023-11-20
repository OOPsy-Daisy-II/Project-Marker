package oopsy_daisy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ExamineSpecTest {
    
    ExamineSpec es;

    
    @Before
    public void setUp(){
        es =  new ExamineSpec("/workspaces/Project-Marker/project_marker/src/main/java/oopsy_daisy/AssignmentSpec");
    }

    @Test
    public void testExamineSpec(){
        ArrayList<String> filenames = (ArrayList<String>) es.getFilenames();
        
        assertTrue(filenames.contains("LuggageSlipTest.java"));
        assertTrue(filenames.contains("LuggageManifestTest.java"));
        assertTrue(filenames.contains("PassengerTest.java"));
        assertTrue(filenames.contains("FlightTest.java"));
    }
}
