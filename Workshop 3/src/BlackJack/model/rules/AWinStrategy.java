/*
 * AWinStrategy.java
 * Date: 26 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.model.rules;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

/*
 * Newly added class.
 * This is an abstract implementation of the IWinStrategy interface (which is also new).
 * This class requires an implementation but already contains the basic win rule.
 */
public abstract class AWinStrategy implements IWinStrategy {
    
    protected final int g_scoreLimit = 21;
    
    protected boolean NormalDealerWinRule(Dealer a_dealer, Player a_player) {
        
        if (a_player.CalcScore() > g_scoreLimit)
            return true;
        else if (a_dealer.CalcScore() > g_scoreLimit)
            return false;
        return a_dealer.CalcScore() >= a_player.CalcScore();
        
    }
    
}