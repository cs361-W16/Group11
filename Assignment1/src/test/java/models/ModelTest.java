package models;

import ninja.NinjaDocTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import models.Deck;
import models.Card;
import models.acesUp;

/**
 * Created by danielgoh on 1/22/16.
 */
public class ModelTest extends NinjaDocTester {


    @Test
    public void testDeckExist() {
        Deck deck = new Deck();
        assertNotNull(deck);

    }

    @Test
    public void testDeckCount() {
        Deck deck = new Deck();
        assertEquals(52, deck.cardsLeft());
    }

    @Test
    public void testSuit() {
        Card card = new Card(2, 1);
        assertEquals("Hearts", card.getSuitAsString());
    }

    @Test
    public void testValue() {
        Card card = new Card(14, 1);
        assertEquals("Ace", card.getValueAsString());
    }

    @Test
    public void testCard() {
        Card card = new Card(12, 3);
        assertEquals("Queen of Clubs", card.toString());
    }

    @Test
    public void testValue1() {
        for (int i = 2; i <= 10; i++) {
            Card card = new Card(i, 0);
            assertEquals(i, card.getValue());
        }
    }

    @Test
    public void testValue11() {
        Card card = new Card(11, 0);
        assertEquals("Jack", card.getValueAsString());
    }

    @Test
    public void testValue12() {
        Card card = new Card(12, 0);
        assertEquals("Queen", card.getValueAsString());
    }

    @Test
    public void testValue13() {
        Card card = new Card(13, 0);
        assertEquals("King", card.getValueAsString());
    }

    @Test
    public void testValue14() {
        Card card = new Card(14, 0);
        assertEquals("Ace", card.getValueAsString());
    }

    @Test
    public void testDeckCount2() {
        Deck deck = new Deck();
        //WILL BE CONTINUED ONCE DEAL FUNCTION IS OUT
    }

    @Test
    public void testGetSuit() {
        Card card = new Card(13, 0);
        assertEquals(0, card.getSuit());
    }

    @Test
    public void testJoker1() {
        Card card = new Card();
        assertEquals(4, card.getSuit());
    }

    @Test
    public void testJoker2() {
        Card card = new Card();
        assertEquals(14, card.getValue());
    }

    @Test
    public void testJoker3() {
        Card card = new Card();
        assertEquals("Joker", card.toString());
    }

    @Test
    public void testSuit1() {
        Card card = new Card(3, 0);
        assertEquals("Spades", card.getSuitAsString());
    }
    @Test
    public void testSuit2() {
        Card card = new Card(2, 2);
        assertEquals("Diamonds", card.getSuitAsString());
    }

    @Test
    public void testSuit3() {
        Card card = new Card();
        assertEquals("Joker", card.getSuitAsString());
    }

    @Test
    public void testJoker4() {
        Card card = new Card();
        assertEquals("14", card.getValueAsString());
    }

    @Test
    public void testgetValueAsString() {
        Card card = new Card(2, 2);
        assertEquals("2", card.getValueAsString());
    }

    @Test
    public void testgetValueAsString2() {
        Card card = new Card(3, 2);
        assertEquals("3", card.getValueAsString());
    }
    @Test
    public void testgetValueAsString3() {
        Card card = new Card(4, 2);
        assertEquals("4", card.getValueAsString());
    }
    @Test
    public void testgetValueAsString4() {
        Card card = new Card(5, 2);
        assertEquals("5", card.getValueAsString());
    }
    @Test
    public void testgetValueAsString5() {
        Card card = new Card(6, 2);
        assertEquals("6", card.getValueAsString());
    }
    @Test
    public void testgetValueAsString6() {
        Card card = new Card(7, 2);
        assertEquals("7", card.getValueAsString());
    }
    @Test
    public void testgetValueAsString7() {
        Card card = new Card(8, 2);
        assertEquals("8", card.getValueAsString());
    }
    @Test
    public void testgetValueAsString8() {
        Card card = new Card(9, 2);
        assertEquals("9", card.getValueAsString());
    }
    @Test
    public void testgetValueAsString9() {
        Card card = new Card(10, 2);
        assertEquals("10", card.getValueAsString());
    }

    @Test
    public void testJokerDeck() {
        Deck deck = new Deck(true);
        assertEquals(54, deck.cardsLeft());
    }

    @Test
    public void testJokerDeck2() {
        Deck deck = new Deck(true);
        assertEquals(true, deck.hasJokers());
    }

    @Test
    public void testIllegalValue() {
        try {
            Card card = new Card(60, 3);
        } catch(IllegalArgumentException e) {}

    }

    @Test
    public void testIllegalSuit() {
        try {
            Card card = new Card(3, 30);
        } catch(IllegalArgumentException e) {}

    }
	 @Test
    public void testEmptyRowMoveCard() {
        Card c = new Card(12, 2);
        Card d = new Card(2, 1);
        int row = 0;
        acesUp a1 = new acesUp();
        Move_card m1 = new Move_card();

        for (int i = 1; i < 4; i++)
            for (int j = 0; j < 21; j++)
                a1.board[i][j] = c;

        m1.Move_card(d, row, a1);

        assertEquals(d, a1.board[row][0]);
    }

    @Test
    public void testHalfRowMoveCard() {
        Card c = new Card(12, 2);
        Card d = new Card(2, 1);
        acesUp a1 = new acesUp();
        Move_card m1 = new Move_card();

        for (int i = 1; i < 4; i++)
            for (int j = 0; j < 11; j++)
                a1.board[i][j] = c;

        m1.Move_card(d, 0, a1);
        m1.Move_card(d, 6, a1);
        assertEquals(c, a1.board[0][0]);
    }

    @Test
    public void testOutOfBoundsMoveCard() {
        Card c = new Card(2, 1);
        Card d = new Card(14, 17);
        acesUp a1 = new acesUp();
        Move_card m1 = new Move_card();

        for (int i = 1; i < 4; i++)
            for (int j = 0; j < 11; j++)
                a1.board[i][j] = c;

        m1.Move_card(d, 0, a1);
        assertEquals(c, a1.board[0][0]);
    }

    @Test
    public void testGetCardInput() {
        Move_card m1 = new Move_card();
        Card c1 = m1.get_card_input();
        assertNotNull(c1);


    }

    @Test
    public void testGetRowInput() {
        Move_card m1 = new Move_card();
        int r1 = m1.get_row_input();
        assertNotNull(r1);

    }

    @Test
    public void testIsEmpty() {
        int r = 0;
        acesUp a1 = new acesUp();
        Move_card m1 = new Move_card();
        boolean x = (m1.is_empty(r,a1));
        assertTrue(x);


    }
}
