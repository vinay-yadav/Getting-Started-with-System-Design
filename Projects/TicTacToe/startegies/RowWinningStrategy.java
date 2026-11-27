package Projects.TicTacToe.startegies;

import java.util.HashMap;
import java.util.Map;

import Projects.TicTacToe.models.Board;
import Projects.TicTacToe.models.Move;
import Projects.TicTacToe.models.Symbol;

public class RowWinningStrategy implements WinningStrategy {
    private final Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if (!counts.containsKey(row)) {
            counts.put(row, new HashMap<>());
        }

        HashMap<Symbol, Integer> rowMap = counts.get(row);
        if (!rowMap.containsKey(symbol)) {
            rowMap.put(symbol, 0);
        }

        rowMap.put((symbol), rowMap.get(symbol) + 1);

        if (rowMap.get(symbol) == board.getSize()) {
            return true;
        }

        return false;
    }

    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        Map<Symbol, Integer> rowMap = counts.get(row);
        rowMap.put(symbol, rowMap.get(symbol) - 1);
    }
}
