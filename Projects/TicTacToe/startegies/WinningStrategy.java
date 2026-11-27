package Projects.TicTacToe.startegies;

import Projects.TicTacToe.models.Board;
import Projects.TicTacToe.models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Move move, Board board);
    public void handleUndo(Board board, Move move);
}
