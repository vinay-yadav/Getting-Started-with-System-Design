package Projects.TicTacToe.startegies;

import java.util.HashMap;
import java.util.Map;

import Projects.TicTacToe.models.Board;
import Projects.TicTacToe.models.Move;
import Projects.TicTacToe.models.Symbol;

public class ColWinningStrategy implements WinningStrategy {
    private final Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        if (!counts.containsKey(col)) {
            counts.put(col, new HashMap<>());
        }

        HashMap<Symbol, Integer> colMap = counts.get(col);
        if (!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }

        colMap.put((symbol), colMap.get(symbol) + 1);

        if (colMap.get(symbol) == board.getSize()) {
            return true;
        }

        return false;
    }

    public void handleUndo(Board board, Move move) {
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        Map<Symbol, Integer> colMap = counts.get(col);
        colMap.put(symbol, colMap.get(symbol) - 1);
    }
}
