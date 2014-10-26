/*
 * Card.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.model;

/*
 * Mostly left untouched.
 * Removed the enum value "Hidden".
 * Instead, a new public boolean method IsHidden is added which returns the value m_isHidden (did already exist).
 * Code that required the enum value "Hidden" were changed to use this newly added method IsHidden.
 */
public class Card {
    
    private final Color m_color;
    private final Value m_value;
    private boolean m_isHidden;
    
    public enum Color {
        
        Hearts,
        Spades,
        Diamonds,
        Clubs,
        Count,
        
    }
    
    public enum Value {
        
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Knight,
        Queen,
        King,
        Ace,
        Count,
        
    }
    
    public Card(Color a_color, Value a_value) {
        
        m_value = a_value;
        m_color = a_color;
        m_isHidden = true;
        
    }
    
    public Color GetColor()             { return m_color; }
    public Value GetValue()             { return m_value; }
    public void Show(boolean a_show)    { m_isHidden = !a_show; }
    public boolean IsHidden()           { return m_isHidden; }
    
}