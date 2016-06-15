package com.doughuang;


public class Card
{
    //private int cardNum;
    private int rank, suit;

    final static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    final static String[] ranks = {"2","3","4","5","6","7","8", "9","10", "Jack", "Queen", "King", "Ace"};

    Card(int suit, int rank)
    {
        this.rank=rank;
        this.suit=suit;
    }

    public @Override String toString()
    {
        return ranks[rank] + " of " + suits[suit];
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

}
