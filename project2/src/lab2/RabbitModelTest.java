package lab2;
public class RabbitModelTest
{
  public static void main(String[] args)
  {
    RabbitModel model = new RabbitModel();

    // Check that the initial population is 2
    System.out.println(model.getPopulation());
   // System.out.println("Expected 2");

    // A year goes by...
    model.simulateYear();
    System.out.println(model.getPopulation());
    model.simulateYear();
    System.out.println(model.getPopulation());
    model.simulateYear();
    System.out.println(model.getPopulation());
    model.simulateYear();
    System.out.println(model.getPopulation());
    model.simulateYear();
    System.out.println(model.getPopulation());
    model.simulateYear();
    System.out.println(model.getPopulation());
    //System.out.println("Expected 3");

    // Start over
    model.reset();
    System.out.println(model.getPopulation());
   // System.out.println("Expected 2");
  }
}