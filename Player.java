//Student 1 full name:Shezaad Jiffry
//Student 2 full name:N/A
//==================================================

/**
 * The Interface <b>Player</b> is implemented in the class HumanPlayer. 
 * it has two methods that must be implemented, play and getscore,
 * the methods are needed to facilitate human interaction in 
 * the game and keep track of the current score respectivley.
 */

public interface Player {
    /**
     * the method play allows the player to have input in the game of hanoi tower
     * as well as incrementing score appropriatly when the game is won or lost
     * implemented in: Human player with all the methods fully realised
     * output:N/A
     * @param game an instance of the HanoiTowerGame class that allows the game to be played
    */
	public abstract void play(HanoiTowerGame game);
    /**
     * the method getScore is a simple getter that returns the current score value
     * implemented in: Human player with all the methods fully realised
     * @return the current score the player has that is mainly used to print to the console for readability
    */
    public abstract int getScore();
}