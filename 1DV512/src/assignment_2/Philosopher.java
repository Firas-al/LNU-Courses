package assignment_2;
/*
 * File:	Philosopher.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti (modified by Kostiantyn Kucher)
 * Date: 	November 2019
 */

import java.util.Random;

/**
 * The skeleton is created by <i>Suejb Memeti</i> & modified by <i>Kostiantyn Kucher</i>.
 * <br>Though the Implementation is done by <i>Cusatelli</i>.
 * @version 1.0
 * @author cusatelli
 */
public class Philosopher implements Runnable {
	
	/*
	 * Controls whether logs should be shown on the console or not.
	 * Logs should print events such as: state of the philosopher, and state of the chopstick
	 * 		for example: philosopher # is eating;
	 * 		philosopher # picked up the left chopstick (chopstick #)
	 */
	public boolean DEBUG = false;
	
	private int id;
	
	private final Chopstick leftChopstick;
	private final Chopstick rightChopstick;
	
	private Random randomGenerator = new Random();
	
	private int numberOfEatingTurns = 0;
	private int numberOfThinkingTurns = 0;
	private int numberOfHungryTurns = 0;

	private double thinkingTime = 0;
	private double eatingTime = 0;
	private double hungryTime = 0;
	
	// Add New Fields here:
	// Variables to save in field for use in run().
	private Thread thread_01; // For example use thread_01 when determining the active thread.
	private long startTime;
	public States state;
	
	/**
	 * An <i>Enumeration</i> of the possible <b>States</b> a Philosopher can have during runtime.
	 * @version 1.0
	 * @author cusatelli
	 */
	public enum States {
		THINKING,
		HUNGRY,
		EATING;
	}
	
	public String StateManager(States state) {
		switch(state) {
		case THINKING:
			return "Thinking";
		case HUNGRY:
			return "Hungry";
		case EATING:
			return "Eating";
		default:
			return "Default State";
		}
	}
	
	/**
	 * <b>StateManager</b> determines which action to take whenever 
	 * a Philosopher is in a particular state.
	 * 
	 * @param
	 * @return <b>String</b> of Philosophers current <b>state</b>
	 * @version 1.0
	 * @author cusatelli
	 */
	public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick, int seed, boolean debug) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		
		this.DEBUG = debug;
		
		/*
		 * set the seed for this philosopher. To differentiate the seed from the other philosophers, we add the philosopher id to the seed.
		 * the seed makes sure that the random numbers are the same every time the application is executed
		 * the random number is not the same between multiple calls within the same program execution 
		 
		 * NOTE
		 * In order to get the same average values use the seed 100, and set the id of the philosopher starting from 0 to 4 (0,1,2,3,4). 
		 * Each philosopher sets the seed to the random number generator as seed+id. 
		 * The seed for each philosopher is as follows:
		 * 	 	P0.seed = 100 + P0.id = 100 + 0 = 100
		 * 		P1.seed = 100 + P1.id = 100 + 1 = 101
		 * 		P2.seed = 100 + P2.id = 100 + 2 = 102
		 * 		P3.seed = 100 + P3.id = 100 + 3 = 103
		 * 		P4.seed = 100 + P4.id = 100 + 4 = 104
		 * Therefore, if the ids of the philosophers are not 0,1,2,3,4 then different random numbers will be generated.
		 */
		
		randomGenerator.setSeed(id+seed);
	}
	public int getId() {
		return id;
	}

	public double getAverageThinkingTime() {
		/* TODO
		 * Return the average thinking time
		 * Add comprehensive comments to explain your implementation
		 */
		
		// Divide Thinking Time with Number Of Thinking Turns = Average Thinking Time.
		return thinkingTime / numberOfThinkingTurns;
	}

	public double getAverageEatingTime() {
		/* TODO
		 * Return the average eating time
		 * Add comprehensive comments to explain your implementation
		 */

		// Divide Eating Time with Number Of Eating Turns = Average Eating Time.
		return eatingTime / numberOfEatingTurns;
	}

	public double getAverageHungryTime() {
		/* TODO
		 * Return the average hungry time
		 * Add comprehensive comments to explain your implementation
		 */

		// Divide Hungry Time with Number Of Hungry Turns = Average Hungry Time.
		return hungryTime / numberOfEatingTurns;
	}
	
	public int getNumberOfThinkingTurns() {
		return numberOfThinkingTurns;
	}
	
	public int getNumberOfEatingTurns() {
		return numberOfEatingTurns;
	}
	
	public int getNumberOfHungryTurns() {
		return numberOfHungryTurns;
	}

	public double getTotalThinkingTime() {
		return thinkingTime;
	}

	public double getTotalEatingTime() {
		return eatingTime;
	}

	public double getTotalHungryTime() {
		return hungryTime;
	}

	@Override
	public void run() {
		/* TODO
		 * (Initialize some additional variables, if necessary) 
		 * 
		 * Think,
		 * Get hungry,
		 * Pick up the left and then the right chopstick,
		 * Eat,
		 * Release the chopsticks.
		 * ^^^ Repeat until the thread is interrupted 
		 * 		 
		 * Increment the thinking/hungry/eating turns counter *when each turn starts*.
		 * 
		 * Update the duration of each turn *after the turn is completely finished*.
		 * Keep track of total hungry turn durations by getting the current timestamp with System.currentTimeMillis()
		 * when the turn starts, then another System.currentTimeMillis() after the turn has finished, and subtracting these. 
		 * For thinking and eating turns, use the duration generated with randomGenerator.nextInt(1000).
		 * 
		 * If DEBUG is true, print the log messages for each event.
		 * Additionally, you might want to print a message such as "philosopher X has finished" when the thread terminates
		 * (for debugging purposes).
		 * 
		 * 
		 * Add comprehensive comments to explain your implementation, including deadlock prevention/detection.
		 * You should start with a straightforward implementation, but you will eventually have to make it more sophisticated
		 * w.r.t the order (and conditions) of the actions and the threads synchronization in order to pass the tests with the expected results!
		 */
		
		start(); // Initialize Variables.
		
		while(!isInterrupted(thread_01)) {
			
		}
	}
	
	/**
	 * Initialize all Variables before run() in start().<br>
	 * This is to keep run() as clean as possible.
	 * 
	 * @author cusatelli
	 */
	void start() {
		// Initialize Variables:
		state = States.THINKING; // Set Starting State to THINKING.
		startTime = 0; // Set Starting Time to 0.
		thread_01 = Thread.currentThread(); // Set thread_01 to the current Thread.
	}
	
	/**
	 * Check if Thread was ever interrupted & if so return this value.<br>
	 * This method serves only as a purpose to confirm the<br>
	 * Interruption of a Thread during DEBUG mode.
	 * 
	 * @param thread
	 * @return true if Thread was interrupted, otherwise false
	 * @author cusatelli
	 */
	boolean isInterrupted(Thread thread) {
		if(thread.interrupted()) {
			if(DEBUG) { System.out.println("Thread: " + thread + "\n    was interrupted"); }
			return true;
		
		} else {
			if(DEBUG) { System.out.println("Thread: " + thread + "\n    was not interrupted"); }
			return false;
		}
	}
}