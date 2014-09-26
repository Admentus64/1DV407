/*
 * ConsoleSwe.java
 * Date: 23 September, 2014
 * Author: Tobias Ohlsson (Edited by Robert Willem Hallink)
 */
package PlayingDice.View;

/*
 * More Info Here!
 */
public class ConsoleSwe extends Console {   //Class ConsoleSwe starts
    
    @Override
    public boolean WantsToQuit() {  //Method WantsToQuit starts
        return GetInputChar() == 's';
    }   //Method WantsToQuit ends
    
    @Override
    public void PresentWelcomeMessage() {   //Method PresentWelcomeMessage starts
        System.out.println("Hej Speltärningsvärlden");
    }   //Method PresentWelcomeMessage ends
    
    @Override
    public void PresentInstructions() {     //Method PresentInstructions starts
        System.out.println("Tryck en tangent för att spela 's' för att sluta");
    }   //Method PresentInstructions ends
    
    @Override
    public void PresentResult(boolean a_didWin) {   //Method PresentResult starts
        
        if (a_didWin)
            System.out.println("Du Vann!");
        else System.out.println("Du förlorade!");
        
    }   //Method PresentResult ends

}   //Class ConsoleSwe ends