/*
 * IView.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.view;
import BlackJack.controller.PlayGame.command;

/*
 * Mostly left untouched.
 * Added extra display messages.
 */
public interface IView {
    
    void DisplayEnterInput();       //New added message
    void DisplayInvalidInput();     //New added message
    void DisplayLastInput();        //New added message
    void DisplayWelcomeMessage();
    command GetInput();
    void DisplayCard(BlackJack.model.Card a_card);
    void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
    void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
    void DisplayGameOver(boolean a_dealerIsWinner);
    
}