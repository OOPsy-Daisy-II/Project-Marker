package oopsy_daisy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExamineSpec {

    public ArrayList<String>  filenames;
    public int filecount = 0; 

    public ExamineSpec(String path){
        filenames = new ArrayList<>(); 
        findFiles(path);

    }

    public List<String> getFilenames() {
        return filenames;
    }

    public int getCount() {
        return filecount;
    }

    public void findFiles(String path) {

        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (!f.isDirectory()) {
                filenames.add(f.getName());
                filecount++;
            }
        }
    }
}
