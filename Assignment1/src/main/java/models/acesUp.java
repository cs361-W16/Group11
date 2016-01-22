package models;

/**
 * Created by danielgoh on 1/21/16.
 */

import java.util.ArrayList;

public class acesUp {

    private static int COLNUM = 4;
    private static int ROWNUM = 21;
    private Card[][] board;



    /**
    Sets up the variables to keep track of the game state
     */
    public static void main(String[] args) {

        int score = 0;
        boolean playAgain;

    }

    public int play() {
        //Prepares a new deck
        Deck deck = new Deck();

        /**
         * Create a board that is initially empty. (2D array)
         * 1st dimension will keep track of the columns
         * 2nd dimension will keep track of the rows (like a stack)
         */
        board = new Card[COLNUM][ROWNUM];



        return 0; //only temporary
    }

}
