using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model.rules
{
    class BlackJackMaxScoreRule : IMaxScoreRule
    {
        private int g_maxScore = 21;
        public int MaxScore() 
        {
            return g_maxScore;
        }
    }
}
