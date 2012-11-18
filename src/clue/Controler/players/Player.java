/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.Controler.players;


import clue.Controler.Dice;
import clue.Model.CharactersCard;
import clue.Model.RoomsStatus;
import clue.Model.WeaponsCard;
import java.util.ArrayList;
import java.util.List;
import clue.Model.RoomCard;


/**
 *
 * @author Yotam
 */
public abstract class Player {
    
    private int myPlayerNumber=1; //@TODO set players numbers

    public int getMyPlayerNumber() {
        return myPlayerNumber;
    }

    public void setMyPlayerNumber(int myPlayerNumber) {
        this.myPlayerNumber = myPlayerNumber;
    }
    
    private RoomsStatus theRoomIAmIn = RoomsStatus.valueOf("KITCHEN");
    private List<CharactersCard> playerCharacterCards= 
            new ArrayList<CharactersCard>();
    private List<WeaponsCard> playerWeaponsCards= 
            new ArrayList<WeaponsCard>();
    private List<RoomCard> playerRoomCards= 
            new ArrayList<RoomCard>();
    
    public void getNewWeaponeCard(WeaponsCard newWeaponsCard)
    {
        playerWeaponsCards.add(newWeaponsCard);
    }
    
    public void getNewCharacterCard(CharactersCard newCharacterCard)
    {
        playerCharacterCards.add(newCharacterCard);
    }
    
    public void getNewRoomCard(RoomCard newRoomCard)
    {
        playerRoomCards.add(newRoomCard);
    }
    
    public int RoolDice()
    {
        Dice dice=new Dice();
        return dice.RoolDice();
    }
    public RoomsStatus getUserLocation()
    {
        return theRoomIAmIn;
    }
    public void updateUserLocation(int stepsToMove , boolean direction)
    {
        int currentRoom =theRoomIAmIn.getRoomNum();
        if(direction==false)
        {
            stepsToMove*=-1;
        }
        theRoomIAmIn=theRoomIAmIn.setByRoomNum(currentRoom+stepsToMove);
    }
    public void setName(String name){};
    public String getName(){return null;};
    
            
}
