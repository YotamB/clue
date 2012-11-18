/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.Controler;

import clue.Model.CharactersCard;
import clue.Model.RoomCard;
import clue.Model.WeaponsCard;
import clue.Utilitys;
import clue.Controler.players.Computer;
import clue.Controler.players.Human;
import clue.Controler.players.Player;
import clue.view.View;

/**
 *
 * @author Yotam
 */
public class Controler implements Utilitys{
    
    View view = new View();
    GameLogic logic = new GameLogic();
    static int gameOnGoing;
    public void init()
    {
        logic.init(this);
        //@TODO add logic of mylti run whan stop....
        gameOnGoing=_RUNNING;
        while(gameOnGoing==_RUNNING)
        {
            gameOnGoing=logic.playRound();
        }
//        view.printBoard();
    }

    void askIfHeHaveThisCards(RoomCard roomGuess ,CharactersCard characterGuess,WeaponsCard weaponGuess)
    {
        view.askUserIfHaveThisCards(roomGuess.getRoomName() ,
                characterGuess.getCharecterName(), weaponGuess.getWaeponName());
    }
    
    public void gameWon(Player currentPlayer)
    {
        
    }
    public Player logicCreatePlayerReqest()
    {
        Player newPlayer;
        if(view.askUserIfHumen()==true)
        {
            newPlayer= new Human();
            newPlayer.setName(view.askUserName());
        }
        else
        {
            newPlayer = new Computer();
        }
        return newPlayer;
    }
    
    public int logicGetNumberOfPlayersReqest()
    {
        return view.askUserForNumberOfPlayers();
    }
    
    public boolean logicPlayerNeedToMove(Player currentPlayer ,
            int diceResult)
    {
        boolean diration = _RIGHT;
        if (currentPlayer.getClass()== Human.class)
        {
           diration = view.askUserHowToMove();
        }
        return diration;
    }
    public void updateViewOnPlayerMove(int playerNumber)
    {
        
        view.updatePownLocationOnBoard(playerNumber);
    }
    
    public boolean askUserIfWantToAccuse()
    {
        boolean toAccuse=_NO;
//        toAccuse = view.askUserIfHeWantToAccuse(); //@TODO remove comment and implement!
        return toAccuse;
    }
    public CharactersCard logicIsAskingPlayerWhoToAccuse()
    {
        int userGuess=view.askPlayerWhoToAccuse();
        CharactersCard charactersGuess=new CharactersCard(userGuess);
        return charactersGuess;
    }
    
    public WeaponsCard logicIsAskingWeaponToAccuse()
    {
        int userGuess = view.askWeaponToAccuse();
        WeaponsCard weaponGuess=new WeaponsCard(userGuess);
        return weaponGuess;
    }
    
    public RoomCard logicIsAskingPlayerForRoomOfMerder()
            {
        int userGuess = view.askWeaponToAccuse();
        RoomCard roomGuess=new RoomCard();
        return roomGuess;
    }
}
