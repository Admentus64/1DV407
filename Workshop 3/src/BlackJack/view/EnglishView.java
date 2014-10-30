/*
 * EnglishView.java
 * Date: 26 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.view;

/*
 * Newly added class.
 * A full english implementation of the IView interface, SimpleView was just not complete enough.
 * Most sentices from the SimpleView implementation are reused within this implementation.
 * Is now extended by AView which implements IView.
 */
public class EnglishView extends AView  {
    
    //Two new display methods, for better user feedback.
    @Override   public void DisplayEnterInput()     { System.out.print("Enter input: "); }
    @Override   public void DisplayInvalidInput()   { System.out.println("Unknown input, try again please."); }
    @Override   public void DisplayLastInput()      { System.out.print("Last input: "); }
    
    @Override
    public void DisplayWelcomeMessage() {
        
        for (int i=0; i<50; i++)
            System.out.print("\n");
        
        System.out.println("Hello Black Jack World");
        System.out.println("----------------------");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        
    }
    
    @Override
    public void DisplayCard(BlackJack.model.Card a_card) {
        
        if (a_card.IsHidden())
            System.out.println("Hidden Card");
        else {
            String colors[] = { "Hearts", "Spades", "Diamonds", "Clubs" };
            String values[] = { "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "knight", "queen", "king", "ace" };
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
        
    }
    
    @Override
    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score);
    }
    
    @Override
    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score);
    }
    
    @Override
    public void DisplayGameOver(boolean a_dealerIsWinner) {
        
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)
            System.out.println("Dealer Won!");
        else System.out.println("You Won!");
        System.out.println();       //Added, for a bit more display value
        
    }
    
    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        
        System.out.println(a_name + " Has: ");
        for (BlackJack.model.Card c : a_hand)
            DisplayCard(c);
        System.out.println("Score: " + a_score);
        System.out.println("");
        
    }
    
}