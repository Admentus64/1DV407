/*
 * ResponseHandler.java
 * Date: 26 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack.observer;
import BlackJack.controller.PlayGame;
import BlackJack.model.Game;
import BlackJack.view.IView;
import java.util.Observable;
import java.util.Observer;

/*
 * Newly added class.
 * Part of the observer requirement.
 * This class keeps track of input and activates a new command round through the PlayGame class.
 * Edited example from wikipedia.
 * Link found through -> "Workshop 3 - Design Using Patterns": http://en.wikipedia.org/wiki/Observer_pattern.
 */
public class ResponseHandler implements Observer {
    
    private String resp;
    private final Game a_game;
    private final IView a_view;
    private final PlayGame a_play;
    
    
    
    public ResponseHandler(Game game, IView view, PlayGame play) {
        
        a_game = game;
        a_view = view;
        a_play = play;
        
    }
    
    
    
    @Override
    public void update(Observable obj, Object arg) {
        
        if (arg instanceof String) {
            
            resp = (String ) arg;
            a_play.Play(a_game, a_view, resp);
            
        }
        
    }
    
    //In order to improve keyboard handling, uncomment this method and comment away the previous method.
    //Directing the code through the class PlayGame requires input twice before advancing.
    /* @Override
    public void update(Observable obj, Object arg) {
        
        if (arg instanceof String) {
            
            a_view.DisplayWelcomeMessage();
            
            a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
            a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
            
            if (a_game.IsGameOver())
                a_view.DisplayGameOver(a_game.IsDealerWinner());
            
            a_view.DisplayEnterInput();
            
            resp = (String) arg;
            //System.out.println("\nReceived Response: " + resp );              //Can use this section to test is a reponse came through
            
            if (resp.equals("p"))
                a_game.NewGame();
            if (resp.equals("h")) {
                a_game.Hit();
                try { Thread.sleep(1000); }
                catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
            }
            if (resp.equals("s")) {
                a_game.Stand();
                try { Thread.sleep(1000); }
                catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
            }
            if (resp.equals("q"))
                System.exit(0);
            
        }
        
    } */
    
}