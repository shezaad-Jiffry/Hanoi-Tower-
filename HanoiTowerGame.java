//Student 1 full name:Shezaad Jiffry
//Student 2 full name:N/A
//==================================================

/**
 * The class <b>HanoiTowerGame</b> Handles all the game logic, which includes
 * the games state, checking if a move is legal, handeling how the disks are moved about
 * and how the gamestate is displayed to the console. This class is implemented in
 * the class <b>HanoiTower</b> where it is a functional 2 player game.
 */

import java.lang.Math;

public class HanoiTowerGame {

	private Stack[] towerValues;//holds the 3 instances of towers that can be played on  
	private int level;//how many turns passed
	private int getMaxLevels;//max amount of turns
	private GameState gameState;//can be winner looser or playing
	private int disks;//amount of disks being played with
	private int[] diskSize;//records the sizes of the disks being played
	/**
	 * Constructor that takes no arguments, not specified in the assignemnt document but
	 * neccecary for the junit to run properly. defaults disks to 3 when no disk amount 
	 * is given
	 * input:N/A
	 * output:N/A
	 */
	public HanoiTowerGame(){
		disks = 3;
		towerValues = new Stack[3];
		level = 0;
		getMaxLevels =2*((int)Math.pow(2,disks) -1);
		gameState = GameState.PLAYING;
		//fill first tower
		towerValues[0] = new LinkedStack();
		towerValues[1] = new LinkedStack();
		towerValues[2] = new LinkedStack();

		for(int i = disks; i > 0; i--){
			towerValues[0].push(i);
		
		}

	}
	/**
	 * Constructor that takes one argument in the form of how many disks
	 * are being played in the game. defaults tower values to 3 and
	 * calculates the max amount of levels as per the rules of the game.
	 * output: N/A
	 * @param disks represents how many disks will be played in the game.
	 */
	public HanoiTowerGame(int disks){
		this.disks = disks;
		towerValues = new Stack[3];
		level = 0;
		getMaxLevels =2*((int)Math.pow(2,disks) -1);
		gameState = GameState.PLAYING;
		//fill first tower
		towerValues[0] = new LinkedStack();
		towerValues[1] = new LinkedStack();
		towerValues[2] = new LinkedStack();
		
		for(int i = disks; i > 0; i--){
			towerValues[0].push(i);
			
		}

	}
    /**
     * Returns the amount of disks being played in the game
     * used in: HumanPlayer, play method as a way to print the amount of disks in play
     * input: N/A
     * @return disks being played in current game
    */
	public int getDisks(){
		return disks;
	}
	/**
     * Returns the amount of turns that have passed
     * used in: HumanPlayer, play method as a way to print the turns elapsed to the console
     * input: N/A
     * @return turns elapsed
    */
	public int getLevel(){
		return level;
	}
	/**
     * Returns the max amount of turns allowed in the game calculated
     * within the constructor
     * used in: HumanPlayer, play method as a way to print the max turns to the console
     * input: N/A
     * @return max turns allowed
    */
	public int getMaxLevels(){
		return getMaxLevels;
	}
	/**
     * Returns the game state that being PLAYING, WINNER or LOSER
     * used in: HumanPlayer, play method as a way to check if the game has ended or not
     * input: N/A
     * @return the game's current state of play
    */
	public GameState getGameState(){
		return gameState;
	}
	/**
     * Returns the amount of disks at a specified tower ie the size of the linked stack
     * used in: HanoiTowerGame in the method checkWinner specifically to check the third
     * tower's size
     * @param i has to be between 0-2 and specifies the tower
     * @return size of specified tower 
    */
	public int getDisksAtTower(int i){
		return towerValues[i].size();
	}
	/**
	 * The play method is the crux of this class. It allows the player
	 * to choose a sourcetower to take a ring from and a destination tower to put
	 * said ring on. It utilizes a helper method checkwinner to check if a 
	 * move would win the game and has logic to check if certain moves are
	 * legal or not
	 * used in: HumanPlayer, play method to facilitate playing the game in HanoiTower
	 * output: N/A
	 * @param sourceTower the tower where rings will be taken from
	 * @param destinationTower the tower where rings will be placed
    */
	public void play(int sourceTower, int destinationTower){
		//source tower empty 
		if(towerValues[sourceTower].isEmpty()){
			System.out.println("There is/are no disk/'s at tower " + sourceTower);
			return;
		}
		//first check if desination is null or not cause if it is then the move is legal
		if(towerValues[destinationTower].peek() != null){
			//destinationtower has bigger ring than source tower
			if((int)towerValues[destinationTower].peek() < (int)towerValues[sourceTower].peek()){
				System.out.println("invalid move!!");
				return;
			}
		}
		//pop the element in source tower put it onto destination tower
		int temp = (int)towerValues[sourceTower].pop();
		towerValues[destinationTower].push(temp);
		//check gamestate before turn count is incremented and after turn count is incremented
		if(gameState == GameState.PLAYING )
			checkWinner();
		level++;
		if(gameState == GameState.PLAYING)
			checkWinner();
		
	}
	/**
	 * Helper method for play, simply checks if the player won or lost.
	 * If all rings are on the third tower then it is a win, if the player
	 * took too many turns then they lost.
	 * used in: HanoiTowerGame, play method as a helper method to set the gamestate.
	 * input: N/A
	 * output: N/A
    */
	private void checkWinner(){
		if(getDisksAtTower(2) == disks)
			gameState = GameState.WINNER;
		if(level >= getMaxLevels)
			gameState = GameState.LOSER;

	}
	/**
	 * returns a string representation of the game's state of play. 
	 * used in: HumanPlayer, play method in order to print a visual representation 
	 * to the console
	 * input: N/A
	 * @return string represenation of the game.
    */
	public String toString(){
		String tower = "";//string representation
		String[] towerSizes;//individual ring sizes from towers stored in an array
		int size;//individual ring size in integer form converted from towersizes array
		int counter = 0;//used to iterate through towersize array without nesting another loop
		for(int i = 0; i < towerValues.length; i++){//individual towers
			counter = 0;//always reset counter to 0 when a new tower is being printed
			tower += "Tower " + (i + 1) + Utils.NEW_LINE;
			towerSizes = towerValues[i].toString().split(",");//we call the to string method of linked stack and comma seperate it to get the raw values
			for(int j = 0; j < disks; j++){//amount of rings inside a tower
				if(towerValues[i].size() -1 >= j){//if the disk total is 3 but the tower size is 2 then only print "-" when hitting the value
					try{//try to set size if you cant then just set size to 0
						size = Integer.parseInt(towerSizes[counter]);//convert the value found in tostring() into an integer to be used in a last loop
					}
					catch(NumberFormatException e){
						size = 0;
					}
					for(int k = 0; k < size; k++){//prints appropriate amount of "-" for the size of the ring
						tower+= "-";

					}
				counter++;//increment counter if "-" was printed
				}
			tower += Utils.NEW_LINE;
			}
		}
		return tower;
	}
}
