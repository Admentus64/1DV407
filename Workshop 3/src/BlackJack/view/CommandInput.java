/*
 * CommandInput.java
 * Date: 2 November, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.view;
import BlackJack.controller.PlayGame;

/*
 * New class for assigning an char to a command, so it can be used in a list.
 * It is used in the AView class in order to only use checks once, this prevents mistakes when rewriting commands.
 */
public class CommandInput {
    
    private final char c;
    private final PlayGame.command cmd;
    
    
    
    public CommandInput(char c, PlayGame.command cmd) {
        this.c = c;
        this.cmd = cmd;
    }
    
    public char getChar()                       { return c; }
    public PlayGame.command getCommand()        { return cmd; }
    
}
