package com.doughuang;

import java.io.IOException;

public class WarGame {

    public static void main( String[] args ) throws IOException {
	//War wargame = new War();
        //wargame.play(4,13,2);
        War wargame = new War();
        if (args.length == 3) {
            int numberOfSuits = Integer.parseInt(args[0]);
            int numberOfRanks = Integer.parseInt(args[1]);
            int numberOfPlayers = Integer.parseInt(args[2]);
            wargame.play(numberOfSuits,numberOfRanks,numberOfPlayers);
        } else {
            wargame.play(4,13,2);
        }


    }

}
