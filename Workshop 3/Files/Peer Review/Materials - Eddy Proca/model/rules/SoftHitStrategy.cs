using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model.rules
{
    class SoftHitStrategy : IHitStrategy
    {
        protected const int g_hitLimit = 17; // this may look like duplicate code but the limit may change depending on different styles of the game
        public bool DoHit(Player a_dealer)
        {
            var score = a_dealer.CalcScore();
            return ((score < g_hitLimit) || ((score == g_hitLimit) && a_dealer.SoftHand())); //if under limit or if on limit with soft hand
        }
    }
}
