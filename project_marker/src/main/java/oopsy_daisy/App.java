package oopsy_daisy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        String inputpath = "C:/Users/nickd/OneDrive/Desktop/StudentAssignments.zip";


       ArrayList<String> StudentAssignmentPaths = new ArrayList<>(); 

       StudentAssignmentPaths = UnZipper.UnZipMasterFile(inputpath); 

       for ( String element: StudentAssignmentPaths){
        System.out.println(element);
       }

       String testPath = StudentAssignmentPaths.get(0); 

       List<String> studentpaths = new ArrayList<>(); 
       
       try{studentpaths = UnZipper.getStudentFiles(testPath);} catch (IOException e){}

       for (String ele: studentpaths){
        System.out.println(ele); 
       }

       String file1path = studentpaths.get(0);

       File newfile = new File(file1path);

       try{
        Scanner myReader = new Scanner(newfile);
            while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            
        }
        myReader.close();
       }catch (FileNotFoundException e){}
        
       


        
    }
}
