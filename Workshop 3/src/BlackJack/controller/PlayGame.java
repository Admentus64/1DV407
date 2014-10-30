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
 * The
 */
public class PlayGame implements Observer {
    
    Game a_game;
    IView a_view;
    
    public PlayGame(Game game, IView view) {
        a_game = game;
        a_view = view;
    }
    
    
    
    public enum gameAction {
        play,
        hit,
        stand,
        quit,
        invalid
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
            gameAction input = a_view.GetInput();
            
            //Should respond whenever receiving a gameAction input of the current View Language class, which are commands that grants cards to a player or dealer.
            if (input == gameAction.play) {
                sleep(2000);
                a_game.NewGame();
            }
            
            if (input == gameAction.hit) {
                sleep(2000);
                a_game.Hit();
            }
            
            if (input == gameAction.stand) {
                sleep(2000);
                a_game.Stand();
            }
            
            if (input == gameAction.quit)              //Exiting the program on receiving input q
                System.exit(0);
            
            if (input == gameAction.invalid) {
                a_view.DisplayInvalidInput();
                sleep(3000);
            }
            
        }
        
    }
    
    
    
    //New private method for waiting timer. The waiting time should be 2 or 3 seconds for now, can be larger.
    private void sleep(int timer) {
        
        try { Thread.sleep(timer); }         //2 sec
        catch(InterruptedException e) { Thread.currentThread().interrupt(); }
        
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