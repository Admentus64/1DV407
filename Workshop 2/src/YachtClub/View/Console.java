/*
 * Console.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.View;
import YachtClub.Interface.ConsoleListener;
import java.util.Scanner;

/*
 * More Info Here!
 */
public abstract class Console implements ConsoleListener {      //Abstract class Console starts
    
    /* Private Variable Fields */
    protected boolean active = true;
    protected String input = "";
    protected Scanner scan;	
    
    
    
    /* Constructors ==> create new instance */
    public Console(Scanner scan) {  //Constructor starts
        
        if (scan != null)
            this.scan = scan;
        else this.scan = new Scanner(System.in);
        
    }   //Constructor ends
    
    
    
    /* Abstract methods */
    @Override   public abstract void presentWelcomeMessage();                   //Abstract method presentWelcomeMessage
    @Override   public abstract void presentInstructions();                     //Abstract method presentInstructions
    @Override   public abstract void showOrderInstructions(String order);       //Abstract method showOrderInstructions
    @Override   public abstract void showError(String err);                     //Abstract method showError
    @Override   public abstract void showEmptyList(String contents);            //Abstract method showEmptyList
    @Override   public abstract String print(String object);                    //Abstract method print
    
    
    
    /* Accessors ==> read object states */
    @Override   public String getInput() { return input; }  //Method getInput
    
    @Override
    public boolean isActive() {     //Method isActive starts
        
        if (input.equals("q") || input.equals("Q"))
            quit();
        return active;
        
    }   //Method isActive ends
    
    
    
    /* Mutators ==> update object states */
    @Override
    public String setInput() {  //Method getInput starts
        
        input = "";
        try { input = scan.next(); }
        catch (Exception e) {
            System.err.println("Error with input! Exception: " + e);
            quit();
        }
        return input;
        
    }   //Method getInput ends
    
    @Override
    public String setLineInput() {  //Method getLineInput starts
        
        input = "";
        try { input = scan.nextLine(); }
        catch (Exception e) {
            System.err.println("Error with input! Exception: " + e);
            quit();
        }
        return input;
        
    }   //Method getLineInput ends
    
    
    
    /* Private help methods */
    protected void quit() {     //Method quit starts
        
        active = false;
        try                 { scan.close(); }
        catch (Exception e) { System.out.println("Error with closing input! Exception: " + e); }
        
    }   //Method quit ends
    
}   //Abstract class Console ends