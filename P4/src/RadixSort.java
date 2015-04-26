
package src;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Radix sorting algorithm.
 *
 * @author - Max Wason
 * @version - 1.0
 * @since  - 4/15/15
 *
 */
public class RadixSort {

    private static LinkedList<Integer> zeroes = new LinkedList<Integer>(); //linked list for every category of digits
    private static LinkedList<Integer> ones = new LinkedList<Integer>();
    private static LinkedList<Integer> twos = new LinkedList<Integer>();
    private static LinkedList<Integer> threes = new LinkedList<Integer>();
    private static LinkedList<Integer> fours = new LinkedList<Integer>();
    private static LinkedList<Integer> fives = new LinkedList<Integer>();
    private static LinkedList<Integer> sixes = new LinkedList<Integer>();
    private static LinkedList<Integer> sevens = new LinkedList<Integer>();
    private static LinkedList<Integer> eights = new LinkedList<Integer>();
    private static LinkedList<Integer> nines = new LinkedList<Integer>();

    //no constructor used
    public RadixSort() {}

    /**
     * This function sorts via the radix sort. Prints out the array after each iteration as proof it works correctly.
     * @param inputs - an array of integers to sort
     * @param maxSignificantDigits - the number of digits of the largest number in the inputs array
     */
    public void sortLSD(int[] inputs, int maxSignificantDigits) {

        LinkedList[] allDigits = new LinkedList[]{zeroes, ones, twos, threes, fours, fives, sixes, sevens, eights, nines};

        //outer loop to sort all the digits
        for (int currentDigit = 0; currentDigit < maxSignificantDigits; currentDigit++){

            int placeToSort = (int)(Math.pow(10,currentDigit));

            //take data from array and put it on lists
            for (int arrayIndex = 0; arrayIndex < inputs.length; arrayIndex++){

                //get number to sort by
                int originalNumber = inputs[arrayIndex]; //correctly get the digit of interest
                int numberToSortBy = originalNumber;
                if (originalNumber >= placeToSort) { //if larger than the place to sort (looping for each digit)
                    for (int i = 0; i < currentDigit; i++) { //get to the correct index (a 2 digit number)
                        numberToSortBy = originalNumber / placeToSort;
                    }
                    numberToSortBy = numberToSortBy % 10; //then modulus ten to get the remainder
                }else{ //smaller, so add leading zero
                    numberToSortBy = 0;
                }

                //put it in the correct list
                allDigits[numberToSortBy].add(inputs[arrayIndex]);

            }

            int outputIndexCounter = 0;
            //take data from lists and put it in array. Also clears the lists.
            for (LinkedList list : allDigits){
                int listSize = list.size();
                for (int i = 0; i < listSize; i++){
                    inputs[outputIndexCounter] = (Integer)list.removeFirst(); //put back in correct order, also clears linked list
                    outputIndexCounter++;
                }

            }
            System.out.println("After sorting "+placeToSort+"'s place: "+Arrays.toString(inputs));
        }

    }
}