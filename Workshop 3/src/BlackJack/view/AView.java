/*
 * AView.java
 * Date: 30 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.view;
import BlackJack.controller.PlayGame;
import java.io.IOException;
import java.util.ArrayList;

/*
 * New abstract class that implements the GetInput for extended classes.
 */
public abstract class AView implements IView {
    
    private final ArrayList<CommandInput> commandList;
    //private final int playInput;              //Not needed
    //private final int hitInput;               //Not needed
    //private final int standInput;             //Not needed
    private final char quitInput;
    
    
    
    public AView() {
        
        commandList = new ArrayList<>();
        CommandInput cmd;
        
        cmd = new CommandInput('p', PlayGame.command.play);
        commandList.add(cmd);
        cmd = new CommandInput('h', PlayGame.command.hit);
        commandList.add(cmd);
        cmd = new CommandInput('s', PlayGame.command.stand);
        commandList.add(cmd);
        cmd = new CommandInput('q', PlayGame.command.quit);
        commandList.add(cmd);
        quitInput = cmd.getChar();
        
    }
    
    
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
    public PlayGame.command GetInput() {
            
            int input = ReadInput();
            DisplayLastInput();
            System.out.println((char) input);
            return ReturnCommand(input);
            
    }   
    
    
    
    //Helping methods for GetInput
    private int ReadInput() {
        
        try { return (char) System.in.read(); }
        catch (IOException e) {
            System.out.println(e);
            return quitInput;
        }
        
    }
    
    private PlayGame.command ReturnCommand(int input) {
        
        for (int i=0; i<commandList.size(); i++)
            if (input == commandList.get(i).getChar())
                return commandList.get(i).getCommand();
        return PlayGame.command.invalid;
        
    }
    
}
