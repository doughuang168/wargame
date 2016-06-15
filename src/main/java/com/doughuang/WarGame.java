package com.doughuang;

import java.io.IOException;

public class WarGame {

    public static void main( String[] args ) throws IOException {
        War wargame = new War();
        wargame.play(4,13,2);
    }

}
