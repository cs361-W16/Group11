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
}
