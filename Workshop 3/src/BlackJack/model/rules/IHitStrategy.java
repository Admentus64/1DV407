/*
 * IHitStrategy.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson
 */
package BlackJack.model.rules;
import BlackJack.model.Player;

/*
 * Left untouched.
 */
public interface IHitStrategy {
    
    boolean DoHit(Player a_dealer);
    
}