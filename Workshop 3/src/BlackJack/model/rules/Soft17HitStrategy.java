/*
 * BasicHitStrategy.java
 * Date: 26 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.model.rules;
import BlackJack.model.Card;
import BlackJack.model.Player;

/*
 * Newly added class.
 * Implements the IHitStrategy, using a new rule variant for taking card for the dealer.
 * With this rule, the dealer takes an extra card if the dealer ace an "ace" and a combination of 6.
 * In case the dealer would receive a too high score with this extra card, the value of his "ace" will be reduced to 1 instead of 11.
 */
class Soft17HitStrategy implements IHitStrategy {
    
    private final int g_hitLimit = 17;
    
    @Override
    public boolean DoHit(Player a_dealer) {
        
        if (Soft17(a_dealer))
            return true;
        return a_dealer.CalcScore() < g_hitLimit;  
        
    }
    
    private boolean Soft17(Player a_dealer) {
        
        if (a_dealer.CalcScore() == g_hitLimit)
            for (BlackJack.model.Card a_card : a_dealer.GetHand())
                if (a_card.GetValue() == Card.Value.Ace)
                    return true;
        return false;
        
    }
    
}