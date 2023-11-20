package oopsy_daisy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test; 
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.reflections.Reflections;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import oopsy_daisy.AssignmentSpec.BaseTest;
import oopsy_daisy.AssignmentSpec.LuggageManifestTest;
import oopsy_daisy.AssignmentSpec.PassengerTest;
import oopsy_daisy.SampleAssignment.LuggageManifest;

import oopsy_daisy.AssignmentSpec.FlightTest;
import oopsy_daisy.AssignmentSpec.LuggageManifestTest;
import oopsy_daisy.AssignmentSpec.LuggageSlipTest;
import oopsy_daisy.AssignmentSpec.PassengerTest;

public class App 
{
    public static void main( String[] args )
    {
        //Step 1: unzip the files and open the Assignment Spec
        String inputpath = "C:/Users/nickd/OneDrive/Desktop/StudentAssignments.zip";
        // String specpath = "FlightMarkerSpec.txt";
        ConcreteUnZipper UnZipper = new ConcreteUnZipper();
        List<String> StudentAssignmentFiles = new ArrayList<>(); 
        // ArrayList<String> StudentAssignmentPaths = new ArrayList<>();


        List<String> StudentAssignmentPaths = UnZipper.UnZipMasterFile(inputpath);

        for(String AsgPath: StudentAssignmentPaths){
            StudentAssignmentFiles.addAll(UnZipper.getStudentFiles(AsgPath));
            
        }

 
        JUnitCore.runClasses(AllTests.class);

        // int total = 0;
    
        // // Get @SuiteClasses annotation
        // SuiteClasses suiteClasses = AllTests.class.getAnnotation(SuiteClasses.class);
        
        // // Get list of classes
        // Class<?>[] classes = suiteClasses.value(); 
        
        
        // for(Class<?> cls : classes) {
        //     try {
        //         BaseTest test = (BaseTest)cls.newInstance();
        //         total += test.getTotalScore();
        //     } catch (InstantiationException e) {
        //         // handle the InstantiationException here
        //         e.printStackTrace();
        //     } catch (IllegalAccessException e) {
        //         // handle the IllegalAccessException here
        //         e.printStackTrace();
        //     }
        // }
        
        int[] scores = new int[4];

            BaseTest flightTest = new FlightTest(); 
            flightTest.test(); // Assuming this method updates the totalScore value
            scores[0] = flightTest.getTotalScore();

            BaseTest luggageManifestTest = new LuggageManifestTest();
            luggageManifestTest.test(); // Assuming this method updates the totalScore value
            scores[1] = luggageManifestTest.getTotalScore();

            BaseTest luggageSlipTest = new LuggageManifestTest();
            luggageSlipTest.test(); // Assuming this method updates the totalScore value
            scores[2] = luggageSlipTest.getTotalScore();

            BaseTest passenger = new PassengerTest();
            passenger.test(); // Assuming this method updates the totalScore value
            scores[3] = passenger.getTotalScore();

    System.out.println(Arrays.toString(scores));

        //Result result = JUnitCore.runClasses(FlightTest.class);

        // for (Failure failure : result.getFailures()) {
        //     System.out.println("Test Failed: " + failure.toString());
        // }

        // if (result.wasSuccessful()) {
        //     System.out.println("All tests passed!");
        // } else {
        //     System.out.println(result.getFailureCount() + " test(s) failed.");
        // }

        int flightscore= FlightTest.totalScore; 
        System.out.println("the flight score is: " + flightscore);


        //code to implement PDF Observer

        AssignmentGrader AsGrader = new AssignmentGrader();
        Observer PDFGenerator = new GeneratePDF("project_marker/src/main/java/oopsy_daisy/AssignmentSpec");
        AsGrader.addObserver(PDFGenerator);
        AsGrader.gradeAssignments();

    }
}
