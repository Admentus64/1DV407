/*
 * PlayGame.java
 * Date: 26 Oktober, 2014
 * Author: Tobias Ohlsson (edited by Robert Willem Hallink)
 */
package BlackJack.controller;
import BlackJack.view.IView;
import BlackJack.model.Game;
import java.util.Observable;
import java.util.Observer;

/*
 * Changed quite a lot.
 * The old public boolean method Play is now replaced by a public void update.
 * PlayGame now implements the Observer class.
 */
public class PlayGame implements Observer {
    
    Game a_game;
    IView a_view;
    
    public PlayGame(Game game, IView view) {
        a_game = game;
        a_view = view;
    }
    
    @Override
    public void update(Observable obj, Object arg) {
        
        if (arg instanceof String) {
            
            a_view.DisplayWelcomeMessage();
            
            a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
            a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
            
            if (a_game.IsGameOver())
                a_view.DisplayGameOver(a_game.IsDealerWinner());
            
            a_view.DisplayEnterInput();
            
            int input = a_view.GetInput();
            
            //Should respond whenever receiving a string input of "h" or "s", which are commands that grants cards to a player or dealer.
            //The waiting time is 2 second, can be larger.
            if (input == 'p')
                a_game.NewGame();
            
            if (input == 'h') {
                try { Thread.sleep(2000); }     //2 sec
                catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
                a_game.Hit();
            }
            
            if (input == 'a') {
                try { Thread.sleep(2000); }     //2 sec
                catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
                a_game.Stand();
            }
            
            if (input == 'q')              //Exiting the program on receiving input q
                System.exit(0);
            
        }
        
    }
    
    
    
    //The old Play method, which is currently not used anymore
    /* public boolean Play(Game a_game, IView a_view) {
        
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
        
    } */
    
}