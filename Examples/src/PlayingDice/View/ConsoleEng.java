/*
 * ConsoleEng.java
 * Date: 23 September, 2014
 * Author: Tobias Ohlsson (Edited by Robert Willem Hallink)
 */
package PlayingDice.View;

/*
 * More Info Here!
 */
public class ConsoleEng extends Console {   //Class ConsoleEng starts
    
    @Override
    public boolean WantsToQuit() {  //Method WantsToQuit starts
        return GetInputChar() == 'q';
    }   //Method WantsToQuit ends
    
    @Override
    public void PresentWelcomeMessage() {   //Method PresentWelcomeMessage starts
        System.out.println("Hello Dice World");
    }   //Method PresentWelcomeMessage ends
    
    @Override
    public void PresentInstructions() {     //Method PresentInstructions starts
        System.out.println("Any key to play 'q' to quit");
    }   //Method PresentInstructions ends
    
    @Override
    public void PresentResult(boolean a_didWin) {   //Method PresentResult starts
        
        if (a_didWin)
            System.out.println("You Won!");
        else System.out.println("You Lost!");
        
    }   //Method PresentResult ends
    
}   //Class ConsoleEng ends