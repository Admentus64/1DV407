using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack.view
{
    class SimpleView : IView
    {
        private static string englishPlayAction = "p";
        private static string englishHitAction = "h";
        private static string englishStandAction = "s";
        private static string englishQuitAction = "q";
        public void DisplayHeadline()
        {
            Console.Clear();
            Console.WriteLine("Black Jack");
            Console.WriteLine();
        }
        public void DisplayWelcomeMessage()
        {
            DisplayHeadline();
            Console.WriteLine("Type '{0}' to play, '{1}' to Hit, '{2}' to Stand or '{3}' to Quit\n", englishPlayAction.ToString(), englishHitAction, englishStandAction, englishQuitAction);
        }
        public controller.PlayGame.gameAction GetInput()
        {
            var input = System.Console.ReadLine();
            if (input == englishPlayAction)
            {
                return controller.PlayGame.gameAction.play;
            }
            else if (input == englishHitAction)
            {
                return controller.PlayGame.gameAction.hit;
            }
            else if (input == englishStandAction)
            {
                return controller.PlayGame.gameAction.stand;
            }
            else if (input == englishQuitAction)
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
            Console.WriteLine("{0} of {1}", a_card.GetValue(), a_card.GetColor());
        }
        public void DisplayPlayerHand(IEnumerable<model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }
        public void DisplayDealerHand(IEnumerable<model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }
        private void DisplayHand(String a_name, IEnumerable<model.Card> a_hand, int a_score)
        {
            System.Console.WriteLine("{0} Has: ", a_name);
            foreach (model.Card c in a_hand)
            {
                DisplayCard(c);
            }
            System.Console.WriteLine("Score: {0}", a_score);
            System.Console.WriteLine("");
        }
        public void DisplayGameOver(bool a_dealerIsWinner)
        {
            System.Console.Write("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.Console.WriteLine("Dealer Won!");
            }
            else
            {
                System.Console.WriteLine("You Won!");
            }
        }
    }
}
