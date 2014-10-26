/*
 * IView.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.view;

/*
 * Mostly left untouched.
 * Added extra display messages.
 */
public interface IView {
    
    void DisplayStartup();          //New added message
    void DisplayEnterInput();       //New added message
    void DisplayWelcomeMessage();
    int GetInput();
    void DisplayCard(BlackJack.model.Card a_card);
    void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
    void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
    void DisplayGameOver(boolean a_dealerIsWinner);
    
}