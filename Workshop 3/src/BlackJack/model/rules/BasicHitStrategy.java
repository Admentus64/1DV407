/*
 * BasicHitStrategy.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson
 */
package BlackJack.model.rules;
import BlackJack.model.Player;

/*
 * Left untouched.
 */
class BasicHitStrategy implements IHitStrategy {
    
    private final int g_hitLimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {
        return a_dealer.CalcScore() < g_hitLimit;
    }
    
}
