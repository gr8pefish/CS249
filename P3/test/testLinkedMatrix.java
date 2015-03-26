package test;


import src.LinkedMatrix;

/**
 * TestClass for LinkedMatrix
 * Provides Unit-testing for LinkedMatrix
 *
 * @author      Max Wason
 * @version     1.0
 * @since       Now
 */
public class testLinkedMatrix {
    private static LinkedMatrix matrix;

    public static void main(String[] args){
        matrix = new LinkedMatrix(3,3);

        testDisplay();
            System.out.println();
        testInsert();
            System.out.println();
        testInsertAll();
            System.out.println();
    }

    /**
    * Display method unit test, remember to provide meaningful output
    */
    public static void testDisplay(){
        System.out.println(matrix.display());
    }
    
    /**
     * Tests the insertion. Only one case here as the App allows more testing.
    */
    public static void testInsert(){
        System.out.println("Should insert the number 3 into the 2nd (bottom) row and the 1st (middle) column (because indices start counting at 0). \n");
        matrix.insert(3, 2, 1);
        testDisplay();
    }

    /**
     * Tests inserting into every spot. Only one case here as the App allows more testing.
     */
    public static void testInsertAll(){
    System.out.println("Should insert the number 19 into every spot. \n");
        matrix.insert(19);
        testDisplay();
    }
}
