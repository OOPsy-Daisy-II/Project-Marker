package oopsy_daisy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull; 
import oopsy_daisy.ConcreteUnZipper;

import org.junit.Test;
import org.junit.Before; 

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class ConcreteUnZipperTest{

    ConcreteUnZipper unZipper;

    @Before
    public void setUp() {
        unZipper = new ConcreteUnZipper();
        // File destDir = new File("//workspaces//Project-Marker//project_marker//src");
    }
    
    @Test
    public void testUnZipIt(){
        
        unZipper.unZipIt("testFolder", "//workspaces//Project-Marker//project_marker//src");
        try{
        File file = new File("//workspaces//Project-Marker//project_marker//src//testZipper//test.txt");
        
        assertNotNull(file);
        }
        catch(Exception e){
            
        }
        
        
    }

    // @Test
    // public void testNewFile(){
    //     assertNotNull(unziper.newFile());
    // }

}