/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.controler;

import java.util.Random;

/**
 *
 * @author Yotam
 */
public class Dice {
   
   public int RoolDice()
   {
        int resultOfDiceRoll=0;
        Random random = new Random();
        resultOfDiceRoll= (random.nextInt(6)+1);
        return resultOfDiceRoll;
   }
    
}
