import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author Richard Shepard
 * @Feb 14, 2015
 */
public class Validate {

	private static final int MAX_NUM_DICE = 10;
	private static ArrayList<Integer> validTypes;
	
	/**
	 * Initializes the arraylist with the
	 * valid types of dice
	 */
	public Validate(){
		validTypes = new ArrayList<>();
		validTypes.add(4);
		validTypes.add(6);
		validTypes.add(8);
		validTypes.add(10);
		validTypes.add(12);
		validTypes.add(20);
		validTypes.add(100);
	}
	
	/**
	 * Validates user input for number of dice
	 * 
	 * @param input Number of Dice
	 * @return validation True if valid
	 */
	public boolean numDice(int input) {
		boolean validation = true;
		if(input > MAX_NUM_DICE  || input <= 0) {
			validation = false;
			System.out.println("Invalid number of dice. Try Again...");
		}
		return validation;
	}
	
	/**
	 * Validates user input for type of dice
	 * 
	 * @param input die type
	 * @return validation True if valid
	 */
	public boolean dieTypes(int input) {
		boolean validation = true;
		Iterator<Integer> it = validTypes.iterator();
		while(!validation && it.hasNext()) {
			if(it.next() == input) {
				validation = true;
			}
		}
		if(validation == false) {
			System.out.println("Invalid die type. Try Again...");
		}
		return validation;
	}
	
	/**
	 * Validates Min and Max input from the user
	 * 
	 * @param max Max value
	 * @param min Minimum value
	 * @return validation True if valid
	 */
	public boolean maxMin(int max, int min) {
		boolean validation = true;
		if(max < min || max < 0 || min <0) {
			validation = false;
			System.out.println("Invalid target numbers. Try Again...");
		}
		return validation;
	}
	
}
