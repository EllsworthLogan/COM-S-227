package hw1;

/**
 * Model of a payment machine that determines the amount due for a given ticket.
 * @author logan
 */
public class PaymentMachine {
	
	/*
	 * The ticket currently in the machine.
	 */
	private Ticket currentTicket; 		
	
	/*
	 * Payment machine's internal clock.
	 */
	private SimpleClock internalClock; 	
	
	/*
	 * The dollar amount of all payments made to this machine.
	 */
	private double totalPayments;		
	
	/*
	 * True if a ticket is currently in the machine. Else, false.
	 */
	private boolean inProgress = false; 
	
	/*
	 * The amount of money due for the current ticket.
	 */
	private double paymentDue; 		
	
	/*
	 * The time when the amount due is paid.
	 */
	private int paymentTime; 			
	
	/**
	 * Constructs a payment machine that uses the given clock. Initially, total payments are 0.0.
	 * @param givenClock
	 * 		A given clock object.
	 */
	public PaymentMachine(SimpleClock givenClock) {
		internalClock = givenClock;
		paymentDue = 0.0;
	}	
	
	/**
	 * Simulates inserting the given ticket into this machine.
	 * @param ticket
	 * 		A ticket object.
	 */
	public void insertTicket(Ticket ticket) {
		if (inProgress == false) {
			currentTicket = ticket;
		}
		inProgress = true;
	}
	
	/**
	 * Returns a reference to the ticket currently in this machine, or null if no transaction is in progress.
	 * @return
	 * 		Current ticket object (if inserted). Else, null.
	 */
	public Ticket getCurrentTicket() {
		if (inProgress == true) {
			return currentTicket;
		}
		else {
			return null;
		}		
	}
	
	/**
	 * Returns true if there is currently a ticket in this machine, false otherwise.
	 * @return
	 * 		Machine's inProgress status.
	 */
	public boolean inProgress() {
		if (inProgress == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the payment due for the ticket currently in the machine.
	 * Returns 0.0 if no transaction is in progress.
	 * @return
	 * 		Payment due for ticket in machine.
	 */
	public double getPaymentDue() {
		if (inProgress == true) {
			/*
			 * Local variables representing the current time and the time you got your ticket.
			 */
			int currentTime = internalClock.getTime();
			int startTime = currentTicket.getStartTime();
			paymentTime = currentTicket.getPaymentTime();
			
			if (paymentTime == 0) {
				//Basic calculation of finding the payment due by calculating the cost
				//of the current time minus the start time.
				paymentDue = ParkingRateUtil.calculateCost(currentTime - startTime);
			}
			else {
				/*
				 * Local variables representing the amount due for total parking time and
				 * the amount that was already paid (if you were rejected at the exit machine
				 * and had to come back to the payment machine).
				 */
				//Takes the amount due for the total time parked and subtracts
				//the amount you previously paid.
				double amountForTotalTime = ParkingRateUtil.calculateCost(currentTime - startTime);
				double paidBefore = ParkingRateUtil.calculateCost(paymentTime - startTime);
				paymentDue = amountForTotalTime - paidBefore;
			}	
			return paymentDue;
		}
		else {
			return 0.0;
		}
	}
	
	/**
	 * Updates the Ticket object with the payment time and adds the payment amount to this machine's total.
	 */
	public void makePayment() {
		if (inProgress == true) {
			totalPayments += getPaymentDue();
			paymentTime = internalClock.getTime();
			currentTicket.setPaymentTime(paymentTime);
		}
	}
	
	/**
	 * Simulates ejecting a ticket from this machine, after which another ticket can be inserted.
	 */
	public void ejectTicket() {
		inProgress = false;
	}
	
	/**
	 * Returns the total payments that have been made at this machine.
	 * @return
	 * 		Dollar amount of total payments made to this machine.
	 */
	public double getTotalPayments() { 
		return totalPayments;
	}
}
