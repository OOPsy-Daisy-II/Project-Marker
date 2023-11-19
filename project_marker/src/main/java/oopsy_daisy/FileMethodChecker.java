package oopsy_daisy;

import java.util.List; 
import org.junit.runner.JUnitCore;
import java.awt.event.*;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.itextpdf.text.pdf.qrcode.Version.ECB;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;





public class FileMethodChecker extends GradeTemplate{
    

    public void GradeSection(List<String>studentpaths){
        String path1 = studentpaths.get(0);

        System.out.println(path1);

        String testPath = "project_marker/src/AssignmentSpec/FlightTest.java";

        Result result = runExternalTests(testPath);
        // JUnitCore junit = new JUnitCore();
        // junit.addListener(new TextListener(System.out));
        // junit.run(FirstUnitTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println("Test Failed: " + failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(result.getFailureCount() + " test(s) failed.");
        }

    }

    private static Result runExternalTests(String testPath){
        try{
            
            URL testPathURL = new File(testPath).toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{testPathURL});
            
            System.out.println("we inside the runexternaltests class" + classLoader); 
            return JUnitCore.runClasses(classLoader.loadClass("oopsy_daisy.FlightTest"));


        }catch (Exception e){
            e.printStackTrace();
            return null; 
        }


    }

    
}
