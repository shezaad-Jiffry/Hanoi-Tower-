//Student 1 full name:Shezaad Jiffry
//Student 2 full name:N/A
//==================================================

/**
 * The class <b>HumanPlayer</b> is the class that controls the human's plays.
 * It implements Player which allows it to use HanoiTowerGame.java, allowing
 * human input and therefore gameplay. It asks the player for two inputs and
 * then updates the gameboard depending on if the play was legal
 */


public class HumanPlayer implements Player {
    private int score = 0;
    /**
     * Simply returns the current score, also is a 
     * method implemented from the player interface
     * used in: HanoiTower to output the current score
     * input: N/A
     * @return players score
    */
    public int getScore(){
        return score;
    }
    /**
     * Crux of the HumanPlayer class that allows human input in the game of HanoiTower 
     * as well as a way to inrement the score when the player wins. asks for two inputs, 
     * the source tower and destination tower both integers between 1-3 and allows the 
     * player to play until they either win or lose.
     * used in: HanoiTower as a way to facilitate human input when playing the game
     * output:N/A
     * @param game an instance of the HanoiTowerGame class that allows the game to be played
    */
    public void play(HanoiTowerGame game){
        int sourceTower, destinationTower;
        //pre game output instructions 
        System.out.println(game);
        System.out.println("Your goal is to move " +game.getDisks() + " disks from tower 1 to 3");
        System.out.println("Only one simple rule: no large disk on the top of a smaller one!");
        System.out.println("Enter the source and the destination towers each on a single line:");
        do{
         sourceTower = Integer.parseInt(Utils.console.readLine()) - 1;
         destinationTower = Integer.parseInt(Utils.console.readLine()) - 1;
         game.play(sourceTower, destinationTower);
         System.out.println(game);
         System.out.println("Moves played " + game.getLevel() + " Max " + game.getMaxLevels());
        }while(game.getGameState() == GameState.PLAYING);
        if(game.getGameState() == GameState.WINNER){
            score++;
            System.out.println("you did it within the allowed number of moves!");
        }
        else
            System.out.println("You finished the allowed number of moves!");

        System.out.println("your score is "+ score);
        System.out.println("=================================");
    }

}