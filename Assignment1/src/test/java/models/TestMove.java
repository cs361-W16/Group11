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
public class MoveTest extends NinjaDocTester {


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
