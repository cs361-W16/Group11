package models;

import ninja.NinjaDocTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import models.Deck;
import models.Card;

/**
 * Created by user on 2016/01/22.
 */
public class ModeTest_DeckAndDeal extends NinjaDocTester {

    @Test
    public void testDeckConstructor(){
        Deck deck = new Deck();
        assertEquals(deck.hasJokers(), false);
    }
    @Test
    public void testHasJoker(){
        Deck deck = new Deck(true);
        assertEquals(deck.hasJokers(), true);
    }
    @Test
    public void testShuffle(){
        Deck deck1 = new Deck(false);
        Deck deck2 = new Deck(false);
        deck1.shuffle();
        boolean isSameOrder = true;
        for(int i=0; i<deck1.getDeckLength(); i++){
            if(deck1.hit() != deck2.hit()) isSameOrder = false;
        }
        assertEquals(isSameOrder, false);
    }
    @Test
    public void testHitDecks(){
        Deck deck = new Deck(false);
        boolean returnNull = false;
        for(int i=0; i< deck.getDeckLength(); i++)
            if(deck.hit() == null) returnNull = true;
        assertEquals(returnNull, false);
    }
    @Test
    public void testHitEmptyDeck(){
        Deck deck = new Deck(false);
        for(int i=0; i< deck.getDeckLength(); i++) deck.hit();
        assertEquals(deck.hit(), null);
    }
    @Test
    public void testHitUniqueness(){//test for making sure that every hits are different cards
        Deck deck = new Deck(false);
        Card[] cards = new Card[deck.getDeckLength()];
        boolean unique = true;
        for(int i=0; i< deck.getDeckLength(); i++){
            cards[i] = deck.hit();
            for(int j=0; j<i; j++)
                if(cards[i] == cards[j]) unique = false;
        }
        assertEquals(unique, true);
    }
    @Test
    public void testgetTopRowNumber1(){
        Card[][] board = new Card[1][2];
        board[0][0] = new Card(3,3);
        board[0][1] = null;
        int[] x = Deal.getTopRows(board);
        assertEquals(x[0], 0);
    }
    @Test
    public void testgetTopRowNumber0(){
        Card[][] board = new Card[1][2];
        board[0][0] = null;
        board[0][1] = new Card(3,3);
        int[] x = Deal.getTopRows(board);
        assertEquals(x[0], -1);
    }
    @Test
    public void testDealToRow0(){
        Deck deck = new Deck(false);
        Card[][] board = new Card[1][2];
        board[0][0] = null;
        board[0][1] = null;
        assertEquals(Deal.deal(deck, board)&&(board[0][0] != null), true);
    }
    @Test
    public void testDealToRow1(){
        Deck deck = new Deck(false);
        Card[][] board = new Card[1][2];
        board[0][0] = new Card(3,3);
        board[0][1] = null;
        assertEquals(Deal.deal(deck, board)&&(board[0][1] != null), true);
    }
    @Test
    public void testDealTo2Columns(){
        Deck deck = new Deck(false);
        Card[][] board = new Card[2][3];
        board[0][0] = new Card(3,3);    board[1][0] = new Card(4,3);
        board[0][1] = null;             board[1][1] = new Card(2,2);
        board[0][2] = null;             board[1][2] = null;
        assertEquals(Deal.deal(deck, board)&&(board[0][1] != null)&&(board[1][2] != null), true);
    }
    @Test
    public void testDealEmptyDeck(){
        Deck deck = new Deck(false);
        for(int i=0; i< deck.getDeckLength(); i++) deck.hit();
        Card[][] board = new Card[2][3];
        board[0][0] = new Card(3,3);    board[1][0] = new Card(4,3);
        board[0][1] = null;             board[1][1] = new Card(2,2);
        board[0][2] = null;             board[1][2] = null;
        assertEquals(Deal.deal(deck, board)||(board[0][1] != null)||(board[1][2] != null), false);
    }
    @Test
    public void testDealToFullBoard(){
        Deck deck = new Deck(false);
        Card[][] board = new Card[1][3];
        board[0][0] = new Card(3,3);
        board[0][1] = new Card(5,2);
        board[0][2] = new Card(9,0);
        assertEquals(Deal.deal(deck, board), false);
    }
}
