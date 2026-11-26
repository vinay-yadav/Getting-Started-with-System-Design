package Projects.TicTacToe;

import java.util.ArrayList;

import Projects.TicTacToe.Exceptions.InvalidBotCountException;
import Projects.TicTacToe.Exceptions.InvalidPlayerSizeException;
import Projects.TicTacToe.Exceptions.InvalidPlayerSymbolException;
import Projects.TicTacToe.controllers.GameController;
import Projects.TicTacToe.models.Game;
import Projects.TicTacToe.models.GameState;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerSizeException, InvalidPlayerSymbolException {
        GameController gameController = new GameController();
        System.out.println("Game  is starting...");

        Game game1 = gameController.startGame(3, new ArrayList<>(), new ArrayList<>());
        gameController.displayBoard(game1);

        while (gameController.checkState(game1).equals(GameState.IN_PROGRESS)) {
            gameController.makeMove(game1);
            gameController.displayBoard(game1);
        }

        if (gameController.checkState(game1).equals(GameState.DRAW)) {
            System.out.println("Game ends in a DRAW");
        }
        else if (gameController.checkState(game1).equals(GameState.SUCCESS)) {
            System.out.println("Winner is " + gameController.getWinner(game1).getName());
        }
    }
}
