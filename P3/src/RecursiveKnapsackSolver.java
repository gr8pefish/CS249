package src;

import java.util.Arrays;

/**
 * <H1>The Recursive Knapsack (of doom)</H1>
 * Recursively creates solutions for the 0-1 Knapsack Problem.
 * 
 *
 * @author 
 * @version 
 * @since 
 */
public class RecursiveKnapsackSolver {
    private static int[] weight_set; //array of int values as weights for the knapsack
    private static int[] sol; //integer array of the solution set for the knapsack
    private static int targ_weight; //the maximum capacity of the knapsack

    public RecursiveKnapsackSolver() { //null constructor, static classes don't need to be initialized
    }

    /**
     * Public call to recursion over 1-0 Knapsack problem variant.
     *
     * @param weights the set of weights for recursive combinations
     * @param start the array location to begin at for a set of recursive calls, increments to exclude weights
     * @param targetweight the remaining target weight for each recursive call, decrements as weights are 'selected'
     * @return boolean returns true if a (one is enough) perfect solution is found, false otherwise
     */
    public static boolean knapsackRecursive(int[] weights, int start, int targetweight) {
        return bagSolve(weights, start);
    }

    /**
     * Private method which recursively investigates an integer array versus a target weight.
     *
     * @param
     * @param
     * @return
     */
    private static boolean bagSolve(final int[] weights, final int recap) { //TODO: change params?
        return false;
    }
}

//note, you can make a private helper class if you like, to support the public call

