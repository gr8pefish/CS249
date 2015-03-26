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

        //init start
        start = new Node2d(0);

        //pointers
        Node2d onLeft = start;
        Node2d above;

        for (int currRow = 0; currRow < totalRows; currRow++) {
            if (currRow == 0) { //special handling because no above pointer
                for (int col = 1; col < totalCols; col++){ //start at 1 because already set start node
                    onLeft.setRight(new Node2d(col));

                    //move pointer
                    onLeft = onLeft.getRight();
                }
            } else {
                above = start;
                for (int i = 1; i < currRow; i++) { //start at 1 b/c have to be 1 row higher for above
                    above = above.getDown(); //resets above to the correct row
                }
                for (int col = 0; col < totalCols; col++){
                    if (col == 0){
                        above.setDown(new Node2d(oneIntFromTwo(currRow, col)));

                        //move pointers
                        onLeft = above.getDown();
                        above = above.getRight();
                    }else{
                        Node2d temp = new Node2d(oneIntFromTwo(currRow, col));
                        onLeft.setRight(temp);
                        above.setDown(temp);

                        //move pointers
                        onLeft = onLeft.getRight();
                        above = above.getRight();
                    }
                }
            }
        }
    }

    /**
     * Helper method to get a single two length integer form two ints
     *
     * @param row first int
     * @param col second int
     * @return combined int
     */
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
            Node2d currNode = start;

            for (int i = 0; i < col; i++){
                currNode = currNode.getRight();
            }
            for (int i = 0; i < row; i++){
                currNode = currNode.getDown();
            }

            currNode.setValue(val);
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
        return loopThrough(false);
    }

    private String loopThrough(boolean getTotals){
        String returnString = "";
        Node2d currNode;
        int rowTotal;
        for (int i = 0; i < totalRows; i++){
            currNode = start;
            if (i != 0) {
                returnString += "\n";
                for (int j = 0; j < i; j++) {
                    currNode = currNode.getDown();
                }
            }
            rowTotal = 0;
            for (int k = 0; k < totalCols; k++){
                if (currNode.getValue() < 10)
                    returnString += "0"+Integer.toString(currNode.getValue())+" ";
                else
                    returnString += Integer.toString(currNode.getValue())+" ";
                if(getTotals) rowTotal += currNode.getValue();

                currNode = currNode.getRight();

                //Add the row total to the end (if applicable)
                if (getTotals && k == totalCols-1){
                    returnString += "| ";
                    if (rowTotal < 10)
                        returnString += "0"+Integer.toString(rowTotal)+" ";
                    else
                        returnString += Integer.toString(rowTotal)+" ";
                }
            }
        }

        //Sum up the columns (if applicable)
        int colTotal;
        if (getTotals){
            returnString += "\n";
            for (int i = 0; i < totalCols; i++){
                currNode = start;
                if (i != 0) {
                    for (int j = 0; j < i; j++) {
                        currNode = currNode.getRight();
                    }
                }
                colTotal = 0;
                for (int j = 0; j < totalRows; j++){
                    colTotal += currNode.getValue();

                    currNode = currNode.getDown();

                    if (j == totalRows-1){
                        if (i ==0) {
                            for (int k = 0; k < totalCols; k++) {
                                returnString += "-- "; //Just formatting niceness
                            }
                            returnString += "\n";
                        }
                        if (colTotal < 10)
                            returnString += "0"+Integer.toString(colTotal)+" ";
                        else if (colTotal > 99)
                            returnString += Integer.toString(colTotal);
                        else
                            returnString += Integer.toString(colTotal)+" ";
                    }
                }
            }
        }
        return returnString;
    }

    /**
     * Returns a string representation of matrix with summations.
     * @return a string representation of the matrix with row/col sums
     */
    public String displaySummed() {
        return loopThrough(true);
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
     * Private inner iterator - unused
     * I initially thought I would need this, but discarded it as I thought out the problem more. Leaving it in because it still works.
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
