/*
 * PlayGame.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.controller;
import BlackJack.view.IView;
import BlackJack.model.Game;

/*
 * Changed quite a lot.
 * The old public boolean method Play still remains active, but is not used anymore.
 * Instead the method Play is now a void, which is called by the observer call by input.
 */
public class PlayGame {
    
    //The old Play method, which is currently not used anymore
    public boolean Play(Game a_game, IView a_view) {
        
        a_view.DisplayWelcomeMessage();
        
        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
        
        if (a_game.IsGameOver())
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        
        int input = a_view.GetInput();
        
        if (input == 'p')
            a_game.NewGame();
        else if (input == 'h')
            a_game.Hit();
        else if (input == 's')
            a_game.Stand();
                
        return input != 'q';
        
    }
    
    
    
    //The new Play method, which is used instead through the observer
    public void Play(Game a_game, IView a_view, String input) {
        
        a_view.DisplayWelcomeMessage();
        
        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
        
        if (a_game.IsGameOver())
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        
        a_view.DisplayEnterInput();
        
        //Should respond whenever receiving a string input of "h" or "s", which are commands that grants cards to a player or dealer.
        //The waiting time is 1 second, can be larger.
        if (input.equals("p"))
                a_game.NewGame();
        
        if (input.equals("h")) {
            a_game.Hit();
            try { Thread.sleep(1000); }     //1 sec
            catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
            //System.out.println("Testing delay");  //Uncomment this code to test delay.
        }
        
        if (input.equals("s")) {
            a_game.Stand();
            try { Thread.sleep(1000); }     //1 sec
            catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
            //System.out.println("Testing delay");  //Uncomment this code to test delay.
        }
        
        if (input.equals("q"))              //Exiting the program on receiving input q
            System.exit(0);
        
    }
    
}