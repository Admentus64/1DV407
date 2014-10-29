/*
 * Dealer.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.model;
import BlackJack.model.rules.*;

/*
 * Changed quite a lot.
 * The method IsDealerWinner is now directed by a RulesFactory implementation instead of doing it within this class.
 * A private method DealCard is added, it is no longer required writing 3 lines of code each time when to add a new card, it is now done by calling this method.
 */
public class Dealer extends Player {
    
    private Deck m_deck;
    private final INewGameStrategy m_newGameRule;
    private final IHitStrategy m_hitRule;
    private final IWinStrategy m_winRule;
    
    public Dealer(RulesFactory a_rulesFactory) {
        
        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();
        m_winRule = a_rulesFactory.GetWinRule();
        
        //Was not used in official example
        /* for (Card c : m_deck.GetCards()) {
            c.Show(true);
            System.out.println("" + c.GetValue() + " of " + c.GetColor());
        } */
        
    }
    
    public boolean NewGame(Player a_player) {
        
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(m_deck, this, a_player);   
        }
        return false;
        
    }
    
    public boolean Hit(Player a_player) {
        
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            DealCard(true, a_player);
            return true;
        }
        return false;
        
    }
    
    public boolean IsDealerWinner(Player a_player) {
        
        return m_winRule.DealerWins(this, a_player);
        
        //The old win rule
        /* if (a_player.CalcScore() > g_maxScore)
            return true;
        else if (CalcScore() > g_maxScore)
            return false;
        return CalcScore() >= a_player.CalcScore(); */
        
    }
    
    public boolean IsGameOver()     { return m_deck != null && m_hitRule.DoHit(this) != true; }
    
    public boolean Stand(Player a_player) {
        
        if (m_deck != null) {
            ShowHand();
            while (m_hitRule.DoHit(this)) {
                m_hitRule.DoHit(this);
                DealCard(true, this);
            }
            return true;
        }
        return false;
        
    }
    
    private void DealCard(boolean show, Player a_player) {
        
        Card c = m_deck.GetCard();
        c.Show(show);
        a_player.DealCard(c);
        
    }
    
}