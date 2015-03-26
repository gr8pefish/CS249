package test;

import src.RecursiveKnapsackSolver;

/**
 * Tests for Recursive Knapsack.
 *
 * @author Max Wason
 * @version 1.0
 * @since the present
 */
public class testRecursiveKnapsackSolver {

    private static int[] arrayOne = {1,2,3,4,5,6,7}; //sorted
    private static int[] arrayTwo = {5,2,3,4,0}; //random
    private static int[] arrayThree = {5,4,3}; //reverse sorted
    private static int[] arrayFour = {1,5,8,4,13,46}; //random
    private static int[] arrayFive = {4,3}; //reverse sorted
    private static int[][] arrays = {arrayOne, arrayTwo, arrayThree, arrayFour, arrayFive};

    //Call unit test methods from the main method for testing
    public static void main(String[] args){
        System.out.println("\nTesting bad inputs\n");
        testBadInputs();
        System.out.println("\nTesting perfects\n");
        testPerfectPossible();
        System.out.println("\nTesting no perfects\n");
        testNoPerfects();
        System.out.println("\nTesting general cases\n");
        testGeneral();
    }

    //test to ensure your knapsack does not crash if fed bad input values
    private static void testBadInputs(){
        RecursiveKnapsackSolver.knapsackRecursive(new int[]{}, 0, 1); //empty weight set. Returns error message.
        RecursiveKnapsackSolver.knapsackRecursive(new int[]{1,2}, -453453, 3); //start parameter is unused, so it is impossible to break using it. Returns normal output.
        RecursiveKnapsackSolver.knapsackRecursive(new int[]{1,2}, 0, -20); //negative target weight. Returns error message.
    }

    //test to ensure your knapsack will find the perfect solution if there is one (bag is perfectly full)
    //the perfect solution should be chosen over any other possible solution (multiple perfects is not needed)
    private static void testPerfectPossible(){
        RecursiveKnapsackSolver.knapsackRecursive(arrayOne, 0, 7);
        RecursiveKnapsackSolver.knapsackRecursive(arrayOne, 0, 14);
        RecursiveKnapsackSolver.knapsackRecursive(arrayOne, 0, 10);
        RecursiveKnapsackSolver.knapsackRecursive(arrayTwo, 0, 6);
        RecursiveKnapsackSolver.knapsackRecursive(arrayTwo, 0, 12);
        RecursiveKnapsackSolver.knapsackRecursive(arrayTwo, 0, 9);
    }

    //test to ensure that your knapsack will not find a solution when there is no perfect solution
    private static void testNoPerfects(){
        RecursiveKnapsackSolver.knapsackRecursive(arrayOne, 0, 123);
        RecursiveKnapsackSolver.knapsackRecursive(arrayThree, 0, 6);
        RecursiveKnapsackSolver.knapsackRecursive(arrayFour, 0, 45);
        RecursiveKnapsackSolver.knapsackRecursive(arrayTwo, 0, 13);
        RecursiveKnapsackSolver.knapsackRecursive(arrayTwo, 0, 1);
        RecursiveKnapsackSolver.knapsackRecursive(arrayTwo, 0, 19);
    }

    //tests a variety of general cases. Should be more than sufficient to prove it works.
    private static void testGeneral() {
        for (int[] array : arrays) {
            for (int i = 1; i < 14; i += 3) {
                RecursiveKnapsackSolver.knapsackRecursive(array, 0, i);
            }
        }
    }
}

