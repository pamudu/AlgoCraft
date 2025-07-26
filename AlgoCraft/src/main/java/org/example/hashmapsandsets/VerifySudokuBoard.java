package org.example.hashmapsandsets;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

/*
 Given a partially completed 9x9 Sudoku board, determine if the current state of the board
adheres to the rules of the game:
• Each row and column must contain unique numbers between 1 and 9, or be empty
(represented as 0).
• Each of the nine 3x3 subgrids that compose the grid must contain unique numbers
between 1 and 9, or be empty.
Note: You are asked to determine whether the current state of the board is valid given
these rules, not whether the board is solvable.
* */
public class VerifySudokuBoard {

    public static void main(String[] args) {
        List<List<Integer>> board = null;

    }

    public static boolean findDuplicates(List<List<Integer>> board){

        /*
         Create hash sets for each row, column, and subgrid to keep
         track of numbers previously seen on any given row, column, or
         subgrid.
         */

        @SuppressWarnings("unchecked")
        HashSet<Integer>[] rowSets = IntStream.range(0,9)
                .mapToObj((i -> new HashSet<Integer>()))
                .toArray(HashSet[]::new);

        @SuppressWarnings("unchecked")
        HashSet<Integer>[] columnSets = IntStream.range(0,9)
                .mapToObj((i -> new HashSet<Integer>()))
                .toArray(HashSet[]::new);

        @SuppressWarnings("unchecked")
        HashSet<Integer>[][] subGridSets = IntStream.range(0,3)
                .mapToObj(i -> IntStream.range(0,3)
                        .mapToObj(j -> new HashSet<Integer>())
                        .toArray(HashSet[]::new))
                .toArray(HashSet[][]::new);


        for(int r=0; r<9; r++) {
            for (int c = 0; c < 9; c++) {
                int number = board.get(r).get(c);
                if (number == 0) {
                    continue;
                }
                /*
                     Check if 'num' has been seen in the current row,
                     column, or subgrid.
                 */
                else if (rowSets[r].contains(number)) {
                    return false;
                } else if (columnSets[c].contains(number)) {
                    return false;
                }else if(subGridSets[r/3][c/3].contains(number)){
                    return false;
                }
                /*
                    If we passed the above checks, mark this value as seen
                    by adding it to its corresponding hash sets.
                */
                else{
                    rowSets[r].add(number);
                    columnSets[c].add(number);
                    subGridSets[r/3][c/3].add(number);
                }
            }
        }
        return true;
    }
}
