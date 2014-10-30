/*
 * AView.java
 * Date: 30 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.view;
import BlackJack.controller.PlayGame;
import java.io.IOException;

/*
 * New abstract class that implements the GetInput for extended classes.
 */
public abstract class AView implements IView {
    
    private final static int playAction = 'p';
    private final static int hitAction = 'h';
    private final static int standAction = 's';
    private final static int quitAction = 'q';
    
    
    
    //Not being used anymore
    /* @Override
    public int GetInput() {
        
        try { return System.in.read(); }
        catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
        
    } */
    
    
    
    //New method for input
    @Override
    public PlayGame.gameAction GetInput() {
            
            int input = ReadInput();
            DisplayLastInput();
            System.out.println((char) input);
            return ReturnGameAction(input);
            
    }   
    
    
    
    //Helping methods for GetInput
    private int ReadInput() {
        
        try { return (char) System.in.read(); }
        catch (IOException e) {
            System.out.println(e);
            return quitAction;
        }
        
    }
    
    
    private PlayGame.gameAction ReturnGameAction(int input) {
    
        if (input == playAction)
            return PlayGame.gameAction.play;
        else if (input == hitAction)
            return PlayGame.gameAction.hit;
        else if (input == standAction)
            return PlayGame.gameAction.stand;
        else if (input == quitAction)
            return PlayGame.gameAction.quit;
        else return PlayGame.gameAction.invalid;
    
    }
    
}
