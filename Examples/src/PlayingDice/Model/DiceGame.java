/*
 * DiceGame.java
 * Date: 23 September, 2014
 * Author: Tobias Ohlsson (Edited by Robert Willem Hallink)
 */
package PlayingDice.Model;
import java.util.LinkedList;
import java.util.List;

/*
 * More Info Here!
 */
public class DiceGame {     //Class DiceGame starts
    
    /* Private Variable Fields */
    private final List<DieRolledListener> m_subscribers;
    private final Die m_d1;
    private final Die m_d2;
    
    
    
    /* Constructors ==> create new instance */
    public DiceGame() { //Constructor starts
        
        m_d1 = new Die();
        m_d2 = new Die();
        m_subscribers = new LinkedList<>();
        
    }   //Constructor ends
    
    
    
    /* Accessors ==> read object states */
    public int GetDie1Value() { return m_d1.GetValue(); }   //Method GetDie1Value
    public int GetDie2Value() { return m_d2.GetValue(); }   //Method GetDie2Value
    
    
    
    /* Mutators ==> update object states */
    public void Register(DieRolledListener a_subscriber) {  //Method Register starts
        m_subscribers.add(a_subscriber);
    }   //Method Register ends
    
    
    
    /* Other Methods */
    public boolean Play() { //Method Play starts
        
        m_d1.Roll();
        m_d2.Roll();
    
        return m_d1.GetValue() + m_d2.GetValue() == 7;
        
    }   //Method Play ends
    
    
    
    /* Private Methods */
    private void RollDie(Die a_die) {   //Method RollDie starts
        
        a_die.Roll();
        m_subscribers.stream().forEach((l) -> {
            l.DieRolled(a_die.GetValue());
        });
        
    }   //Method RollDie ends
    
}   //Class DiceGame ends