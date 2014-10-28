using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace BlackJack.controller
{
    class PlayGame : model.CardDealtListener
    {
        private view.IView m_view;
        public enum gameAction
        {
            play,
            hit,
            stand,
            quit,
            invalid
        }
        public PlayGame(view.IView a_view)
        {
            m_view = a_view;
            m_view.DisplayWelcomeMessage();
        }
        public void CardDealt(model.Card m_card) 
        {
            m_view.DisplayHeadline();
            m_view.DisplayCard(m_card);
            Thread.Sleep(1000); //delay in ms
        }
        public bool Play(model.Game a_game)
        {            
            m_view.DisplayWelcomeMessage();
            if (a_game.GetPlayerScore() != 0)
            {
                m_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
                m_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
            }
            if (a_game.IsGameOver())
            {
                m_view.DisplayGameOver(a_game.IsDealerWinner());
            }
            gameAction input = m_view.GetInput();
            if (input == gameAction.play)
            {
                m_view.DisplayWelcomeMessage();
                var test = a_game.NewGame();
            }
            else if (input == gameAction.hit)
            {
                a_game.Hit();
            }
            else if (input == gameAction.stand)
            {
                a_game.Stand();
            }
            return input != gameAction.quit;
        }
    }
}
