/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.Model;

import clue.Model.CharactersCard.Characters;
import clue.Model.RoomCard.Rooms;
import clue.Model.WeaponsCard.Weapons;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yotam
 */
public class CardDeck {
    public static final List<WeaponsCard> weaponsDeck = 
            new ArrayList<WeaponsCard>();
    private static final List<CharactersCard> characterDeck = 
            new ArrayList<CharactersCard>();
    private static final List<RoomCard> roomDeck = 
            new ArrayList<RoomCard>();
    public CardDeck()
        {
            for (Characters character : Characters.values())
            {
                characterDeck.add(new CharactersCard(character));
            }
            for (Weapons weapon : Weapons.values())
            {
                weaponsDeck.add(new WeaponsCard(weapon));
            }
            for (Rooms room : Rooms.values())
            {
                roomDeck.add(new RoomCard(room));
            }
        } 
    public static WeaponsCard getWeaponCard()
    {
        WeaponsCard newCard = new WeaponsCard();
        boolean wasWeaponNonActiv=true;
        while (wasWeaponNonActiv==true)
        {
            newCard.selectRandomWeapon();
            wasWeaponNonActiv=newCard.getActiv();
        }
        newCard.setActiv();
        return newCard;
    }
    
    public static CharactersCard getCharecterCard()
    {
        CharactersCard newCard = new CharactersCard();
        boolean wasCharecterNonActiv=true;
        while (wasCharecterNonActiv==true)
        {
            newCard.selectRandomCharacter();
            wasCharecterNonActiv=newCard.getActiv();
        }
        newCard.setActiv();
        return newCard;
    }
        public static RoomCard getRoomCard()
    {
        RoomCard newCard = new RoomCard();
        boolean wasCharecterNonActiv=true;
        while (wasCharecterNonActiv==true)
        {
            newCard.selectRandomRoom();
            wasCharecterNonActiv=newCard.getActiv();
        }
        newCard.setActiv();
        return newCard;
    }
}
