package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	// Custom class to check if any cell is available or not
    public static class Cell {
        public int row;
        public int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }
    
    // piece ko board pe add karne ke liye
    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if (board[row][column] != null) {
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }
    
    // hmko btana hoga ki kon kon sa cell khali h
    public List<Cell> getFreeCells() {
        List<Cell> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Cell rowColumn = new Cell(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }
    
    // board ke print karbana hoga ek ek move ke bad
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}