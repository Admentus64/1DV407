/*
 * Player.java
 * Date: 23 September, 2014
 * Author: Tobias Ohlsson (Edited by Robert Willem Hallink)
 */
package PlayingDice;

/*
 * More Info Here!
 */
public class Player {   //Class Player starts
    
    public static void main(String a_args[]) {  //Method main startd
        
        PlayingDice.Model.DiceGame g = new PlayingDice.Model.DiceGame();
        PlayingDice.View.Console v = new PlayingDice.View.ConsoleEng();
        PlayingDice.Controller.PlayGame c = new PlayingDice.Controller.PlayGame(v);
        
        g.Register(c);
        c.Play(g, v);
        
    }   //Method main ends
    
}   //Class Player ends