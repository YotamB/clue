/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.controler;



import clue.Utilitys;
import clue.controler.players.Player;
import clue.model.CardDeck;
import clue.model.CharactersCard;
import clue.model.Envelope;
import clue.model.RoomCard;
import clue.model.WeaponsCard;
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
            if (observer.askUserIfWantToAccuse()==_YES)
            {
                userGuessResult=makeAnAccusation();
                if(userGuessResult=_WRONGGUESS)
                {
                    //@TODO need to be removed from game.
                }
                else
                {
                    observer.gameWon(currentPlayer);
                }
            }
            else
            {
                int diceResult= currentPlayer.RoolDice();
                boolean diration =observer.logicPlayerNeedToMove(
                        currentPlayer ,diceResult);
                currentPlayer.updateUserLocation(diceResult, diration);
                observer.updateViewOnPlayerMove(currentPlayer.getMyPlayerNumber());
                if(currentPlayer.getUserLocation().getRoomNum()!=0)//Not Hallway
                {
                    String room=currentPlayer.getUserLocation().getName();
                    makeAGuess(room);
                }
            }
        }
        return turnResult;
    }
    
    private void makeAGuess(String location)
    {
//      boolean result;
//      RoomCard roomGuess = new RoomCard(
//                RoomCard.Rooms.valueOf(location));
        CharactersCard characterGuess= observer.logicIsAskingPlayerWhoToAccuse();
        WeaponsCard weaponGuess = observer.logicIsAskingWeaponToAccuse();
//      Envelope guess = new Envelope(weaponGuess, characterGuess, roomGuess);
        runGuessTest(characterGuess, weaponGuess);
        
    }
    
    private void runGuessTest(CharactersCard characterGuess,WeaponsCard weaponGuess )
    {
        for (int i = 0 ; i< listOfPlayers.size() ;i++)
        {
            Player currentPlayer = currentTurn.next();
            if(currentTurn!=currentPlayer)
            {
                observer.askIfHeHaveThisCards(characterGuess, weaponGuess);
            }
            //@TODO think how to tell the deffrance weapone and charecter card
        }
    }
            
    
    private boolean makeAnAccusation()
    {
        boolean result;
        RoomCard roomGuess = observer.logicIsAskingPlayerForRoomOfMerder();
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
                listOfPlayers.get(j).getNewRoomCard(
                    CardDeck.getRoomCard());
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
