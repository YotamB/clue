/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.controler.players;

/**
 *
 * @author Yotam
 */
public class Human extends Player{
    private String name= null;
    
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    
}
