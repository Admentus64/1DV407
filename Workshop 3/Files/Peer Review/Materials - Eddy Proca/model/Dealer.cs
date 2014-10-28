using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model
{
    class Dealer : Player
    {
        private Deck m_deck = null;
        private rules.INewGameStrategy m_newGameRule;
        private rules.IHitStrategy m_hitRule;
        private rules.IWinRule m_winRule;
        private rules.IMaxScoreRule m_maxScoreRule;
        private List<CardDealtListener> m_subscribers;
        public Dealer(rules.RulesFactory a_rulesFactory)
        {
            m_newGameRule = a_rulesFactory.GetNewGameRule();
            m_hitRule = a_rulesFactory.GetHitRule();
            m_winRule = a_rulesFactory.GetWinRule();
            m_maxScoreRule = a_rulesFactory.getMaxScoreRule();
            m_subscribers = new List<CardDealtListener>();
        }
        public void Register(CardDealtListener a_subscriber)
        {
            m_subscribers.Add(a_subscriber);
        }
        public bool NewGame(Player a_player)
        {
            if (m_deck == null || IsGameOver())
            {
                m_deck = new Deck();
                ClearHand();
                a_player.ClearHand();
                return m_newGameRule.NewGame(this, a_player);   
            }
            return false;
        }
        public bool Hit(Player a_player)
        {
            if (m_deck != null && a_player.CalcScore() < m_maxScoreRule.MaxScore() && !IsGameOver())
            {
                Deal(a_player, true);
                return true;
            }
            return false;
        }
        public bool Stand()
        {
            if (m_deck != null)
            {
                foreach (Card c in GetHand())
                {
                    if (c.isHidden() == true)
                    {
                        c.Show(true);
                        foreach (CardDealtListener l in m_subscribers)
                        {
                            l.CardDealt(c);
                        }
                    }
                }
                while (m_hitRule.DoHit(this))
                {
                    Deal(this, true);
                }
                return true;
            }
            return false;
        }
        public void Deal(Player player, bool show)
        {
            Card c = m_deck.GetCard();
            c.Show(show);
            player.DealCard(c);
            foreach (CardDealtListener l in m_subscribers)
            {
                l.CardDealt(c);
            }
        }
        public bool IsDealerWinner(Player a_player)
        {
            if (m_winRule.DealerWins(a_player.CalcScore(), CalcScore(), m_maxScoreRule.MaxScore()))
            {
                return true;
            }
            return false;
        }
        public bool IsGameOver()
        {
            if (m_deck != null && m_hitRule.DoHit(this) != true)
            {
                return true;
            }
            return false;
        }
    }
}
