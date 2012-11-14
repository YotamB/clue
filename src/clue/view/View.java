/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clue.view;

import java.util.Scanner;

/**
 *
 * @author Yotam
 */
public class View {
        
        Board board=new Board();
        public int askUserForNumberOfPlayers()
        {
            System.out.println("Please Enter number 3-6 of users");
            Scanner scanner = new Scanner(System.in);
            int userString = scanner.nextInt();
            return userString;
        }
        public boolean askUserIfHumen()
        {
            System.out.println("enter true for Human false for PC");
            Scanner scanner = new Scanner(System.in);
            boolean userString = scanner.nextBoolean();
            return userString;
        }
        public String askUserName()
        {
            System.out.println("Enter User name");
            Scanner scanner = new Scanner(System.in);
            String userString = scanner.nextLine();
            return userString;
        }
            public boolean askUserHowToMove()
        {
            System.out.println("clockwise = true counterclockwise = false");
            Scanner scanner = new Scanner(System.in);
            boolean userString = scanner.nextBoolean();
            return userString;
        }
        public void updatePownLocationOnBoard(int playerNumber)
        {
            
        }
        public void printBoard()
        {
            board.printBoard();
        }
        
        public int askPlayerWhoToAccuse()
        {
            //@TODO- print list of all charecters and ask for num
            System.out.println("select charecters");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            return userInput;
        }
    
        public int askWeaponToAccuse()
        {
            //@TODO- print list of all weapons and ask for num
            System.out.println("select weapon");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            return userInput;
        }
}
