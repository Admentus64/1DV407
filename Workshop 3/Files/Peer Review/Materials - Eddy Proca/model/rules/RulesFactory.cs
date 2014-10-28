using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model.rules
{
    class RulesFactory
    {
        public IHitStrategy GetHitRule()
        {
            return new SoftHitStrategy();
            //return new BasicHitStrategy();
        }
        public INewGameStrategy GetNewGameRule()
        {
            return new AmericanNewGameStrategy();
            //return new InternationalNewGameStrategy();
        }
        public IWinRule GetWinRule()
        {
            return new DealerAdvantageWinRule();
            //return new PlayerAdvantageWinRule();
        }
        public IMaxScoreRule getMaxScoreRule() 
        {
            return new BlackJackMaxScoreRule();
        }
    }
}
