using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model
{
    interface CardDealtListener
    {
        void CardDealt(Card card);
    }
}
