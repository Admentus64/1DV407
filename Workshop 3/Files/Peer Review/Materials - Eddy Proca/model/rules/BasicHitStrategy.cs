using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model.rules
{
    class BasicHitStrategy : IHitStrategy
    {
        protected const int g_hitLimit = 17; // this may look like duplicate code but the limit may change depending on different styles of the game
        public bool DoHit(model.Player a_dealer)
        {
            return a_dealer.CalcScore() < g_hitLimit;
        }
    }
}
