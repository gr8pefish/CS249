package src;

/**
 * <H1>Recrusive Grouping</H1>
 * <p>
 * Models n Choose k combinatorics.
 * <p>
 * Executes under a main method and thus can be called and tested directly.
 *
 * @author      Max Wason
 * @version     1.0
 * @since       The present
 */
public class RecursiveGrouping {

    private static String players;
    private static int groupsize;

    /**
     * Main method, takes number of players and group size as arguments
     * @param args [0]= int players>0 && <26, [1] = int group size>0 && <=players
     */
    public static void main(String[] args){

        int numPlayers = Integer.valueOf(args[0]); //n
        groupsize = Integer.valueOf(args[1]); //k

        if (numPlayers <= 26 && groupsize <= numPlayers && groupsize > 0) { //need to have n be 26 or less and k must be positive and less than n

            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String group = alphabet.substring(0, numPlayers); //get the subset of letters to choose from

            if (group.length() == groupsize) //only one solution if they are identical
                System.out.println("Only solution: "+group);
            else
                recGroup(group, "", groupsize);

        }else
            System.out.println("Invalid arguments");
    }

    /**
     * Recursive solution to print out all the combinations.
     *
     * @param group - the subset of letters ot choose from
     * @param resultingString - the end result string
     * @param size - the number of letters left to choose to complete the group
     */
    private static void recGroup(String group, String resultingString, int size) {
        if (group.length() < size)  //can't have grouping bigger than the size
            return;
        else if (size == 0) //base case, print the result
            System.out.println(resultingString);
        else {
            recGroup(group.substring(1), resultingString + group.charAt(0), size - 1); //case 1: in solution, keep going by adding result to the string and decrementing the numberOfItems left
            recGroup(group.substring(1), resultingString, size); //case 2: wrong result, try again by automatically choosing the next element and keeping the size and resultingString the same (not decrementing)
        }
    }

}

