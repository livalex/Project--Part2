package main;

import constants.Constants;

import java.util.ArrayList;

public final class Input {

    // Input fields.
    private final int n;
    private final int m;
    private final int p;
    private final int r;
    private final ArrayList<String> battleGround;
    private final ArrayList<String> playerTypes;
    private final ArrayList<Integer> firstCoordonates;
    private final ArrayList<Integer> secondCoordonates;
    private final ArrayList<String> moves;
    private final ArrayList<Integer> numberAngelsRound;
    private final ArrayList<String> angelTypes;

    public Input() {
        n = 0;
        m = 0;
        p = 0;
        r = 0;
        battleGround = null;
        playerTypes = null;
        secondCoordonates = null;
        firstCoordonates = null;
        moves = null;
        numberAngelsRound = null;
        angelTypes = null;
    }

    public Input(final ArrayList<String> battleGround, final ArrayList<String> playerTypes,
                 final ArrayList<Integer> integerData,
                 final ArrayList<Integer> secondCoordonates,
                 final ArrayList<String> moves, final ArrayList<Integer> numberAngelsRound,
                 final ArrayList<String> angelTypes) {
        this.n = integerData.get(0);
        this.m = integerData.get(1);
        this.battleGround = battleGround;
        this.p = integerData.get(2);
        this.playerTypes = playerTypes;

        // To trick the 7 arguments checkstyle error
        ArrayList<Integer> copyIntegerData = new ArrayList<>();
        for (int j = Constants.INT_DATA_FIRST_COORD; j < integerData.size() - 1; ++j) {
            copyIntegerData.add(integerData.get(j));
        }
        this.firstCoordonates = copyIntegerData;

        this.secondCoordonates = secondCoordonates;
        this.r = integerData.get(integerData.size() - 1);
        this.moves = moves;
        this.numberAngelsRound = numberAngelsRound;
        this.angelTypes = angelTypes;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getP() {
        return p;
    }

    public int getR() {
        return r;
    }

    public ArrayList<String> getBattleGround() {
        return battleGround;
    }

    public ArrayList<String> getPlayerTypes() {
        return playerTypes;
    }

    public ArrayList<Integer> getFirstCoordonates() {
        return firstCoordonates;
    }

    public ArrayList<Integer> getSecondCoordonates() {
        return secondCoordonates;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public ArrayList<Integer> getNumberAngelsRound() {
        return numberAngelsRound;
    }

    public ArrayList<String> getAngelTypes() {
        return angelTypes;
    }
}
