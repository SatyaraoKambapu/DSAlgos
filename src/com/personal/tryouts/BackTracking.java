package com.personal.tryouts;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate possible paranthesis of given input number
 */
public class BackTracking {
    public static void main(String[] args) {
        BackTracking backTracking = new BackTracking();

        ArrayList<ArrayList<Character>> result =  backTracking.printAllBraces(3);


        backTracking.print(result);

    }

    private ArrayList<ArrayList<Character>> printAllBraces(int n) {
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        printAllBracesRec(n, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void printAllBracesRec(int n, int left, int right, ArrayList<Character> output, ArrayList<ArrayList<Character>> result) {

        if(left >= n && right >= n) result.add((ArrayList<Character>) output.clone());

        if(left <  n) {
            output.add('{');
            printAllBracesRec(n, left+1, right, output, result);
            output.remove(output.size()-1);
        }

        if(right <  left) {
            output.add('}');
            printAllBracesRec(n, left, right+1, output, result);
            output.remove(output.size()-1);
        }

    }

    private void print (ArrayList<ArrayList<Character>> result){

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }

    }
}
