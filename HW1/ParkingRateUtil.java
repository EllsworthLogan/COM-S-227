package hw1;

/**
 * Utility class that contains a method for determining the amount of 
 * money due for a given ticket object.
 * @author logan
 */
public class ParkingRateUtil {
	
	/**
	 * There is one public constant, which ensures that the time limit cannot ever be changed. 
	 */
	public static final int EXIT_TIME_LIMIT = 15;
	
	/**
	 * There is one constructor, which is declared private since
	 * the class should never be instantiated:
	 */
	private ParkingRateUtil() {
	}
	
	/**
	 * Returns the cost of parking for the given total number of minutes,
	 * based on the current rates for the MU garage.
	 * @param minutes
	 * 		Given minutes
	 * @return
	 * 		Payment due for a given ticket.
	 */
	public static double calculateCost(int minutes) { 
		double payment = 0.0;
		//Subtracts 1 day (1440 minutes) from the total
		//to see how many minutes are left over.
		if (minutes >= 1440 && minutes < 2880) {
			payment = 13.0;
			minutes -= 1440;
		}
		//Subtracts 2 days (2880 minutes) from the total
		//to see how many minutes are left over.
		if (minutes >= 2880 && minutes < 4320) {
			payment = 26.0;
			minutes -= 2880;
		}
		//First 30 minutes
		if (minutes <= 30) { 
			payment += 1.0;
		}
		//1 hour
		if (minutes <= 60 && minutes > 30) { 
			payment += 2.0;
		}
		//2 hours
		if (minutes <= 120 && minutes > 60)  {
			payment += 3.5;
		}
		//3 hours
		if (minutes <= 180 && minutes > 120) { 
			payment += 5.0;
		}
		//4 hours
		if (minutes <= 240 && minutes > 180) { 
			payment += 6.5;
		}
		//5 hours
		if (minutes <= 300 && minutes > 240)  { 
			payment += 8.0;
		}
		//6 hours
		if (minutes <= 360 && minutes > 300)  { 
			payment += 9.25;
		}
		//7 hours
		if (minutes <= 420 && minutes > 360)  { 
			payment += 10.5;
		}
		//8 hours
		if (minutes <= 480 && minutes > 420)  {
			payment += 11.75;
		}
		//Maximum daily parking fee (24 hours)
		if (minutes > 480)  {
			payment += 13.0;
		}
		return payment;
	}
}
