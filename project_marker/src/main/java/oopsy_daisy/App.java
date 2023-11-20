package oopsy_daisy;


import java.util.ArrayList;
import java.util.List;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import oopsy_daisy.AssignmentSpec.FlightTest;


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

 

        Result result = JUnitCore.runClasses(oopsy_daisy.AssignmentSpec.FlightTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println("Test Failed: " + failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(result.getFailureCount() + " test(s) failed.");
        }

        int flightscore= FlightTest.totalScore; 
        System.out.println("the flight score is: " + flightscore);


        //code to implement PDF Observer

        AssignmentGrader AsGrader = new AssignmentGrader();
        Observer PDFGenerator = new GeneratePDF("project_marker/src/main/java/oopsy_daisy/AssignmentSpec");
        AsGrader.addObserver(PDFGenerator);
        AsGrader.gradeAssignments();

    }
}
