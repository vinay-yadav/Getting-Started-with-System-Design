package Projects.TicTacToe.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Projects.TicTacToe.Exceptions.InvalidBotCountException;
import Projects.TicTacToe.Exceptions.InvalidPlayerSizeException;
import Projects.TicTacToe.Exceptions.InvalidPlayerSymbolException;
import Projects.TicTacToe.startegies.WinningStrategy;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private GameState gameState;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>();
    }

    public boolean validateMove(Move move) {
        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getColumn();

        if (row >= board.getSize() || col >= board.getSize()) {
            return false;
        }

        if (row < 0 || col < 0) {
            return false;
        }

        if (!board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            return false;
        }

        return true;
    }

    public void undo() {
        if (moves.size() == 0) {
            System.out.println("No moves to undo");
            return;
        }

        Move lastMove = moves.get(moves.size() - 1);
        moves.remove(lastMove);
        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        nextPlayerMoveIndex -= 1;
        nextPlayerMoveIndex = (nextPlayerMoveIndex + players.size() % players.size());

        for (WinningStrategy winningStrategy: winningStrategies) {
            winningStrategy.handleUndo(board, lastMove);
        }
    }

    public void makeMove() {
        Player currentMovePlayer = players.get(nextPlayerMoveIndex);
        System.out.println("It's " + currentMovePlayer.getName() + "'s turn. Please make your move.");
        
        Move currentMove = currentMovePlayer.makeMove(board);

        if (!validateMove(currentMove)) {
            System.out.println("Invalid Move! Please try again.");
            return;
        }

        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getColumn();
        Cell cellToBeUpdated = board.getBoard().get(row).get(col);
        cellToBeUpdated.setCellState(CellState.FILLED);
        cellToBeUpdated.setPlayer(currentMovePlayer);

        Move finalMoveObject = new Move(cellToBeUpdated, currentMovePlayer);
        moves.add(finalMoveObject);
        
        nextPlayerMoveIndex += 1;
        nextPlayerMoveIndex %= players.size();

        if (checkWinner(board, finalMoveObject)) {
            gameState = GameState.SUCCESS;
            winner = currentMovePlayer;
        } else if (moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
        }
    }

    public  boolean checkWinner(Board board, Move move) {
        for (WinningStrategy winningStrategy: winningStrategies) {
            if (winningStrategy.checkWinner(move, board)) {
                return true;
            }
        }
        
        return false;
    }

    public void printBoard() {
        board.printBoard();
    }

    public Board getBoard() {
        return board;
    }
    
    public void setBoard(Board board) {
        this.board = board;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }
    
    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }
    
    public Player getWinner() {
        return winner;
    }
    
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    
    public List<Move> getMoves() {
        return moves;
    }
    
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    
    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }
    
    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
    
    public GameState getGameState() {
        return gameState;
    }
    
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static class Builder {
        int dimension;
        List<Player> players;
        List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for(Player player: players) {
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount += 1;
                }

                if (botCount > 1) {
                    throw new InvalidBotCountException();
                }
            }
        }

        public void validatePlayersCount() throws InvalidPlayerSizeException {
            if (players.size() != dimension - 1) {
                throw new InvalidPlayerSizeException();
            }
        }

        public void validateUniquePlayerSymbol() throws InvalidPlayerSymbolException {
            Set<Character> symbols = new HashSet<>();

            for (Player player: players) {
                char symbol = player.getSymbol().getSymbol();
                if (!symbols.add(symbol)) {
                    // throw new InvalidPlayerSymbolException("Duplicate player symbol found: " + symbol);
                    throw new InvalidPlayerSymbolException();
                }
            }
        }

        public Game build() throws InvalidBotCountException, InvalidPlayerSizeException, InvalidPlayerSymbolException {
            validateBotCount();
            validatePlayersCount();
            validateUniquePlayerSymbol();
            return new Game(this.dimension, this.players, this.winningStrategies);
        }
    }

    public static Builder gameBuilder() {
        return new Builder();
    }
}
