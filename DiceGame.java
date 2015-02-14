import java.util.ArrayList;


/**
 * @author Richard Shepard
 * @Feb 14, 2015
 */

public class DiceGame {
	
	private Validate validate;
	private ArrayList<Dice> dice;
	private int dieType;
	private int numDice;
	private int maxTarget;
	private int minTarget;
	private int total;
	
	/**
	 * Constructor initializes a new DiceGame
	 */
	public DiceGame() {
		dice = new ArrayList<>();
		validate = new Validate();
		initGame();
	}
	
	/**
	 * Gets input from user and initializes an arraylist of Dice
	 * to the appropriate parameters
	 */
	private void initGame() {
		getInput();
		initArray();
	}
	
	/**
	 * Gets input from user and validates input:
	 * 		Number of Dice
	 * 		Sides of Dice
	 * 		Max Target
	 * 		Min Target
	 */
	private void getInput() {
		boolean isCorrect = false;
		while(!isCorrect) {
			System.out.print("How many dice would you like to roll? ");
			numDice = TextIO.getlnInt();
			isCorrect = validate.numDice(numDice);
		}
		isCorrect = false;
		while(!isCorrect) {
			System.out.print("How many sides would you like your dice to have? ");
			dieType = TextIO.getlnInt();
			isCorrect = validate.dieTypes(dieType);
		}
		isCorrect = false;
		while(!isCorrect) {
			System.out.print("What is your max target number? ");
			maxTarget = TextIO.getlnInt();
			System.out.print("What is your min target number? ");
			minTarget = TextIO.getlnInt();
			isCorrect = validate.maxMin(maxTarget, minTarget);
		}
	}
	
	/**
	 * Initializes arrayList with dice
	 */
	private void initArray() {
		for(int i = 0; i < numDice; i++) {
			dice.add(new Dice(dieType));
		}
	}
	
	/**
	 * Starts the game play
	 */
	public void play() {
		final int MAX_ONES = numDice/2;
		boolean rollAgain = true;
		while(rollAgain) {
			int onesRolled = 0;
			total = 0;
			for(int i = 0; i < numDice; i++) {
				int currentRoll = 0;
				currentRoll = dice.get(i).roll();
				System.out.println("You rolled: " + currentRoll);
				if(currentRoll == dieType) {
					System.out.println("You matched your die type, another roll will be added");
					int anotherRoll = dice.get(i).roll();
					System.out.println("Your Bonus roll is: " + anotherRoll);
					currentRoll += anotherRoll;
				} else if(currentRoll == 1){
					onesRolled++;
				}
				total += currentRoll;
			}
			if(total < maxTarget && total > minTarget && onesRolled < MAX_ONES) {
				System.out.println("You win with a total of " + total + " which is less than " + maxTarget +
						" and more than " + minTarget);
			} else {
				System.out.println("You lose you rolled " + total + " with " + onesRolled + " ones rolled");
			}
			System.out.print("Would you like to roll again: ");
			rollAgain = TextIO.getlnBoolean();
		}
	}
	

}
