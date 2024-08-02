package TicTacToe.Models;

import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidMoveException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    private List<WinningStrategy> winningStrategies;


    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void makeMove(Game game) throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("It is "+currentPlayer.getName()+"'s turn :");
        Move move = currentPlayer.makeMove(board);

        if(!validateMove(move)){
            throw new InvalidMoveException("invalid move");
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move finalMove = new Move(currentPlayer,cell);
        moves.add(finalMove);

        nextPlayerMoveIndex = (nextPlayerMoveIndex+1) % (board.getDimension()-1);
        if(checkWinner(move, board)){
            winner = currentPlayer;
            game.setGameState(GameState.ENDED);
        }
        else if(moves.size()==board.getDimension() * board.getDimension()){
            game.setGameState(GameState.DRAW);
        }

    }

    private boolean checkWinner(Move move, Board board) {
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(move, board)){
                return true;
            }

        }
        return false;
    }

    private Boolean validateMove(Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        if( row >= board.getDimension() || row<0 || col<0 || col >= board.getDimension()){
            return false;
        }
        Cell cell = board.getBoard().get(row).get(col);
        CellState cellState = cell.getCellState();
        if(cellState.equals(CellState.FILLED)){
            return false;
        }
        return true;
    }

    public void printBoard(Game game) {
        board.print();
    }

    public static class Builder{
        private int dimention;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimention(int dimention) {
            this.dimention = dimention;
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
            for(Player player : players){
                if(player.getPlayerType() == PlayerType.BOT){
                    botCount = botCount + 1;
                }
            }
            if(botCount>1){
                throw new InvalidBotCountException("Count of bots are more then one");
            }
        }

        public void validatePlayerCount() throws InvalidPlayerCountException {
            if(players.size() != dimention-1){
                throw  new InvalidPlayerCountException("Number of player are not equal to "+(dimention-1)+"");
            }
        }

        public  void validateUniqesymbols(){

        }
        public void validation() throws InvalidBotCountException, InvalidPlayerCountException {
            validateBotCount();
            validatePlayerCount();
        }

        public Game Build() throws InvalidBotCountException, InvalidPlayerCountException {
            validation();
            return new Game(dimention, players, winningStrategies);
        }
    }
}
