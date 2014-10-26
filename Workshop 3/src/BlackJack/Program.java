/*
 * Program.java
 * Date: 26 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack;
import BlackJack.controller.PlayGame;
import BlackJack.model.Game;
import BlackJack.observer.EventSource;
import BlackJack.observer.ResponseHandler;
import BlackJack.view.*;

/*
 * Changed quite a lot.
 * The observer pattern is added, which is taken from a example from wikipedia.
 * Link found through -> "Workshop 3 - Design Using Patterns": http://en.wikipedia.org/wiki/Observer_pattern.
 * The class PlayGame is no longer controller by this main class, but instead directed by input from the observer (ResponseHandler).
 */
public class Program {
    
    public static void main(String[] a_args) {
        
        //This section is required however
        Game g = new Game();
        IView v = new SwedishView();
        PlayGame ctrl = new PlayGame();
        
        v.DisplayStartup();                     //Some startup instructions
        
        //Observer Pattern
        final EventSource eventSource = new EventSource();
        final ResponseHandler responseHandler = new ResponseHandler(g, v, ctrl);
        eventSource.addObserver(responseHandler);
        Thread thread = new Thread(eventSource);
        thread.start();
        
        //while (ctrl.Play(g, v));              //Not needed anymore
        //The responsehandler class runs the PlayGame now
        
    }
    
}