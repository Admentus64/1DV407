/*
 * SwedishView.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.view;

/*
 * Mostly left untouched.
 * Added three new display messages and an extra line print.
 * Not a change however, but GetInput is not used anymore.
 * Code regarding hidden cards is adjusted (see Card.java).
 * Is now extended by AView which implements IView.
 */
public class SwedishView extends AView {
    
    //Two new display methods, for better user feedback
    @Override   public void DisplayStartup()        { System.out.print("Mata in en bokstav och tryck enter för att börja: "); }
    @Override   public void DisplayEnterInput()     { System.out.print("Ange inmatning: "); }
    @Override   public void DisplayInvalidInput()   { System.out.println("Okänt inmatning, försök igen gärna."); }
    @Override   public void DisplayLastInput()      { System.out.print("Senaste inmatning: "); }
    
    @Override
    public void DisplayWelcomeMessage() {
        
        for(int i=0; i<50; i++)
            System.out.print("\n");
        
        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
        
    }
    
    @Override
    public void DisplayCard(BlackJack.model.Card a_card) {
        
        if (a_card.IsHidden())
            System.out.println("Dolt Kort");
        else {
            String colors[] = { "Hjärter", "Spader", "Ruter", "Klöver" };
            String values[] = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
        
    }
    
    @Override
    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Spelare", a_hand, a_score);
    }
    
    @Override
    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Croupier", a_hand, a_score);
    }
    
    @Override
    public void DisplayGameOver(boolean a_dealerIsWinner) {
        
        System.out.println("Slut: ");
        if (a_dealerIsWinner)
            System.out.println("Croupiern Vann!");
        else
            System.out.println("Du vann!");
        System.out.println();       //Added, for a bit more display value
        
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        
        System.out.println(a_name + " Har: " + a_score);
        for (BlackJack.model.Card c : a_hand)
            DisplayCard(c);
        System.out.println("Poäng: " + a_score);
        System.out.println("");
        
    }

}