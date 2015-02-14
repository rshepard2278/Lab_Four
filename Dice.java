import java.util.Random;

/**
 * @author Richard Shepard
 * @Feb 14, 2015
 */

public class Dice {
	
	private int sides;
	private int value;
	private Random rand;
	
	/**
	 * Default constructor for a 6 sided die
	 */
	public Dice() {
		this(6);
	}
	
	/**
	 * Constructor creates a die with a parameter
	 * passed for the number of sides
	 * @param sides The number of sides of the dice
	 */
	public Dice(int sides) {
		this.sides = sides;
		rand = new Random();
	}
	
	/**
	 * Rolls the dice and returns the value
	 * @return value the value rolled
	 */
	public int roll() {
		value = rand.nextInt(sides) + 1;
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dice [value=" + value + "]";
	}
}
