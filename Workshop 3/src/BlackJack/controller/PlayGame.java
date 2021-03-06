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
    
    
    
    public enum command {
        play,
        hit,
        stand,
        quit,
        invalid
    }
    
    
    
    //Part of the observer, when input is seen, run the game.
    //Almost untouched example from wikipedia, replaced the print out with the method Play.
    //Link found through -> "Workshop 3 - Design Using Patterns": http://en.wikipedia.org/wiki/Observer_pattern.
    @Override
    public void update(Observable obj, Object arg) {
        
        if (arg instanceof String)
            Play();
        
    }
    
    
    
    //The new Play method, but no longer a boolean method.
    public void Play() {
        
        a_view.DisplayWelcomeMessage();
        
        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
        
        if (a_game.IsGameOver())
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        
        a_view.DisplayEnterInput();
        command input = a_view.GetInput();
        
        switch (input) {                //Should respond whenever receiving a command input of the current View Language class, which are commands that grants cards to a player or dealer.
            case play:
                sleep(2000);
                a_game.NewGame();
                break;
            case hit:
                sleep(2000);
                a_game.Hit();
                break;
            case stand:
                sleep(2000);
                a_game.Stand();
                break;
            case quit:                  //Exiting the program on receiving input q
                System.exit(0);
                break;
            case invalid:
                a_view.DisplayInvalidInput();
                sleep(3000);
                break;
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