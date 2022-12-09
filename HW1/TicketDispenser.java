package hw1;

/**
 * Model of a ticket dispenser that dispenses a ticket object.
 * @author logan
 */
public class TicketDispenser {
	
	/*
	 * A simple clock object.
	 */
	private SimpleClock ticketDispenserClock;
	
	/**
	 * Constructs a TicketDispenser that uses the given clock. 
	 * @param givenClock
	 * 		A clock object.
	 */
	public TicketDispenser(SimpleClock givenClock) {
		ticketDispenserClock = givenClock;
	}
	
	/**
	 * Constructs and returns a new Ticket object. The constructed
	 * ticket will have a start time based on the current value of
	 * the ticket dispenser's clock and a payment time of zero.  
	 * @return
	 * 		Ticket object.
	 */
	public Ticket takeTicket() {
		Ticket t = new Ticket(ticketDispenserClock.getTime());
		t.setPaymentTime(0);
		return t;
	}
}
