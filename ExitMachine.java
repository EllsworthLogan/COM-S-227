package hw1;

/**
 * Model of an exit machine that accepts a ticket object and determines
 * whether you may exit the garage.
 * @author logan
 */
public class ExitMachine {

	/*
	 * A simple clock object.
	 */
	private SimpleClock sc;
	
	/*
	 * The number of successful exits from the parking garage.
	 */
	private int successfulExits;
	
	/**
	 * Constructs an ExitMachine that uses the given clock
	 * and has an initial count of zero. 
	 * @param givenClock
	 * 		A given clock.
	 */
	public ExitMachine(SimpleClock givenClock) {
		sc = givenClock;
		successfulExits = 0;
	}
	
	/**
	 * Simulates inserting a ticket into this machine.
	 * @param t
	 * 		A ticket object.
	 * @return
	 * 		Whether you can exit the garage.
	 */
	public boolean insertTicket(Ticket t) {
		//Determines whether the time is between 0 and 15 minutes by using getter methods.
		if ((sc.getTime() - t.getPaymentTime())<15 && t.getPaymentTime()> 0) {
			//Increments the number of successful exits by 1 each time a valid ticket is inserted.
			successfulExits +=1;
			return true;
		}
		else {
			return false;
		}	
	}
	
	/**
	 * Returns a count of the total number of successful exits.
	 * @return
	 * 	The number of successful exits.
	 */
	public int getExitCount() {
		return successfulExits;
	}
}
