package main;

import players.Human;
import players.PlayersFactory;

import java.util.ArrayList;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        // Objects used to read and write data.
        InputLoader inputLoader = InputLoader.getInstance(args[0], args[1]);
        Input input = inputLoader.load();

        // Instantiations.
        MapBuilder mapBuilder = MapBuilder.getInstance(input.getBattleGround());
        VectorCreator vectorCreator = VectorCreator.getInstance();
        ActionCreator actionCreator = ActionCreator.getInstance();
        PlayersFactory playersFactory = PlayersFactory.getInstance();

        // Build the 'map'.
        ArrayList<String> ground = mapBuilder.getBattleGround();

        // Create the players array
        ArrayList<Human> players = vectorCreator.createVector(input.getP(), playersFactory, input);

        // Play game.
        players = actionCreator.createMoves(input.getR(), input.getP(),
                input, players, ground, inputLoader);

        // Display the output.
        inputLoader.exposeOutput(players);
    }
}
