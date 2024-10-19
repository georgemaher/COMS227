package hw1;

public class parkingUtilRateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("parking fees for 12 mins is: " + ParkingRateUtil.calculateCost(12));
		System.out.println("parking fees for 27 mins is: " + ParkingRateUtil.calculateCost(27));
		System.out.println("parking fees for 45 mins is: " + ParkingRateUtil.calculateCost(45));
		System.out.println("parking fees for 90 mins is: " + ParkingRateUtil.calculateCost(90));
		System.out.println("parking fees for 150 mins is: " + ParkingRateUtil.calculateCost(150));
		System.out.println("parking fees for 210 mins is: " + ParkingRateUtil.calculateCost(210));
		System.out.println("parking fees for 270 mins is: " + ParkingRateUtil.calculateCost(270));
		System.out.println("parking fees for 330 mins is: " + ParkingRateUtil.calculateCost(330));
		System.out.println("parking fees for 390 mins is: " + ParkingRateUtil.calculateCost(390));
		System.out.println("parking fees for 450 mins is: " + ParkingRateUtil.calculateCost(450));
		System.out.println("parking fees for 510 mins is: " + ParkingRateUtil.calculateCost(510));
		System.out.println("parking fees for 3000 mins is: " + ParkingRateUtil.calculateCost(3000)+" Expected: 29.5");

	}

}
