/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;


import models.Deal;
import org.junit.Test;

import ninja.NinjaDocTester;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import models.Deck;
import models.Card;
import models.acesUp;

public class ApiControllerDocTesterTest extends NinjaDocTester {

    String URL_INDEX = "/";
    String URL_ACES_UP = "/AcesUp";

    @Test
    public void testGetIndex() {

        Response response = makeRequest(
                Request.GET().url(
                        testServerUrl().path(URL_INDEX)));

        assertThat(response.payload, containsString("Hello World!"));
        assertThat(response.payload, containsString("BAM!"));
    }

    @Test
    public void testAcesUp() {
        Response response = makeRequest(
                Request.GET().url(
                        testServerUrl().path(URL_ACES_UP)));

        assertThat(response.payload, containsString("Aces Up"));
        assertThat(response.payload, containsString("columnOfCards"));
    }

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