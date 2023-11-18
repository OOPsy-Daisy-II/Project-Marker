package oopsy_daisy; 

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


// 1) unzip the main/big file
// 2) create arraylist or other collection for the unzipped files within the big file
// 3) get a list to call the file to the directery i.e go in the new directory and get list of all files in directory
// 4) to be thorough if file has .zip add to collection
// 5) iterate the collection and as long as items present call the unzip method with the create directory minus .zip
// 6) store directory names in another collection for instance arrayList

// next method pathProducer
// take in a collection as parameter in this case the unzipped files

//Reference:
//https://www.baeldung.com/java-compress-and-uncompress

public class ConcreteUnZipper implements UnZipperInterface{
    //Code for zip file opener
    
    public void unZipIt(String zipFile, String outputFolder) {
        try{
        String fileZip = zipFile;
        File destDir = new File(outputFolder);

        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = newFile(destDir, zipEntry);
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // fix for Windows-created archives
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                // write file content
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }

        zis.closeEntry();
        zis.close();
        }catch (IOException e){
            System.out.println("error unzipping file"); 
        }
    }




    public File newFile(File destinationDir, ZipEntry zipEntry)  {
        try{
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
        }catch (IOException e){
            System.out.println("error unzipping file"); 
        }
    }
    
    public ArrayList<String> getFileListInDirectory(String directoryName){ //gets a list of all the filenames in a directory1
        try{
        ArrayList<String> directoryListing = new ArrayList<String>();
        
        File[] files = new File(directoryName).listFiles();
        
        if (files != null)
            for (File file : files) {
                if (file.isFile()) {
                    directoryListing.add(file.getName());
                }
            }
        
        return directoryListing;
        }catch (IOException e){
            System.out.println("error unzipping file"); 
        }
    }
    
    //unzip individual assignments and return pathProducer
    public ArrayList<String> unZipList(String directory, ArrayList<String> directoryListing) throws IOException {
        ArrayList<String> subDirectoryListing = new ArrayList<String>();
        
        if (directoryListing != null)
            for (String file : directoryListing) {
                String subDirectoryName;
                String fullSubDirectoryName;
                String extension;
                
                int pos = file.lastIndexOf('.');
                if(pos > -1){
                    extension = file.substring(pos, file.length());
                    
                    if (extension.equals(".zip")){
                        subDirectoryName = file.substring(0, pos);
                        fullSubDirectoryName = directory + File.separator + subDirectoryName;
                        subDirectoryListing.add(fullSubDirectoryName);
                        UnZipper.unZipIt(directory + File.separator + file, fullSubDirectoryName);
                    }
                }
            }
        
        return subDirectoryListing;
    }
    
    public ArrayList<String> UnZipMasterFile(String inputPath)
    {
        //Test usage
        String MASTER_INPUT_ZIP = inputPath;
        String masterOutputDirectory;
        
        int pos = MASTER_INPUT_ZIP.lastIndexOf('.');
        if(pos > -1)
            masterOutputDirectory = MASTER_INPUT_ZIP.substring(0, pos);
        else
            masterOutputDirectory = MASTER_INPUT_ZIP;
        
        try {
            UnZipper.unZipIt(MASTER_INPUT_ZIP, masterOutputDirectory);
        } catch (IOException ex) {
            // TODO: handle exception
            ex.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Unzipping master file complete.");
        
        ArrayList<String> directoryListing = new ArrayList<String>();
        
        try {
            directoryListing = UnZipper.getFileListInDirectory(masterOutputDirectory);
        } catch (IOException ex) {
            // TODO: handle exception
            ex.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        // System.out.println("Files in master zip file listing:");
        // System.out.println(directoryListing);
        
        ArrayList<String> subDirectoryListing = new ArrayList<String>();
        
        try {
            subDirectoryListing = UnZipper.unZipList(masterOutputDirectory, directoryListing);
        } catch (IOException ex) {
            // TODO: handle exception
            ex.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        System.out.println("\nUnzipping zip files in subdirectories complete.");
        // System.out.println("Newly created subdirectories listing:");
        // System.out.println(subDirectoryListing);
        return subDirectoryListing; 
    }
    


    public List<String> getStudentFiles(String folderPath)throws IOException{
        Path folder = Paths.get(folderPath);

        if (Files.exists(folder) && Files.isDirectory(folder)) {
            List<String> javaFilePaths = Files.walk(folder)
                    .filter(path -> path.toString().endsWith(".java"))
                    .map(Path::toString)
                    .collect(Collectors.toList());
            return javaFilePaths;
        } else {
            throw new IllegalArgumentException("Folder does not exist: " + folderPath);
        }

    }



}


