package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given an array of integers, return all triplets (a, b, c] such that a + b + c = 0. The
solution must not contain duplicate triplets (e.g., [ 1, 2, 3] and [ 2, 3, 1] are considered
duplicate triplets), If no sud! triptets are found, return an empty array.
Each triplet can be arranged in any order:, and the output can be returned in any order .
Example:
         Input nums = (0, -1, 2, -3, 1)
         Output [(-3, 1, 2], [-1, 0, ll]

*/
public class TripletSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-4, -4, -2, 0, 0, 1, 2, 3 );
        // (-1, 2, -2, 1, -1, 2)
        // (-4, -4, -2, 0, 0, 1, 2, 3 )
        findTriplets(numbers);
    }

    public static void findTriplets(List<Integer> numbers){
        Collections.sort(numbers);
        List<List<Integer>> triplets = new ArrayList<>();

        // Let's fix one element(a) each time and find another two elements b and c ; b+c = -a
        for(int i=0; i < numbers.size()-3; i++){
            int a = numbers.get(i);

            int bIndex = i+1;
            int cIndex = numbers.size()-1;

            if(i > 0 && a != numbers.get(i-1) || i == 0) {
                while (bIndex < cIndex) {
                    int b = numbers.get(bIndex);
                    int c = numbers.get(cIndex);
                    int negativeA = -1 * a;

                    if(i+1 < bIndex && b != numbers.get(bIndex -1) || i+1 == bIndex) {
                        if (b + c == negativeA) {
                            triplets.add(Arrays.asList(a, b, c));
                            bIndex++;
                        } else if (b + c < negativeA) {
                            bIndex++;
                        } else {
                            cIndex--;
                        }
                    }else{
                        bIndex++;
                    }
                }
            }
        }
        for(List<Integer> triplet : triplets){
            System.out.println(triplet);
        }
    }
}
