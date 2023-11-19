package oopsy_daisy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SpecReader {
    public ArrayList<String> readFileNames(String path){
        ArrayList<String> fileNames = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileNames.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileNames; 
    }
}
