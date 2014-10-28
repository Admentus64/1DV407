using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model.rules
{
    class DealerAdvantageWinRule : IWinRule
    {
        public bool DealerWins(int playerScore, int dealerScore, int maxScore)
        {
            if (playerScore > maxScore)
            {
                return true;
            }
            else if (dealerScore > maxScore)
            {
                return false;
            }
            return dealerScore >= playerScore; //dealer wins on tie
        }
    }
}
