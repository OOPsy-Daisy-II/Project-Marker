package oopsy_daisy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class ConcreteUnZipperTest{

    ConcreteUnZipper unZiper;

    @BeforeEach
    void setUp() {
        unziper = new ConcreteUnziper();
        // File destDir = new File("//workspaces//Project-Marker//project_marker//src");
    }
    
    @Test
    public void testUnZipIt(){
        
        unzipper.unZipIt("testFolder", "//workspaces//Project-Marker//project_marker//src");
        try{
        File file = new File("//workspaces//Project-Marker//project_marker//src//testZipper//test.txt");
        
        assertNotNull(file);
        }
        catch(FileNotFoundException e){
            
        }
        
        
    }

    // @Test
    // public void testNewFile(){
    //     assertNotNull(unziper.newFile());
    // }

}