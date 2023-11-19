package oopsy_daisy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import oopsy_daisy.FileTitleChecker;



public class App 
{
    public static void main( String[] args )
    {
        String inputpath = "C:/Users/nickd/OneDrive/Desktop/StudentAssignments.zip";
        ConcreteUnZipper UnZipper = new ConcreteUnZipper();
        List<String> StudentAssignmentFiles = new ArrayList<>(); 
        ArrayList<String> StudentAssignmentPaths = new ArrayList<>();

        StudentAssignmentPaths = UnZipper.UnZipMasterFile(inputpath);

        for(String AsgPath: StudentAssignmentPaths){
            StudentAssignmentFiles = UnZipper.getStudentFiles(AsgPath);
            
            
            FileTitleChecker neewf = new FileTitleChecker();
            neewf.GradeSection(StudentAssignmentFiles);
        }

        // testPath = StudentAssignmentPaths.get(0); 
        // studentpaths = UnZipper.getStudentFiles(testPath);


       




        
    }
}
