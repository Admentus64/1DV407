using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.model
{
    class Deck
    {
        List<Card> m_cards;
        public Deck()
        {
            m_cards = new List<Card>();
            /* //random cards start */
            for (int colorIx = 0; colorIx < (int)Card.Color.Count; colorIx++)
            {
                for (int valueIx = 0; valueIx < (int)Card.Value.Count; valueIx++)
                {
                    Card c = new Card((Card.Color)colorIx, (Card.Value)valueIx);
                    AddCard(c);
                }
            }
            Shuffle();
            /* //random cards end */

            /* TEST INSTRUCTIONS
             * 1. Comment out random cards code above
             * 2. Change rule in factory
             * 3. Use test code below
             */

            /* //soft hit start
            Card c = new Card((Card.Color)0, (Card.Value)11); //player k
            AddCard(c);
            Card d = new Card((Card.Color)1, (Card.Value)0); //dealer 2
            AddCard(d);
            Card e = new Card((Card.Color)2, (Card.Value)9); //player j
            AddCard(e);
            Card f = new Card((Card.Color)3, (Card.Value)0); //dealer 2
            AddCard(f);
            Card h = new Card((Card.Color)0, (Card.Value)0); //dealer 2
            AddCard(h);
            Card g = new Card((Card.Color)1, (Card.Value)12); //dealer a -> 17 (soft)
            AddCard(g);
            Card i = new Card((Card.Color)1, (Card.Value)10); //dealer q -> 17 (hard)
            AddCard(i);
            Card j = new Card((Card.Color)1, (Card.Value)7); //dealer 9 (never used)
            AddCard(j);
            //soft hit end */

            /* //player advantage start
            Card c = new Card((Card.Color)0, (Card.Value)11); //player k
            AddCard(c);
            Card d = new Card((Card.Color)1, (Card.Value)11); //dealer k
            AddCard(d);
            Card e = new Card((Card.Color)2, (Card.Value)7); //player 9
            AddCard(e);
            Card f = new Card((Card.Color)3, (Card.Value)7); //dealer 9
            AddCard(f);
            Card h = new Card((Card.Color)1, (Card.Value)6); //dealer 8 (never used)
            AddCard(h);
            //player advantage end */          
        }
        public Card GetCard()
        {
            Card c = m_cards.First();
            m_cards.RemoveAt(0);
            return c;
        }
        public void AddCard(Card a_c)
        {
            m_cards.Add(a_c);
        }
        public IEnumerable<Card> GetCards()
        {
            return m_cards.Cast<Card>();
        }
        private void Shuffle()
        {
            Random rnd = new Random();
            for (int i = 0; i < 1017; i++)
            {
                int index = rnd.Next() % m_cards.Count;
                Card c = m_cards.ElementAt(index);
                m_cards.RemoveAt(index);
                m_cards.Add(c);
            }
        }
    }
}
