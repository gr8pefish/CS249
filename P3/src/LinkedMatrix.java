package src;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * <H1>A 2D Linked-List</H1>
 * <p>
 * Creates the functionality of a linked list with 2-dimensions.
 *
 * @author Max Wason mw834@nau.edu
 * @version 1.0
 * @since 03-09-2015
 */
public class LinkedMatrix {

    private Node2d start; //holds the starting reference (top left)
    private int totalRows; //holds the total number of rows
    private int totalCols; //holds the total number of columns

    private MatrixIterator iterator;

    private String leadZeros="0"; // Optional! holds a value of leading zeros needed (for formatting)
    private String matrixDisplayWithSums = ""; // Optional! holds a string which represents the matrix (for efficient display)
   

    /**
     * Constructs the 2D-Linked List, called a "matrix".
     *
     * @param rows The number of vertical Nodes
     * @param columns The number of horizontal Nodes
     */
    public LinkedMatrix(int rows, int columns) {
        totalRows = rows;
        totalCols = columns;
        initMatrix();
        iterator = new MatrixIterator(this);
    }

    /**
     * Initializes the matrix.
     */
    private void initMatrix(){
        start = new Node2d(0);
        Node2d currNode = start;

//        int currRow = 0;
//        int currCol;

        // 0   1  2
        // 10 11 12
        // 20 21 22
        //then just add in print method if number is only one long

        for (int currRow = 0; currRow < totalRows; currRow++){
            for (int k = 0; k < currRow; k++) {
                currNode = start.getDown();
                System.out.println("going down a row");
            }
            for (int currCol = 0; currCol < totalCols; currCol++){ //Inits columns

                if (currRow == 0) {
                    System.out.println("setting right to " + (oneIntFromTwo(currRow, currCol)));
                    currNode.setRight(new Node2d((oneIntFromTwo(currRow, currCol))));
                }else{
                    System.out.println("Moving right");
                    currNode = currNode.getRight();
                }

                if (currRow != totalRows-1){ //If not bottom row
                    System.out.println("setting down to  "+(oneIntFromTwo(currRow, currCol)));
                    currNode.setDown(new Node2d((oneIntFromTwo(currRow, currCol))));
                }
            }
        }

//        for (MatrixIterator it = new MatrixIterator(this); it.hasNext();) {
//            System.out.println("Item is: " + it.next());
//        }


//        for (int i = 0; i < totalCols; i++){ //Inits columns
//            currNode.setRight(new Node2d(++colCounter * (currRow+1)));
//            if (currRow != totalRows-1){ //If not bottom row
//                currNode.setDown(new Node2d(colCounter * (currRow+2)));
//            }
//            colCounter++;
//        }

    }

    private int oneIntFromTwo(int row, int col){
        return Integer.valueOf(Integer.toString(row) + Integer.toString(col));
    }

    /**
     * Inserts a value at a specific location in the matrix.
     *
     * @param val - The value to insert
     * @param row - starts a 0
     * @param col - starts at 0
     * @return true if can insert, false otherwise
     */
    public boolean insert(Integer val, int row, int col){

        if (row < 0 || row > totalRows){
            System.out.println("Invalid row parameter");
            return false;
        }else if (col < 0 || col > totalCols){
            System.out.println("Invalid col parameter");
            return false;
        }else{
            int counter = 0;
            int desiredVal = col + (row * totalCols);

            Node2d curr = start;
            iterator.reset();
            while(iterator.hasNext()){
                if (counter == desiredVal)
                    break;
                else
                    curr = (Node2d) iterator.next();
                counter++;
            }
            curr.setValue(val);
            return true;
        }
    }

    /**
     * Insert value at all matrix locations.
     *
     * @param val the value to override all matrix positions
     */
    public void insert(Integer val){
        for (int i = 0; i < totalRows; i++){
            for (int j = 0; j < totalCols; j++){
                insert(val, i, j);
            }
        }
    }

    /**
     * Returns a string representation of the matrix without trailing row and column summations.
     *
     * @return a string representation of the matrix
     */
    public String display() {

        String output;

        String[][] strings = new String[totalRows][totalCols];
        Node2d currNode = start;
        for (int i = 0; i < totalRows; i++){
            currNode = currNode.getRight();

            for (int j = 0; j < totalCols; j++){
                currNode = currNode.getDown();
            }
        }

        System.out.println(Arrays.deepToString(strings));
        return null;
    }

    /**
     * Returns a string representation of matrix with summations.
     * @return a string representation of the matrix with row/col sums
     */
    public String displaySummed() {
        return null;
    }

    /**
     * Optional!! If you like a challenge, use regular expressions in this method to format a string
     * for the display method.
     * Private method which updates the string representation of the matrix based on actual values.
     */
    private void updateDisplaySummed() {
        
    }

    /**
     * Private inner class Node2d, represents elements in the 2d Linked List
     */
    private class Node2d {

        private Node2d right;
        private Node2d down;
        private Integer value;

        public Node2d(Integer myvalue){
            value = myvalue; //automatically initializes right and down to null
        }

        public void setRight(Node2d toright){
            right = toright;
        }

        public Node2d getRight(){
            return right;
        }

        public void setDown(Node2d todown){
            down = todown;
        }

        public Node2d getDown(){
            return down;
        }

        @Override
        public String toString(){
            return (Integer.toString(value));
        }

        public void setValue(int value){
            this.value = value;
        }

        public Integer getValue(){
            return value;
        }
    }

    /**
     * Private inner iterator
     */
    private class MatrixIterator implements java.util.Iterator{

        private LinkedMatrix matrix;
        private Node2d currNode;
        private int currRow;

        public MatrixIterator(LinkedMatrix matrix){
            this.matrix = matrix;
            currNode = start;
        }

        @Override
        public boolean hasNext() {
            return (currNode.getRight() != null && currNode.getDown() != null);
        }

        @Override
        public Object next() {
            if (hasNext()) {
                if (currNode.getRight() == null) { // already know it can't be the last node, so get to new node by going down the rows
                    for (int i = 0; i < ++currRow; i++) {
                        currNode = matrix.start.getDown();
                    }
                    return currNode;
                }
            }
            return null;
        }

        @Override
        public void remove() {
            System.out.println("Remove not implemented");
        }

        public void reset(){
            currRow = 0;
            currNode = start;
        }
    }
}
