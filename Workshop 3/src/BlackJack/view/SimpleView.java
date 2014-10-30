/*
 * SimpleView.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.view;

/*
 * Mostly left untouched.
 * Added three new display messages and an extra line print.
 * Not a change however, but GetInput is not used anymore.
 * Is now extended by AView which implements IView.
 */
public class SimpleView extends AView  {
    
    //Two new display methods, for better user feedback.
    @Override   public void DisplayStartup()        { System.out.print("Type in a letter and press enter to start: "); }
    @Override   public void DisplayEnterInput()     { System.out.print("Enter input: "); }
    @Override   public void DisplayInvalidInput()   { System.out.println("Unknown input, try again please."); }
    @Override   public void DisplayLastInput()      { System.out.print("Last input: "); }
    
    @Override
    public void DisplayWelcomeMessage() {
        
        for (int i=0; i<50; i++)
            System.out.print("\n");
        
        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        
    }
    
    @Override
    public void DisplayCard(BlackJack.model.Card a_card) {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }
    
    @Override
    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score);
    }
    
    @Override
    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score);
    }
    
    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        
        System.out.println(a_name + " Has: ");
        for (BlackJack.model.Card c : a_hand)
            DisplayCard(c);
        System.out.println("Score: " + a_score);
        System.out.println("");
        
    }
    
    @Override
    public void DisplayGameOver(boolean a_dealerIsWinner) {
        
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)
            System.out.println("Dealer Won!");
        else System.out.println("You Won!");
        System.out.println();       //Added, for a bit more display value
        
    }
    
}