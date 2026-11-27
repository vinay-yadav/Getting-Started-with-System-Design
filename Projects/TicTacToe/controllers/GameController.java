package Projects.TicTacToe.controllers;

import java.util.List;

import Projects.TicTacToe.Exceptions.InvalidBotCountException;
import Projects.TicTacToe.Exceptions.InvalidPlayerSizeException;
import Projects.TicTacToe.Exceptions.InvalidPlayerSymbolException;
import Projects.TicTacToe.models.Game;
import Projects.TicTacToe.models.GameState;
import Projects.TicTacToe.models.Player;
import Projects.TicTacToe.startegies.WinningStrategy;

public class GameController {
    public Game startGame(
        int dimension,
        List<Player> players,
        List<WinningStrategy> winningStrategies
    ) throws InvalidBotCountException, InvalidPlayerSizeException, InvalidPlayerSymbolException {
        return Game.gameBuilder()
            .setDimension(dimension)
            .setPlayers(players)
            .setWinningStrategies(winningStrategies)
            .build();
    }

    public void displayBoard(Game game) {        
        game.printBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void undo(Game game) {
        // No business logic in the controller
        game.undo();
    }
}
