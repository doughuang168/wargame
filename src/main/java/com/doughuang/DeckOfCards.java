package com.doughuang;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards implements Deck
{

    private ArrayList<Card> cards;
    private ArrayList<Player> players;

    public DeckOfCards() {
        cards = new ArrayList<Card>();
    }

    public void create( int numberOfSuits, int numberOfRanks ){

        //Array.asList([])
        for (int a=0; a<numberOfSuits; a++)
        {
            for (int b=0; b<numberOfRanks; b++)
            {
                cards.add( new Card(a,b) );
            }
        }
    }

    public void shuffle() {
        int index_1, index_2;
        Random generator = new Random();
        Card temp;
        for (int i = 0; i < 100; i++) {
            index_1 = generator.nextInt(cards.size() - 1);
            index_2 = generator.nextInt(cards.size() - 1);
            temp = (Card) cards.get(index_2);
            cards.set(index_2, cards.get(index_1));
            cards.set(index_1, temp);
        }
    }

    public Card deal() {
        return cards.remove( 0 );
    }

    public int getTotalCards()
    {
        return cards.size();
    }

}
