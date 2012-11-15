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
 
 public RoomCard()
 {
     selectRandomRoom();
 }
 
 public RoomCard(int room)
 {
     roomFromInt(room);
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
            final RoomCard compare = (RoomCard) obj;
            if(this.room.name()!=compare.room.name())
            {
                equals=false;
            }
                
        }
        return equals;
    }
 private void roomFromInt(int room)
 {
     switch (room) 
        {
            case 1: this.room =(RoomCard.Rooms.Ballroom);
                    RoomCard.Rooms.Ballroom.setActive();
                break;
            case 2: this.room =(RoomCard.Rooms.BilliardRoom);
                    RoomCard.Rooms.BilliardRoom.setActive();
                break;
            case 3: this.room =(RoomCard.Rooms.Conservatory);
                    RoomCard.Rooms.Conservatory.setActive();
                break;
            case 4: this.room =(RoomCard.Rooms.DiningRoom);
                    RoomCard.Rooms.DiningRoom.setActive();
                break;
            case 5: this.room =(RoomCard.Rooms.Hall);
                    RoomCard.Rooms.Hall.setActive();
                break;
            case 6:this.room =(RoomCard.Rooms.Kitchen);
                    RoomCard.Rooms.Kitchen.setActive();
                break;
            case 7: this.room =(RoomCard.Rooms.Library);
                    RoomCard.Rooms.Library.setActive();
                break;
            case 8: this.room =(RoomCard.Rooms.Lounge);
                    RoomCard.Rooms.Lounge.setActive();
                break;
            case 9:this.room =(RoomCard.Rooms.Study);
                    RoomCard.Rooms.Study.setActive();  
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
    
}
