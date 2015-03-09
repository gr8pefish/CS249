package test;

/**
 * Tests for Recursive Knapsack.
 *
 * @author 
 * @version 
 * @since 
 */
public class testRecursiveKnapsackSolver {

    //Call unit test methods from the main method for testing
    public static void main(String[] args){
        testBadInputs();
        testPerfectPossible();
//	testNoPerfects();	//optional
    }

    //test to ensure your knapsack does not crash if fed bad input values
    private static void testBadInputs(){
    }

    //test to ensure your knapsack will find the perfect solution if there is one (bag is perfectly full)
    //the perfect solution should be chosen over any other possible solution (multiple perfects is not needed)
    private static void testPerfectPossible(){

    }

    //Optional! For and extra challenge make you knapsack return the best possible solution when there is no perfect solution
    //the best solution should be better than any other solution (based on total weight, regardless of the order of appearance)
    private static void testBestPossible(){
    }
}