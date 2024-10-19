package lab2;
import java.util.Random;
/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
  // TODO - add instance variables as needed
  private int numRabbit;
  private Random rand = new Random();
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
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
    return this.numRabbit;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
    // TODO
	  this.numRabbit += rand.nextInt(9);
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  this.numRabbit = 0;
  }
}
