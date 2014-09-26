/*
 * Console.java
 * Date: 23 September, 2014
 * Author: Tobias Ohlsson (Edited by Robert Willem Hallink)
 */
package PlayingDice.View;

/*
 * More Info Here!
 */
public abstract class Console {      //Abstract Class Console starts
    
    /* Abstract Methods */
    public abstract boolean WantsToQuit();                  //Abstract WantsToQuit
    public abstract void PresentWelcomeMessage();           //Abstract PresentWelcomeMessage
    public abstract void PresentInstructions();             //Abstract PresentInstructions
    public abstract void PresentResult(boolean a_didWin);   //Abstract PresentResult
    
    
    
    /* Other Methods */
    public void PresentDieValue(int a_dieValue) {   //Method PresentDieValue starts
        System.out.print("" + a_dieValue + " ");
    }   //Method PresentDieValue ends
    
    
    
    /* Private Methods */
    protected int GetInputChar() {    //Method GetInputChar starts
        
        try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
                c = System.in.read();
            }
            return c;
        }
        catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
        
    }   //Method GetInputChar ends
    
}   //Class Console ends