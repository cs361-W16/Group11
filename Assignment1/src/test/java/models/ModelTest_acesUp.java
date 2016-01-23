package models;


import ninja.NinjaDocTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import models.acesUp;


/**
 * Created by danielgoh on 1/22/16.
 */
public class ModelTest_acesUp extends NinjaDocTester{

    @Test
    public void testDeckExist() {
        Deck deck = new Deck();
        assertNotNull(deck);

    }

    @Test
    public void NumberOfColumns() {
        acesUp Game = new acesUp();
        assertEquals(0, Game.play());
    }

    @Test
    public void cardDealing() {
        Deck deck = new Deck();
        Deal deal = new Deal();
        deck.hit();             //deals one card
        assertEquals(51, deck.cardsLeft());
    }

    @Test
    public void cardDealing2() {
        Deck deck = new Deck();
        Deal deal = new Deal();
        Card[][] board;
        board = new Card[4][21];
        deal.deal(deck, board);     //deals four cards
        assertEquals(48, deck.cardsLeft());
    }

}
