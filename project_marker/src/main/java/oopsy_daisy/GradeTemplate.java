package oopsy_daisy;

import java.util.List;

public abstract class GradeTemplate {


    protected String getFileName(String path) {
        int lastIndexOfSlash = path.lastIndexOf('\\');
        int lastIndexOfBackslash = path.lastIndexOf('/');
        int index = Math.max(lastIndexOfSlash, lastIndexOfBackslash);
        return path.substring(index + 1);
    }



    protected String getSpecInfo(){


        return ""; 
    }


    
    public abstract void GradeSection(List<String>studentpaths); //to refactor with strategy pattern 




}
