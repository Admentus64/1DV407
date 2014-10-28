using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.view
{
    class SwedishView : IView 
    {
        private static string swedishPlayAction = "b";
        private static string swedishHitAction = "k";
        private static string swedishStandAction = "s";
        private static string swedishQuitAction = "a";
        public void DisplayHeadline() 
        {
            Console.Clear();
            Console.WriteLine("Black Jack");
            Console.WriteLine();            
        }
        public void DisplayWelcomeMessage()
        {
            DisplayHeadline();
            Console.WriteLine("Skriv '{0}' för att börja, '{1}' för nytt kort, '{2}' för att stanna '{3}' för att avsluta\n", swedishPlayAction, swedishHitAction, swedishStandAction, swedishQuitAction);
        }
        public BlackJack.controller.PlayGame.gameAction GetInput()
        {
            var input = System.Console.ReadLine();
            if (input == swedishPlayAction)
            {
                return controller.PlayGame.gameAction.play;
            }
            else if (input == swedishHitAction)
            {
                return controller.PlayGame.gameAction.hit;
            }
            else if (input == swedishStandAction)
            {
                return controller.PlayGame.gameAction.stand;
            }
            else if (input == swedishQuitAction)
            {
                return controller.PlayGame.gameAction.quit;
            }
            else
            {
                return controller.PlayGame.gameAction.invalid;
            }
        }
        public void DisplayCard(model.Card a_card)
        {
            if (a_card.GetColor() == model.Card.Color.Hidden)
            {
                System.Console.WriteLine("Dolt Kort");
            }
            else
            {
                String[] colors = new String[(int)model.Card.Color.Count]
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String[] values = new String[(int)model.Card.Value.Count] 
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.Console.WriteLine("{0} {1}", colors[(int)a_card.GetColor()], values[(int)a_card.GetValue()]);
            }
        }
        public void DisplayPlayerHand(IEnumerable<model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(IEnumerable<model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(bool a_dealerIsWinner)
        {
            System.Console.Write("Slut: ");
            if (a_dealerIsWinner)
            {
                System.Console.WriteLine("Croupiern Vann!");
            }
            else
            {
                System.Console.WriteLine("Du vann!");
            }
        }
        private void DisplayHand(String a_name, IEnumerable<model.Card> a_hand, int a_score)
        {
            System.Console.WriteLine("{0} Har: ", a_name);
            foreach (model.Card c in a_hand)
            {
                DisplayCard(c);
            }
            System.Console.WriteLine("Poäng: {0}", a_score);
            System.Console.WriteLine("");
        }
    }
}
