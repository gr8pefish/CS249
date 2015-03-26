package src;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <H1>The Recursive Knapsack (of doom)</H1>
 * Recursively creates solutions for the 0-1 Knapsack Problem.
 *
 * @author Max Wason
 * @version 1.0
 * @since Now
 */
public class RecursiveKnapsackSolver {

    private static int[] weight_set; //array of int values as weights for the knapsack
    private static ArrayList<Integer> sol; //array of the solution set for the knapsack
    private static int targ_weight; //the maximum capacity of the knapsack


    public RecursiveKnapsackSolver() { //null constructor, static classes don't need to be initialized
    }

    /**
     * Public call to recursion over 1-0 Knapsack problem variant.
     *
     * @param weights the set of weights for recursive combinations
     * @param start the array location to begin at for a set of recursive calls, increments to exclude weights (the parameter is unnecessary in the *public* call, but am keeping it so it doesn't ruin your tests)
     * @param targetweight the remaining target weight for each recursive call, decrements as weights are 'selected'
     * @return boolean returns true if a (one is enough) perfect solution is found, false otherwise
     */
    public static boolean knapsackRecursive(int[] weights, int start, int targetweight) {
        weight_set = weights;
        targ_weight = targetweight;
        sol = new ArrayList<Integer>();

        if(targetweight <= 0) {
            System.out.println("targetweight should be a non zero integer");
            return false;
        }
        if(weights == null || weights.length <= 0) {
            System.out.println("weights should include more than 0 items");
            return false;
        }
        boolean fits = knapsackRecursiveHelper(0, 0); //will always start at the first location with a total of 0
        if (fits)
            System.out.println("The items: "+sol.toString()+" add up to the target weight of "+targetweight);
        else
            System.out.println("There is no possible combination of: "+Arrays.toString(weights)+" that adds up to the target weight of "+targetweight);
        return fits;
    }


    /**
     * Private method which recursively investigates an integer array versus a target weight.
     *
     * @param currentSum - the current total of the bag
     * @param start - the location of the weights array to check
     * @return boolean true if the bag can be filled, false otherwise
     */
    private static boolean knapsackRecursiveHelper(int currentSum, int start) {

        if (currentSum == targ_weight) //base case 1: have the correct weight
            return true;
        if (currentSum > targ_weight) //base case 2: used too much weight
            return false;
        if (start >= weight_set.length) //base case 3: used all combinations and incorrect weight
            return false;

        sol.add(weight_set[start]); //add the new item to the set of solutions
        boolean flag = knapsackRecursiveHelper(currentSum + weight_set[start], start + 1); //continue with this "thread"
        if (!flag) { //otherwise, step back, removing the failed number
            sol.remove(sol.indexOf(weight_set[start])); //odd syntax due to array.remove method overloading, need the object which is also an integer
            flag = knapsackRecursiveHelper(currentSum, start + 1); //try again with the next number
        }
        return flag;
    }

}


