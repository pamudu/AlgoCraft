package org.example.hashMapsAndSets;

import java.util.HashSet;
import java.util.List;

public class ZeroStriping {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> zeroStripingHashSets(List<List<Integer>> matrix){
        if(matrix==null || matrix.isEmpty()){
            return null;
        }
        int m = matrix.size();
        int n = matrix.get(0).size();

        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroColumns = new HashSet<>();

        // Pass 1: Traverse through the matrix to identify the rows and columns containing zeros and
        // store their indexes in the appropriate hash sets.

        for(int row=0; row<m; row++){
            for(int col=0; col < n; col++){
                if(matrix.get(row).get(col) == 0){
                    zeroRows.add(row);
                    zeroColumns.add(col);
                }

            }
        }

        // Pass 2: Set any cell in the matrix to zero if its row index is in 'zeroRows' or its
        // column index is in 'zeroColumns'

        for(int row=0; row<m; row++){
            for(int col=0; col < n; col++) {
                if(zeroRows.contains(row) || zeroColumns.contains(col)){
                    matrix.get(row).set(col,0);
                }
            }
        }
        return matrix;
    }
}
