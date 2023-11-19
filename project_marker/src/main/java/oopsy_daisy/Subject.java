package oopsy_daisy;


public interface Subject {
    public void addObserver(Observer o);
    public void detachObserver(Observer o);
    public void notifyObservers();
}