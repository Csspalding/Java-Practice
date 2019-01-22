
/**
 * @author Cass 14 jan 2019 program to impliment NewtonSqRoot algorithm ADS
 * 
 *         1.Set r to the mean of 1 and a 2.While r squared is not a good
 *         approimation of a, repeat; 2.1 Set r to the mean of r and a/r
 *         3.Terminate with answer r
 * 
 *         NB a is a whole number NB r is returned when its close enough, the
 *         difference should be to the nearest 0.001.
 */

public class NewtonSqRoot {

  private int aNum;
  private double r;
  private final double ONE = 1.0;
  
  //constructor
  // public NewtonSqRoot(int aNum){
  //   this.aNum = aNum;
  // }

  /**
   * Method to calculate Newton's Square Root algorithm 
   * @param aNum
   * @return
   */
  public double calculateSqRoot(int aNum) {
    
    r = (ONE + aNum) / 2; // set r to the mean :canatanate aNum , + 1 ,divide by 2 gives the mean
    double square = r * r; // r squared
    System.out.println("Calculate the Sq root of "+ aNum + " . Does the square match? " + square + " if not, repeat");
    // while r squared is below (a - 0.001) or higher than (a + 0.001), repeat
    double lowest = aNum -  0.001;
    double highest = aNum +  0.001;
    boolean isCloseEnough= false;//flag for when the close enough range is met
    while (!isCloseEnough){
      if (square < lowest || square > highest) { // if square is smaller than lowest OR greater than highest
        isCloseEnough = false;
       
        
        r = (r + (aNum / r)) / 2; // mean of r and (a/r)
        square = r * r;
        //System.out.println("Next Squ  " + square);
      
      } else {
        isCloseEnough = true;
      }
    }
    return r;  
  } 
  
  public double getRoot() {
    return r; 
  }
  
  public int getANum(){
    return aNum;
  }
  
  public static void main(String[] args) {
    //Test NewtonSqRoot algorithm 
    NewtonSqRoot sQRoot = new NewtonSqRoot();

    sQRoot.calculateSqRoot(8);
    System.out.printf("The Square Root of 8 %s %.3f", "is : ", sQRoot.getRoot());
    System.out.print("\n");
    sQRoot.calculateSqRoot(9);
    System.out.printf("The Square Root of 9 %s %.3f", "is : ", sQRoot.getRoot());

  }
}