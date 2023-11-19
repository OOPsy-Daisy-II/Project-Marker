package oopsy_daisy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;


import java.io.IOException;


public interface UnZipperInterface {

    public void unZipIt(String zipFile, String outputFolder) throws IOException;
    public File newFile(File destinationDir, ZipEntry zipEntry) throws IOException;
    public ArrayList<String> getFileListInDirectory(String directoryName) throws IOException;
    public ArrayList<String> unZipList(String directory, ArrayList<String> directoryListing) throws IOException;
    public ArrayList<String> UnZipMasterFile(String inputPath);
    public List<String> getStudentFiles(String folderPath) throws IOException;
    
}
