/*
 * PlayGame.java
 * Date: 23 September, 2014
 * Author: Tobias Ohlsson (Edited by Robert Willem Hallink)
 */
package PlayingDice.Controller;

/*
 * More Info Here!
 */
public class PlayGame implements PlayingDice.Model.DieRolledListener {     //Class PlayGame starts
    
    private final PlayingDice.View.Console m_view;
    
    
    
    /* Others */
    public PlayGame(PlayingDice.View.Console a_view) {
        m_view = a_view;
    }
    
    public void Play(PlayingDice.Model.DiceGame a_game, PlayingDice.View.Console a_view) {    //Method Play starts
        
        m_view.PresentWelcomeMessage();
        m_view.PresentInstructions();
        
        while (m_view.WantsToQuit() != true) {
            m_view.PresentResult(a_game.Play());
            m_view.PresentInstructions();
        }
    
    }   //Method Play ends
    
    @Override
    public void DieRolled(int a_value) {    //Method DieRolled starts
        m_view.PresentDieValue(a_value);
    }   //Method DieRolled ends

}   //Class PlayGame ends