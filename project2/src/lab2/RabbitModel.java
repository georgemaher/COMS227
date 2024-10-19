package lab2;
//import java.util.Random;
/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel
{
  // TODO - add instance variables as needed
  private int numCurrentYear;
  private int numLastYear;
  private int numYearBefore;
//  private Random rand = new Random();
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
  {
    // TODO
	  this.reset();
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    // TODO - returns a dummy value so code will compile
    return this.numCurrentYear;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
    // TODO
	  this.numYearBefore = this.numLastYear;
	  this.numLastYear = this.numCurrentYear;
	  this.numCurrentYear = this.numYearBefore + this.numLastYear;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  this.numYearBefore = 0;
	  this.numLastYear = 1;
	  this.numCurrentYear = this.numLastYear + this.numYearBefore;
  }
}
