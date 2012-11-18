/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.Controler;



import clue.Model.CardDeck;
import clue.Model.CharactersCard;
import clue.Model.Envelope;
import clue.Model.RoomCard;
import clue.Model.WeaponsCard;
import clue.Utilitys;
import clue.Controler.players.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Yotam
 */
public class GameLogic implements Utilitys   { // @TESTING event
   CardDeck deck; 
   Envelope theTruth;
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
        weapone.setActiv();
        CharactersCard character = new CharactersCard();
        character.selectRandomCharacter();
        character.setActiv();
        RoomCard room = new RoomCard();
        
        room.getActiv();
        theTruth = new Envelope(weapone, character , room);
        initPlayers();
        currentTurn= listOfPlayers.iterator();
    }
  
    public int playRound()
    {
        currentTurn= listOfPlayers.iterator();
        int turnResult=_RUNNING;
        boolean userGuessResult=_WRONGRESULT;
        for (int i = 0 ; i< listOfPlayers.size() &&
                userGuessResult==_WRONGRESULT ;i++)
        {
            Player currentPlayer = currentTurn.next();
            if (observer.askUserIfWantToAccuse()==_YES)
            {
                userGuessResult=makeAnAccusation();
                if(userGuessResult==_WRONGGUESS)
                {
                    //@TODO need to get massage that was removed from game.
                    listOfPlayers.remove(currentPlayer);
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
                int currentRoomNum =currentPlayer.getUserLocation().getRoomNum();
                if(currentRoomNum%2 == 1 )//Not Hallway
                {
                    makeAGuess(currentRoomNum);
                }
            }
        }
        return turnResult;
    }
    
    private void makeAGuess(int location)
    {
//      boolean result;
        RoomCard roomGuess = new RoomCard(location);
        CharactersCard characterGuess= observer.logicIsAskingPlayerWhoToAccuse();
        WeaponsCard weaponGuess = observer.logicIsAskingWeaponToAccuse();
//      Envelope guess = new Envelope(weaponGuess, characterGuess, roomGuess);
        runGuessTest( roomGuess ,characterGuess, weaponGuess);
        
    }
    
    private void runGuessTest(RoomCard roomGuess , CharactersCard characterGuess,WeaponsCard weaponGuess )
    {
        //@TODO make the loop better order of players.
        Iterator<Player> showCards;
        showCards= listOfPlayers.iterator(); 
        for (int i =0 ; i < listOfPlayers.size() ; i++)
        {
            if(showCards != currentTurn)
            {
                observer.askIfHeHaveThisCards(roomGuess, characterGuess, weaponGuess);
            }
            //@TODO think how to tell the deffrance weapone and charecter card
        showCards.next();
        }
    }
            
    
    private boolean makeAnAccusation()
    {
        boolean result;
        RoomCard roomGuess = observer.logicIsAskingPlayerForRoomOfMerder();
        CharactersCard characterGuess= observer.logicIsAskingPlayerWhoToAccuse();
        WeaponsCard weaponGuess = observer.logicIsAskingWeaponToAccuse();
        Envelope guess = new Envelope(weaponGuess, characterGuess, roomGuess);
        result = theTruth.equals(guess);
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
        //One less card for Envelope
        for(int i = 5 ; i > 0 ;)
        {
            for (int j=0 ; j<numberOfPlayers && i != 0; j++, i--)
            {
                listOfPlayers.get(j).getNewWeaponeCard(
                    CardDeck.getWeaponCard());
                listOfPlayers.get(j).getNewCharacterCard(
                    CardDeck.getCharecterCard());
            }
        }           
        for(int i = 8 ; i > 0 ;)
        {
            for (int j=0 ; j<numberOfPlayers && i != 0; j++, i--)
            {
                listOfPlayers.get(j).getNewRoomCard(
                    CardDeck.getRoomCard());
            }
        }   
    }
 
    
    
}
