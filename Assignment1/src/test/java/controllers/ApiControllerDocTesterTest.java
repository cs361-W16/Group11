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
}