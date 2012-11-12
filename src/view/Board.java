/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.view;

import clue.Model.RoomsStatus;

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
    String rowOfDash=new String();
    for (int i=0 ; i<79 ; i++)
    {
        rowOfDash=rowOfDash+"-";
    }
    System.out.println(rowOfDash);
    printFirstLine();
       
//    System.out.println(rowOfDash);
    }
    void printFirstLine()
    {
        System.out.print("|  ");
        System.out.print( rooms.BALLROOM+ "  |");
//        for(RoomsStatus rooms : RoomsStatus.values())
//       {
//           System.out.print(rooms.getRoomName());
//       }
    }
    
    
}
