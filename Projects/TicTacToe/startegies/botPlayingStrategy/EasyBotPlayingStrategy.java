package Projects.TicTacToe.startegies.botPlayingStrategy;

import java.util.List;

import Projects.TicTacToe.models.Board;
import Projects.TicTacToe.models.Cell;
import Projects.TicTacToe.models.CellState;
import Projects.TicTacToe.models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    public Move makeMove(Board board) {
        for (List<Cell> row: board.getBoard()) {
            for (Cell cell: row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, null);
                }
            }
        }

        return null;
    }
}
