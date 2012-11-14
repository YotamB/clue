/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.Model;

import clue.Model.WeaponsCard.Weapons;
import clue.view.Pawn;
import java.util.List;

/**
 *
 * @author Yotam
*/
  
public enum  RoomsStatus {
       
       HALLWAY("HallWay",0),
       KITCHEN("Kitchen",1),
       CONSERVATORY("Conservatory" , 3),
       BALLROOM("Ballroom" , 5),
       DININGROOM("DiningRoom" ,7),
       LOUNGE("Lounge" , 9),
       HALL("Hall" ,11),
       STUDY("Study" ,13) ,
       LIBRARY("Library" ,15),
       BILLIARDROOM("BilliardRoom" ,17) ;
       

       private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
       private int roomNumber;
       private List<Pawn> pwanssInRoom;

    public List<Pawn> getPwanssInRoom() {
        return pwanssInRoom;
    }

    public void setPwanssInRoom(List<Pawn> pwanssInRoom) {
        this.pwanssInRoom = pwanssInRoom;
    }

    public List<Weapons> getWeaponsInRoom() {
        return weaponsInRoom;
    }

    public void setWeaponsInRoom(List<Weapons> weaponsInRoom) {
        this.weaponsInRoom = weaponsInRoom;
    }
       private List<WeaponsCard.Weapons> weaponsInRoom;
       
       
       public void addPlayerToRoom()
       {
           
       }
       
       private RoomsStatus(String name ,int roomNumber)
       {
           this.name=name;
           this.roomNumber=roomNumber;
           pwanssInRoom=null;
           weaponsInRoom=null;
       }
              
       public int getRoomNum()
       {
           RoomsStatus userEnum = RoomsStatus.valueOf(this.name.toUpperCase());
           return userEnum.roomNumber;
       }
       
       public String getRoomName()
       {
            String name = this.name();
            return name;
       }
       
       public RoomsStatus setByRoomNum(int roomNumber)
       {
           RoomsStatus newRoom=null;
           switch(roomNumber){
               case 1: newRoom=KITCHEN;
                   break;
               case 3: newRoom=CONSERVATORY;
                   break;
               case 5: newRoom=BALLROOM;
                   break;
               case 7: newRoom=DININGROOM;
                   break;
               case 9: newRoom=LOUNGE;
                    break;
               case 11: newRoom=HALL;
                   break;
               case 13: newRoom=STUDY;
                   break;
               case 15: newRoom= LIBRARY;
                   break;
               case 17: newRoom= BILLIARDROOM;
                   break;
           default:newRoom=HALLWAY;       
           }
           return newRoom;
       }
       
   }


