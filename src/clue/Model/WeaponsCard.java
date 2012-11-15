/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.model;

import java.util.Random;

/**
 *
 * @author Yotam
 */
public class WeaponsCard {
     private Weapons weapon;
     
     public enum Weapons 
     {
        rope , candlestick, wrench , dagger ,crowbar ,gun;

        boolean active=false;
        
        public void setActive() 
        {
             active=true;
        }
        public boolean getActive() 
        {
             return active;
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals=true;
        if (obj==null)
        {
            equals=false;
        }
        else if(this.getClass()!=obj.getClass())
        {
            equals=false;

        }
        else
        {
            final WeaponsCard compare = (WeaponsCard) obj;
            if(this.weapon.name()!=compare.weapon.name())
            {
                equals=false;
            }
                
        }
        return equals;
    }
     
    public WeaponsCard(Weapons inputWeapon)
    {
        this.weapon=inputWeapon;
    }
    public WeaponsCard()
    {
        
    }
    
   public void setActiv()
    {
        this.weapon.active=true;
    }
        
    public boolean getActiv()
    {
      return this.weapon.active;
    }
    
     public WeaponsCard(int inputWeapon)
 {
     weaponCardFromInt(inputWeapon);
 }
 public void weaponCardFromInt(int inputWeapon)
    {
        switch (inputWeapon) 
        {
            case 1: this.weapon =(Weapons.candlestick);
                break;
            case 2: this.weapon =(Weapons.crowbar);
                break;
            case 3: this.weapon =(Weapons.dagger);
                break;
            case 4: this.weapon =(Weapons.gun);
                break;
            case 5: this.weapon =(Weapons.rope);
                break;
            case 6:this.weapon =(Weapons.wrench);
                break;
            default:this.weapon=null;
        }
    }
    public void selectRandomWeapon()
    {
        Random random = new Random();
        int resultOfRandom=resultOfRandom= (random.nextInt(6)+1);
        weaponCardFromInt(resultOfRandom);
    }
}
