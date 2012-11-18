/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.Controler;

/**
 *
 * @author Yotam
 */
public class GameStatusListener implements GameStatusUpdate {

    @Override
    public void statusUpdate() {
        System.out.println("Stsatus update.");
    }
    
    
}
