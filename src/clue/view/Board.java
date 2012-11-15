/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.view;

import clue.model.RoomsStatus;



/**
 *
 * @author Yotam
 */
public class Board {
    RoomsStatus rooms;
    Pawn PawnList;
    //private static List<RoomsStatus> roomList; 
    //private static List<Pawn> PawnList;
    
    public Board()
    {
        
//        //int numOfPlayers; //@TODO do i need this?
//        for(RoomsStatus c : RoomsStatus.values())
//        {
//             roomList.add(c);
//             
//        }
////           roomList.add(RoomsStatus.);
////           i+=2;
//       for(int i =0 ; i< roomList.size() ;i++)
//       {
//           System.out.println(roomList.get(i).getRoomNum());
//       }
    }
    public void printBoard()
    {
        int screenWidth = 106;
      int roomWidth = 20;
      int roomHeight = 5;       
      
      //print top frame line
      for (int topFrameInd=0; topFrameInd<screenWidth; topFrameInd++)
      {
          System.out.print("-");
      }
      System.out.print("\n");
      
      for (int numOfVerticalRooms=0; numOfVerticalRooms < 5; numOfVerticalRooms++)
      {
          for (int RoomWallsDashes=0; RoomWallsDashes < roomHeight; RoomWallsDashes++)
          {
              System.out.print("|");
              
              for (int numOfHorizontalRooms=0; numOfHorizontalRooms < 5; numOfHorizontalRooms++)
              {
                for (int roomEmptySpaceInd=0; roomEmptySpaceInd < roomWidth; roomEmptySpaceInd++)
                {
                    System.out.print(" ");
                }

                if ((numOfVerticalRooms>0 && numOfVerticalRooms<4) && (numOfHorizontalRooms>0 && numOfHorizontalRooms<3 ))
                {   
                    System.out.print(" ");
                } else {
                    System.out.print("|");
                } 
              }
              System.out.print("\n");
          }
        for (int floorsInd=0; floorsInd<screenWidth; floorsInd++)
        {
            if (numOfVerticalRooms>0 && numOfVerticalRooms<3)  
            {
                if (floorsInd > roomWidth && floorsInd <roomWidth*4+4)
                {
                    System.out.print(" ");
                } else {
                   System.out.print("-");
                  } 
            } else {
                System.out.print("-");
            }
         }
        System.out.print("\n");
      }
      System.out.print("\n");       
    }
  
}
