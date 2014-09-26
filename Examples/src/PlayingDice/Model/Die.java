/*
 * Die.java
 * Date: 23 September, 2014
 * Author: Tobias Ohlsson (Edited by Robert Willem Hallink)
 */
package PlayingDice.Model;

/*
 * More Info Here!
 */
public class Die {      //Class Die starts
    
    /* Private Variable Fields */
    private int m_value;
    
    
    
    /* Constructors ==> create new instance */
    public Die() { m_value = 0; }   //Constructor
    
    
    
    /* Accessors ==> read object states */
    public int GetValue() { return m_value; }   //Method getValue
    
    
    
    /* Mutators ==> update object states */
    public void Roll() {    //Method Roll starts
        
        try { Thread.sleep(2000); }
        catch (Exception e) {}
        m_value = (int)(Math.random() * 171717.0*6.0) % 6 + 1;
        
    }   //Method Roll ends
    
}   //Class Die ends