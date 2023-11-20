package oopsy_daisy;


import java.util.ArrayList;


public class AssignmentGrader implements Subject{
    private ArrayList<Observer> monitors; 

    public AssignmentGrader(){
        monitors = new ArrayList<>(); 
    }


    public void gradeAssignments(){
        notifyObservers();
    }





    public void addObserver(Observer o){
        monitors.add(o);
    }

    public void detachObserver(Observer o){
        monitors.remove(o);
    }

    public void notifyObservers(){
        for(Observer o: monitors){
            o.update(); 
        }
    }
    
    //needed for tests
    public ArrayList<Observer> getMonitors(){
        return monitors;
    }
    
    //Code for Assignment Grader section

    GradeTemplate Grader;

    


}
