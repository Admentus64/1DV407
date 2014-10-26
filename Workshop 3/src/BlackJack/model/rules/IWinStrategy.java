/*
 * IWinStrategy.java
 * Date: 26 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.model.rules;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

/*
 * Newly added interface.
 * Supports win varation rules.
 * This interface is used within the RulesFactory.
 */
public interface IWinStrategy {
    
    boolean DealerWins(Dealer a_dealer, Player a_player);
    
}
