package models;

/**
 * Created by Shotaro Matsui on 2016/01/22.
 */
public class Deal{
    public static int[] getTopRows(Card[][] board){
        int[] tops = new int[board.length];
        for(int i=0; i<board.length; i++) {
            tops[i] = 0;
            while (board[i].length > tops[i] && board[i][tops[i]] != null) tops[i]++;
            tops[i]--;    //if tops[i] were -1, there is no cards on the column i
        }
        return tops;
    }
    public static boolean deal(Deck deck, Card[][] board){
        if(deck.cardsLeft() < 1) return false;  //if no card is left in the deck, return false
        int[] topRows = getTopRows(board);
        boolean isFull = false;
        for(int i=0; i<board.length; i++) {
            if(topRows[i]+1 == board[0].length) isFull = true;
        }
        if(isFull) return false;                  //return false if any column were full
        for(int i=0; i<board.length; i++)
            board[i][topRows[i]+1] = deck.hit();    //hit from deck and put it on the top row of each columns
        return true;
    }
}
