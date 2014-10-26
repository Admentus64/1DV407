/*
 * Player.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.model;
import java.util.List;
import java.util.LinkedList;

/*
 * Mostly left untouched.
 * Code regarding hidden cards is adjusted (see Card.java).
 */
public class Player {
    
    private final List<Card> m_hand;
    protected final int g_maxScore = 21;
    
    public Player() {
  
        m_hand = new LinkedList<>();
        
    }
    
    public void DealCard(Card a_addToHand)      { m_hand.add(a_addToHand); }
    public Iterable<Card> GetHand()             { return m_hand; }
    public void ClearHand()                     { m_hand.clear(); }
    
    public void ShowHand() {
        
        m_hand.stream().forEach((c) -> {
            c.Show(true);
        });
        
    }
    
    public int CalcScore() {
        
        // the number of scores is dependant on the number of scorable values
        // as it seems there is no way to do this check at compile time in java ?!
        // cardScores[13] = {...};
        int cardScores[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11 };
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
        
        int score = 0;
        
        for (Card c : GetHand())
            if (!c.IsHidden())
                score += cardScores[c.GetValue().ordinal()];

        if (score > g_maxScore)
            for (Card c : GetHand())
                if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
                    score -= 10;
        
        return score;
        
    }
    
}