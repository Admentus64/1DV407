using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model.rules
{
    interface IWinRule
    {
        bool DealerWins(int playerScore, int dealerScore, int maxScore);
    }
}
