/*
 * Program.java
 * Date: 26 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package BlackJack;
import BlackJack.controller.PlayGame;
import BlackJack.model.Game;
import BlackJack.observer.EventSource;
import BlackJack.view.*;

/*
 * Changed quite a lot.
 * The observer pattern is added, which is taken from a example from wikipedia.
 * Link found through -> "Workshop 3 - Design Using Patterns": http://en.wikipedia.org/wiki/Observer_pattern.
 * The class PlayGame is changed into an observer.
 */
public class Program {
    
    public static void main(String[] a_args) {
        
        Game g = new Game();
        IView v = new SwedishView();
        //PlayGame ctrl = new PlayGame();                           //Not needed anymore
        
        v.DisplayStartup();                                         //Some startup instructions
        
        //Observer Pattern
        final EventSource eventSource = new EventSource();
        final PlayGame responseHandler = new PlayGame(g, v);        //Create an observer
        eventSource.addObserver(responseHandler);                   //Subscribe the observer to the event source
        Thread thread = new Thread(eventSource);                    //Starts the event thread
        thread.start();
        
        //while (ctrl.Play(g, v));                                  //Not needed anymore
        //The responsehandler class runs the PlayGame now
        
    }
    
}