/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.controler;

import clue.Controler;
import clue.Model.CardDeck;
import clue.Model.CharactersCard;
import clue.Model.Envelope;
import clue.Model.RoomCard;
import clue.Model.WeaponsCard;
import clue.Utilitys;
import clue.controler.logic.players.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Yotam
 */
public class GameLogic implements Utilitys   { // @TESTING event
   CardDeck deck; 
   Envelope envelope;
   private List<Player> listOfPlayers= 
            new ArrayList<Player>();
   Iterator<Player> currentTurn;
   Controler observer;
   
    public void init(Controler controler)
    {
        observer=controler;
        deck = new CardDeck();
        WeaponsCard weapone=new WeaponsCard();
        weapone.selectRandomWeapon();
        CharactersCard character = new CharactersCard();
        character.selectRandomCharacter();
        RoomCard room = new RoomCard();
        envelope = new Envelope(weapone, character , room);
        initPlayers();
        currentTurn= listOfPlayers.iterator();
    }
  
    public int playRound()
    {
        int turnResult=_RUNNING;
        boolean userGuessResult=_WRONGRESULT;
        for (int i = 0 ; i< listOfPlayers.size() &&
                userGuessResult==_WRONGRESULT ;i++)
        {
            Player currentPlayer = currentTurn.next();
            int diceResult= currentPlayer.RoolDice();
            boolean diration =observer.logicPlayerNeedToMove(
                    currentPlayer ,diceResult);
            currentPlayer.updateUserLocation(diceResult, diration);
            observer.updateViewOnPlayerMove(currentPlayer.getMyPlayerNumber());
            if(currentPlayer.getUserLocation().getRoomNum()!=0)//Not Hallway
            {
                String room=currentPlayer.getUserLocation().getName();
                userGuessResult=makeAnAccusation(room);
                if (userGuessResult==_RIGHTGUESS)//@TODO make it nicer with event to handel result!!
                {
                    observer.gameWon(currentPlayer);
                }
            }
        }
        return turnResult;
    }
    
    private boolean makeAnAccusation(String location)
    {
        boolean result;
         RoomCard roomGuess = new RoomCard(
                RoomCard.Rooms.valueOf(location));
        CharactersCard characterGuess= observer.logicIsAskingPlayerWhoToAccuse();
        WeaponsCard weaponGuess = observer.logicIsAskingWeaponToAccuse();
        Envelope guess = new Envelope(weaponGuess, characterGuess, roomGuess);
        result = envelope.equals(guess);
        return result;
        
    }
    
    private void initPlayers()
    {
        int numberOfPlayers= observer.logicGetNumberOfPlayersReqest();
        for (int i=0 ; i< numberOfPlayers ; i++)
        {
            listOfPlayers.add(observer.logicCreatePlayerReqest());
        }
        dealCards(numberOfPlayers);
    }
    
    private void dealCards(int numberOfPlayers)
    {
        
        for(int i = 6 ; i > 0 ;)
        {
            for (int j=0 ; j<numberOfPlayers; j++, i--)
            {
                listOfPlayers.get(j).getNewWeaponeCard(
                    CardDeck.getWeaponCard());
                listOfPlayers.get(j).getNewCharacterCard(
                    CardDeck.getCharecterCard());
            }
        }   
    }
        
//    private void printPlayers() //For @DEBUG only
//    {
//        for (int i=0 ; i< listOfPlayers.size() ; i++)
//        {
//            System.out.println(listOfPlayers.get(i).getName());
//        }
//    }

    
    
}
