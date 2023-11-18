package oopsy_daisy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.ArrayList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public interface UnZipperInterface {
    public void unZipIt(String zipFile, String outputFolder) throws IOException;

    public File newFile(File destinationDir, ZipEntry zipEntry) throws IOException;

    public ArrayList<String> getFileListInDirectory(String directoryName) throws IOException;

    public ArrayList<String> unZipList(String directory, ArrayList<String> directoryListing);

    public ArrayList<String> UnZipMasterFile(String inputPath);

    public List<String> getStudentFiles(String folderPath);
}
