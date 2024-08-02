package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Symbol;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{

    HashMap<Integer, HashMap<Symbol,Integer>> colHashMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {

        int col =move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!colHashMaps.containsKey(col)) {
            colHashMaps.put(col, new HashMap<Symbol, Integer>());
        }
        HashMap<Symbol,Integer> hm = colHashMaps.get(col);
        if(!hm.containsKey(symbol)){
            hm.put(symbol,0);
        }
        hm.put(symbol,hm.get(symbol)+1);
        int count = hm.get(symbol);

        return count == board.getDimension();

    }
}
