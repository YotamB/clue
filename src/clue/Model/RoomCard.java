/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.Model;

import java.util.Random;

/**
 *
 * @author Yotam
 */
public class RoomCard {
        private Rooms room;
        
    public enum Rooms {
        Kitchen, Conservatory , Ballroom , DiningRoom , Lounge , Hall , Study ,
        Library , BilliardRoom;
        
        boolean active;
        
        public void setActive() 
        {
             active=true;
        }
        
    }
    
 public  RoomCard(Rooms inputRoom)
    {
        this.room=inputRoom;
    } 
 public String getRoomName()
 {
     return this.room.toString();
 }
 public RoomCard()
 {
     selectRandomRoom();
 }
 
 public RoomCard(int room)
 {
     roomFromInt(room);
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
            final RoomCard compare = (RoomCard) obj;
            if(this.room.name() == null ? compare.room.name() != null : !this.room.name().equals(compare.room.name()))
            {
                equals=false;
            }
                
        }
        return equals;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.room != null ? this.room.hashCode() : 0);
        return hash;
    }
 private void roomFromInt(int room)
 {
     switch (room) 
        {
            case 1: this.room =(RoomCard.Rooms.Ballroom);
                break;
            case 2: this.room =(RoomCard.Rooms.BilliardRoom);
                break;
            case 3: this.room =(RoomCard.Rooms.Conservatory);
                break;
            case 4: this.room =(RoomCard.Rooms.DiningRoom);
                break;
            case 5: this.room =(RoomCard.Rooms.Hall);
                break;
            case 6:this.room =(RoomCard.Rooms.Kitchen);
                break;
            case 7: this.room =(RoomCard.Rooms.Library);
                break;
            case 8: this.room =(RoomCard.Rooms.Lounge);
                break;
            case 9:this.room =(RoomCard.Rooms.Study);
                break;
                default:this.room=null;
        }
 }
    public void selectRandomRoom()
    {
        Random random = new Random();
        int resultOfRandom=resultOfRandom= (random.nextInt(9)+1);
        roomFromInt(resultOfRandom);
    }
    public void setActiv()
    {
        this.room.active=true;
    }
        
    public boolean getActiv()
    {
      return this.room.active;
    }
}
