package ait.consultation_14.coins.model;

import java.util.Random;

public class Coin {
    String side;

    @Override
    public String toString() {
        return getSide();
    }

    public Coin() {
        this.side = tossACoin();
    }

    public String getSide() {
        return side;
    }

    private String tossACoin() {
        String side;
        Random random = new Random();
        int s = random.nextInt(2);
        if (s == 0) {
            side = "head";

        } else {
            side = "tail";
        }
        return side;
    }
}
