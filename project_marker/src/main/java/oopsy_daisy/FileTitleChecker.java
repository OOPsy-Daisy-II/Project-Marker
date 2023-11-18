package oopsy_daisy;

import java.util.List;

public class FileTitleChecker extends GradeTemplate{

    public void GradeSection(List<String>studentpaths){
        for(String path: studentpaths){
            System.out.println(getFileName(path));
        }
    }


    
}
