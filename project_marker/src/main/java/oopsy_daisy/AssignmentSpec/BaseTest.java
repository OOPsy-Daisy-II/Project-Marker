package oopsy_daisy.AssignmentSpec;

public abstract class BaseTest {

  protected int totalScore;
  
  public static int finalScore;

  public int getTotalScore() {
    return totalScore; 
  }

  public abstract int test();

}
