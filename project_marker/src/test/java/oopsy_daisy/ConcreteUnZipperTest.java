package oopsy_daisy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before; 

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class ConcreteUnZipperTest{

    private ConcreteUnZipper unZipper;
    private String outputFolder;
    private String zipFile;
    private File destDir;
    private ZipInputStream zis;
    private ZipEntry zipEntry;


    @Before
    void setUp() {
        destDir = new File(outputFolder + "StudentAssignment");
        unZipper = new ConcreteUnZipper();
        outputFolder = "//workspaces//Project-Marker//project_marker";
        zipFile = "//workspaces//Project-Marker//project_marker//StudentAssignments.zip";

        try{
        zis = new ZipInputStream(new FileInputStream(zipFile));
        zipEntry = zis.getNextEntry();
        }catch(Exception e){

        }
    }
    
    @Test
    public void testUnZipIt(){
        
        unZipper.unZipIt(zipFile, outputFolder);
        try{
        File file = new File(outputFolder + "StudentAssignments");
        
        assertNotNull(file);
        }
        catch(Exception e){
            
        }
        
        
    }

    @Test
    public void testNewFile(){
        assertNotNull(unZipper.newFile(destDir, zipEntry));
    }

    @Test
    public void testGetFileListInDirectory(){
        assertFalse(unZipper.getFileListInDirectory(outputFolder + "/StudentAssignments").isEmpty());
    }

    @Test
    public void testUnZipList(){
        ArrayList<String> directoryListing = new ArrayList<String>();
        directoryListing.add(outputFolder + "/StudentAssignments/818018870-JonathanElcock.zip");
        
        assertFalse(unZipper.unZipList(outputFolder, directoryListing).isEmpty());
    }

    @Test
    public void testUnzipMasterFile(){
        assertFalse(unZipper.UnZipMasterFile(zipFile).isEmpty());
    }

    @Test
    public void testGetStudentFiles(){
        assertFalse(unZipper.getStudentFiles("/workspaces/Project-Marker/project_marker/src/main/java/oopsy_daisy/SampleAssignment").isEmpty());
    }

}