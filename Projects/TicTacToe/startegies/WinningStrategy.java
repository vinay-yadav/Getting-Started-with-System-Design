package Projects.TicTacToe.startegies;

import Projects.TicTacToe.models.Board;
import Projects.TicTacToe.models.Player;

public interface WinningStrategy {
    public boolean checkWinner(Player player, Board board);
}
