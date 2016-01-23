package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *  An object of type Deck represents a deck of playing cards.  The deck
 *  is a regular poker deck that contains 52 regular cards and that can
 *  also optionally include two Jokers.
 */
public class Deck {

    /**
     * An array of 52 or 54 cards.  A 54-card deck contains two Jokers,
     * in addition to the 52 cards of a regular poker deck.
     */
    private Card[] deck;

    /**
     * Keeps track of the number of cards that have been dealt from
     * the deck so far.
     */
    private int cardsUsed;

    /**
     * Constructs a regular 52-card poker deck.  Initially, the cards
     * are in a sorted order.  The shuffle() method can be called to
     * randomize the order.  (Note that "new Deck()" is equivalent
     * to "new Deck(false)".)
     */
    public Deck() {
        this(false);  // Just call the other constructor in this class.
    }

    /**
     * Constructs a poker deck of playing cards, The deck contains
     * the usual 52 cards and can optionally contain two Jokers
     * in addition, for a total of 54 cards.   Initially the cards
     * are in a sorted order.  The shuffle() method can be called to
     * randomize the order.
     * @param includeJokers if true, two Jokers are included in the deck; if false,
     * there are no Jokers in the deck.
     */
    public Deck(boolean includeJokers) {
        if (includeJokers)
            deck = new Card[54];
        else
            deck = new Card[52];
        int cardCt = 0; // How many cards have been created so far.
        for ( int suit = 0; suit <= 3; suit++ ) {
            for ( int value = 2; value <= 14; value++ ) {
                deck[cardCt] = new Card(value,suit);
                cardCt++;
            }
        }
        if (includeJokers) {
            deck[52] = new Card(1,Card.JOKER);
            deck[53] = new Card(2,Card.JOKER);
        }
        shuffle();
        cardsUsed = 0;
    }

    /**
     * Test whether the deck contains Jokers.
     * @return true, if this is a 54-card deck containing two jokers, or false if
     * this is a 52 card deck that contains no jokers.
     */
    public boolean hasJokers() {
        return (deck.length == 54);
    }

    /**
     * As cards are dealt from the deck, the number of cards left
     * decreases.  This function returns the number of cards that
     * are still left in the deck.  The return value would be
     * 52 or 54 (depending on whether the deck includes Jokers)
     * when the deck is first created or after the deck has been
     * shuffled.  It decreases by 1 each time the dealCard() method
     * is called.
     */
    public int cardsLeft() {
        return deck.length - cardsUsed;
    }


    public int getDeckLength(){
        return deck.length;
    }
    public void shuffle(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for ( int i = 0; i < deck.length; i++ ) list.add(i);
        Collections.shuffle(list);
        Card[] temp = new Card[deck.length];
        for(int i=0; i<deck.length; i++) temp[i] = deck[i];
        for(int i=0; i<deck.length; i++) deck[list.get(i)] = temp[i];
    }
    public Card hit(){
        if(cardsLeft() == 0) return null;       //return null if the deck were empty

        int i = 0;
        while(deck[i] == null) i++;
        Card card = deck[i];
        deck[i] = null;           //insert null to the used card's place
        cardsUsed++;
        return card;
    }


} // end class Deck
