package Projects.TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Projects.TicTacToe.Exceptions.InvalidBotCountException;
import Projects.TicTacToe.Exceptions.InvalidPlayerSizeException;
import Projects.TicTacToe.Exceptions.InvalidPlayerSymbolException;
import Projects.TicTacToe.controllers.GameController;
import Projects.TicTacToe.models.Bot;
import Projects.TicTacToe.models.BotDifficultyLevel;
import Projects.TicTacToe.models.Game;
import Projects.TicTacToe.models.GameState;
import Projects.TicTacToe.models.Player;
import Projects.TicTacToe.models.PlayerType;
import Projects.TicTacToe.startegies.ColWinningStrategy;
import Projects.TicTacToe.startegies.DiagonalWinningStrategy;
import Projects.TicTacToe.startegies.RowWinningStrategy;
import Projects.TicTacToe.startegies.WinningStrategy;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerSizeException, InvalidPlayerSymbolException {
        Scanner sc = new Scanner(System.in);

        GameController gameController = new GameController();
        System.out.println("Game is starting...");

        try {
            int dimensionsForGame = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(1, "Sam", 'X', PlayerType.HUMAN));
            players.add(new Bot(1, "GPT", 'O', BotDifficultyLevel.EASY));

            List<WinningStrategy> winningStrategies = List.of(
                new ColWinningStrategy(),
                new RowWinningStrategy(),
                new DiagonalWinningStrategy()
            );

            Game game1 = gameController.startGame(dimensionsForGame, players, winningStrategies);
            gameController.displayBoard(game1);
            System.out.println();

            while (gameController.checkState(game1).equals(GameState.IN_PROGRESS)) {
                gameController.makeMove(game1);
                
                System.out.println("Do you want to undo? y/n");
                String undoAnswer = sc.next();
                if (undoAnswer.equals("y")) {
                    gameController.undo(game1);
                }

                gameController.displayBoard(game1);
                System.out.println();
            }

            System.out.println("The game is finished!");
            GameState gameState = gameController.checkState(game1);

            if (gameState.equals(GameState.DRAW)) {
                System.out.println("The result is DRAW");
            }
            else if (gameState.equals(GameState.SUCCESS)) {
                System.out.println("Winner is " + gameController.getWinner(game1).getName());
            }

        } catch (Exception e) {
            System.out.println("Game has stopped working!");
            throw e;
        }
    }
}
