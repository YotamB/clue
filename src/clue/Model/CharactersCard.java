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
public class CharactersCard {
    private Characters character;
    
    
    public enum Characters 
    {
        Miss_Scarlett , Colonel_Mustard , Mrs_White , Reverend_Green 
        , Mrs_Peacock , Professor_Plum ;
        
    boolean active= false;
    
    public void setActive() 
        {
             active=true;
        }
    }
    
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
            final CharactersCard compare = (CharactersCard) obj;
            if(this.character.name()!=compare.character.name())
            {
                equals=false;
            }
                
        }
        return equals;
    }
    
 public CharactersCard(Characters inputCharacters)
    {
        this.character=inputCharacters;
    }
 
 public CharactersCard(int inputCharacters)
 {
     charactersCardFromInt(inputCharacters);
 }
 
 public void charactersCardFromInt(int inputCharacters)
    {
        switch (inputCharacters) 
        {
            case 1: this.character =(Characters.Colonel_Mustard);
                break;
            case 2: this.character =(Characters.Miss_Scarlett);
                break;
            case 3: this.character =(Characters.Mrs_Peacock);
                break;
            case 4: this.character =(Characters.Mrs_White);
                break;
            case 5: this.character =(Characters.Professor_Plum);
                break;
            case 6:this.character =(Characters.Reverend_Green);
            break;
                default: this.character=null;
        }
    }
 public CharactersCard()
 {
     
 }

 public void setActiv()
    {
        this.character.active=true;
    }
        
    public boolean getActiv()
    {
      return this.character.active;
    }

  public void selectRandomCharacter()
    {
        Random random = new Random();
        int resultOfRandom= (random.nextInt(6)+1);
        charactersCardFromInt(resultOfRandom);
    }
    
  
}
