package Projects.TicTacToe.startegies;

import java.util.HashMap;
import java.util.Map;

import Projects.TicTacToe.models.Board;
import Projects.TicTacToe.models.Move;
import Projects.TicTacToe.models.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy {
    private Map<Symbol, Integer> leftDiagonalCounts = new HashMap<>();
    private Map<Symbol, Integer> rightDiagonalCounts = new HashMap<>();

    public boolean checkWinner(Move move, Board board) {
        // left diagonal -> i == j
        // right diagonal -> i + j == N - 1

        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            if (!leftDiagonalCounts.containsKey(symbol)) {
                leftDiagonalCounts.put(symbol, 0);
            }

            leftDiagonalCounts.put(symbol, leftDiagonalCounts.get(symbol) + 1);

            if (leftDiagonalCounts.get(symbol) == board.getSize()) {
                return true;
            }
        } else if (row + col == board.getSize() - 1) {
            if (!rightDiagonalCounts.containsKey(symbol)) {
                rightDiagonalCounts.put(symbol, 0);
            }

            rightDiagonalCounts.put(symbol, rightDiagonalCounts.get(symbol) + 1);

            if (rightDiagonalCounts.get(symbol) == board.getSize()) {
                return true;
            }
        }

        return false;
    }

    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDiagonalCounts.put(symbol, leftDiagonalCounts.get(symbol) - 1);
        } else if (row + col == board.getSize() - 1) {
            rightDiagonalCounts.put(symbol, rightDiagonalCounts.get(symbol) - 1);
        }
    }
}
