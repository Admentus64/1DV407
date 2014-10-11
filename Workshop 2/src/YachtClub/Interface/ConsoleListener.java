/*
 * ConsoleListener.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.Interface;

/*
 * More Info Here!
 */
public interface ConsoleListener {  //Interface ConsoleListener starts
    
    /* Abstract methods */
    public abstract void presentWelcomeMessage();                               //Abstract method presentWelcomeMessage
    public abstract void presentInstructions();                                 //Abstract method presentInstructions
    public abstract void showOrderInstructions(String order);                   //Abstract method showOrderInstructions
    public abstract void showError(String err);                                 //Abstract method showError
    public abstract void showEmptyList(String contents);                        //Abstract method showEmptyList
    public abstract String print(String object);                                //Abstract method print
    
    /* Other methods */
    public String getInput();       //Method getInput
    public boolean isActive();      //Method isActive
    public void setInput();         //Method setInput
    
}   //Interface ConsoleListener ends