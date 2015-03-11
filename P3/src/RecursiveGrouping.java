package src;

/**
 * <H1>Recrusive Grouping</H1>
 * <p>
 * Models n Choose k combinatorics.
 * <p>
 * Executes under a main method and thus can be called and tested directly.
 *
 * @author      First Last fll23@nau.edu
 * @version     1.0
 * @since       00-00-2015
 */
public class RecursiveGrouping {

    private static String players="";
    private static int groupsize;

    /**
     * Main method, takes number of players and group size as arguments
     * @param args [0]= int players>0, [1] = int group size>0
     */
    public static void main(String[] args){
       
    }

    /**
     * Static method to recursively display desired team groupings.
     * @param 
     * @param 
     * @return 
     */
    private static String showTeams(int size, int current){
        if (size == 0){ //base case
            return players;
        }else if (current > size) { //can't have teams bigger than the size
            return players;
        }
        showTeams(size-1, current);
        return null;
    }
}
