/*
 * EqualScoreDealerWinStrategy.java
 * Date: 26 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.model.rules;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

/*
 * Newly added class.
 * Extends upon the AWinStrategy class.
 * This implementation contains the rule that the dealer wins on equal score with the player.
 */
public class EqualScoreDealerWinStrategy extends AWinStrategy {
    
    @Override
    public boolean DealerWins(Dealer a_dealer, Player a_player) {
        
        if (a_player.CalcScore() == 21 && a_dealer.CalcScore() == 21)
            return true;
        return NormalDealerWinRule(a_dealer, a_player);
        
    }
    
}
