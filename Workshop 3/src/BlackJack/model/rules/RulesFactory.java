/*
 * RulesFactory.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.model.rules;

/*
 * Mostly left untouched.
 * Added a new IWinStrategy implementation into this file.
 */
public class RulesFactory {
    
    public IHitStrategy GetHitRule()            { return new Soft17HitStrategy(); }
    public INewGameStrategy GetNewGameRule()    { return new AmericanNewGameStrategy(); }
    public IWinStrategy GetWinRule()            { return new EqualScoreDealerWinStrategy(); }
    
}