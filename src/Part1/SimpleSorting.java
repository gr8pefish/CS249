package Part1;

public class SimpleSorting {

    private static int accessCounter = 0;
    private static int assignmentCounter = 0;

    public static void bubbleSort(int[] intArray) {

        //set the counters back to 0
        accessCounter = 0;
        assignmentCounter = 0;

        int arrayLength = intArray.length;
        for (int i = 0; i < arrayLength; i++) {

            for (int j = 1; j < (arrayLength - i); j++) { //decrease by one to remove invariant
                accessCounter += 2; // j-1 , j
                if (intArray[j - 1] > intArray[j]){
                    //swap the elements and increment the counter accordingly
                    assignmentCounter += swap(intArray, j, j-1); //increments by the return value (3)
                    accessCounter += 4; //4 instances of array access
                }
            }
        }
        printSortedArray(intArray, "Bubble Sort");
        System.out.println("Access Counter: "+accessCounter);
        System.out.println("Assignment Counter: "+assignmentCounter);
        //O(n^2)
    }

    public static void selectionSort(int[] intArray) {
        //set the counters back to 0
        accessCounter = 0;
        assignmentCounter = 0;

        int arrayLength = intArray.length;
        for (int i = 0; i < arrayLength - 1; i++) { //decrease by one to remove invariant

            // Find the index of the minimum value
            int minPos = i;
            for (int j = i + 1; j < arrayLength; j++) {
                accessCounter +=2;
                if (intArray[j] < intArray[minPos]) {
                    minPos = j;
                    assignmentCounter ++; // minPos = j
                }
            }
            //swap the elements and increment the accessCounter accordingly
            assignmentCounter += swap(intArray, minPos, i);
            accessCounter += 4;
        }
        printSortedArray(intArray, "Selection Sort");
        System.out.println("Access Counter: "+accessCounter);
        System.out.println("Assignment Counter: "+assignmentCounter);
        //O(n^2)
    }

    public static void insertionSort(int[] intArray){
        //set the counters back to 0
        accessCounter = 0;
        assignmentCounter = 0;

        int out;
        for (out = 1; out < intArray.length; out++){//start at one because a list of one element is already sorted

            int temp = intArray[out];
            int in = out;
            assignmentCounter += 2;

            accessCounter ++;
            while(in > 0 && intArray[in-1] >= temp){

                intArray[in] = intArray[in-1];
                in--;
                accessCounter += 2;
                assignmentCounter += 2;

            }

            intArray[in] = temp;
            accessCounter++;
            assignmentCounter++;
        }
        printSortedArray(intArray, "Insertion Sort");
        System.out.println("Access Counter: "+accessCounter);
        System.out.println("Assignment Counter: "+assignmentCounter);
        //O(log n)
    }

    private static int swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return 3; //number of changes
    }

    private static void printSortedArray(int[] array, String type){
        System.out.println("\nSorted Array "+"("+type+"):");
        for (int value : array){
            System.out.print(value + ", ");
        }
        System.out.println("");
    }

}
