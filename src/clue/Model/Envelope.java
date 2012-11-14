/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.Model;

/**
 *
 * @author Yotam
 */
public class Envelope {
    WeaponsCard weapon;
    CharactersCard character;
    RoomCard room;
    
    public Envelope(WeaponsCard weapon, CharactersCard character ,
            RoomCard room)
    {
        this.character=character;
        this.weapon=weapon;
        this.room=room;
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
            final Envelope compre=(Envelope)obj;
            if(this.character.equals(compre.character)!=true){
                equals=false;
            }
            else if (this.room.equals(compre.room)!=true)
            {
                equals=false;
            }
            else if ( this.weapon.equals(compre.weapon)!=true)
            {
                equals=false;
            }
        }
        return  equals;
    }
    
}
