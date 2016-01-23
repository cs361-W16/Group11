package models;
import java.util.*;
/**
 * Created by jaydeep on 1/21/2016.
 */


public class Move_card {
	/*
	  Gets the input for which card to move
	
	*/
    public Card get_card_input(){

        System.out.println("Enter the suit of the card that you want to move:");
        //Scanner s  = new Scanner(System.in);
        int suit =0;// s.nextInt();
        System.out.println("Enter the number on the card that you want to move:");
        //Scanner t = new Scanner(System.in);
        int number = 0;//t.nextInt();
        Card c = new Card(number, suit);
        return c;


    }
	/*
	  Gets the row input for where to move the card
	
	*/
    public int get_row_input(){

        System.out.println("Enter the row that you wish to move the desired card to here:");
        //Scanner s = new Scanner(System.in);
        int r = 0;//s.nextInt();
        return r;

    }
	 /*
 Gets a card input from the User, and if the input is valid, the card gets moved to the desited location. An error is printed if it is not valid.
 
 
 */
    public void Move_card(Card c, int r, acesUp a1) {

     	if (is_empty(r,a1) && r >= 0 && r <= 4)
            a1.board[r][0] = c;
        else
            System.out.println("That is not a valid row.");}
	/*
	checks to see if the desired row is empty
	
	*/
    public boolean is_empty(int r, acesUp a1){

        if(a1.board[r].length == 0)
            return true;
        else
            return false;}

}
