/*
 * INewGameStrategy.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson
 */
package BlackJack.model.rules;
import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

/*
 * Left untouched.
 */
public interface INewGameStrategy {
    
    boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
    
}