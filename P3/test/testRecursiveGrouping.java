package test;

import src.RecursiveGrouping;

/**
  * Test Class for RecrusiveGrouping
  * <p>
  * Tests Extrema and average cases
  *
  * @author Max Wason
  * @version 1.0
  * @since Always
  *
*/
public class testRecursiveGrouping {

    /**
     * Main method calls test methods that you must build 
     * that satisfy at least the criteria listed in comments below
     * @param args None
     */
    public static void main(String[] args) {

        String[] inputs = {"0", "1"}; //indices refer to n and k, respectively

        //test bad player size (none)
        System.out.println("\nInvalid player size, none");
        RecursiveGrouping.main(inputs);

        //test bad player size (too large)
        inputs[0] = "38"; //numPlayers
        inputs[1] = "1"; //group size
        System.out.println("\nInvalid player size, too large");
        RecursiveGrouping.main(inputs);

        //test bad group size(too large)
        inputs[0] = "1";
        inputs[1] = "100";
        System.out.println("\nInvalid group size, too large");
        RecursiveGrouping.main(inputs);

        //test bad group size (none)
        inputs[0] = "1";
        inputs[1] = "0";
        System.out.println("\nInvalid group size, none");
        RecursiveGrouping.main(inputs);

        //test single group
        inputs[0] = "0";
        inputs[1] = "1";
        System.out.println("\nSingle group (but no players, so it will still throw an error)");
        RecursiveGrouping.main(inputs);

        //test single group, single player
        inputs[0] = "1";
        inputs[1] = "1";
        System.out.println("\nSingle group, single player");
        RecursiveGrouping.main(inputs);

        //test 6 players groups 2 (As in project description).
        inputs[0] = "6";
        inputs[1] = "2";
        System.out.println("\n6 players group 2");
        RecursiveGrouping.main(inputs);

        //test 26 players, groups of 7
        inputs[0] = "26";
        inputs[1] = "7";
        System.out.println("\n26 players group 7");
//        RecursiveGrouping.main(inputs);
    }
}
