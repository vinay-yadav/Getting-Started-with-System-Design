package Projects.TicTacToe.startegies.botPlayingStrategy;

import Projects.TicTacToe.models.Board;
import Projects.TicTacToe.models.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
