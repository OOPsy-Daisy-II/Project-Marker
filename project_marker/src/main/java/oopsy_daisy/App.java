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


       ArrayList<String> StudentAssignmentPaths = new ArrayList<>(); 

       StudentAssignmentPaths = UnZipper.UnZipMasterFile(inputpath); 

       for ( String element: StudentAssignmentPaths){
        System.out.println(element);
       }

       String testPath = StudentAssignmentPaths.get(0); 

       List<String> studentpaths = new ArrayList<>(); 
       
       try{studentpaths = UnZipper.getStudentFiles(testPath);} catch (IOException e){}


       FileTitleChecker neewf = new FileTitleChecker();

       neewf.GradeSection(studentpaths);




        
    }
}
