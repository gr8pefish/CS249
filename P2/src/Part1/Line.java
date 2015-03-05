package Part1;

import Part2.Queue;

import java.util.Random;

public class Line {

    private Queue customers;
    private int maxLineLength;
    private int currentLineLength;
    private Random randomNumber;

    /**
     * Creates a line object, or a queue of customers (designated by an integer representing the number of items they have)
     * @param lineLength - how long the line can be
     */
    public Line(int lineLength){
        maxLineLength = lineLength;
        customers = new Queue(lineLength);
        randomNumber = new Random();
    }

    /**
     * Adds a customer (designated by a randomly generated number of items) to the line
     * @return true if you can add a customer, false if you cannot
     */
    public boolean addCustomer(){
        if (!isFull()) {
            customers.insert(randomNumber.nextInt(10) + 1); //generates a random number between 1 and 10
            currentLineLength++;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Removes the customer that is first in the queue/line
     *
     * Note: Since customers are designated by only their number of items it would always return 0 and is therefore unnecessary to have a numerical return value here
     * @return true if you can remove a customer, false if you cannot
     */
    public boolean removeCustomer(){
        if (!isEmpty()) {
            customers.remove();
            currentLineLength--;
            return true;
        }else{
            return false;
        }
    }


    /**
     * Progresses the line by removing one item from the customer at the front.
     * If the customer is out of items they are removed from the line entirely.
     */
    public void tick(){
        if (!isEmpty()){
            long items = customers.peek();
            if (items > 1)
                customers.changeFront(--items);
            else
                removeCustomer();
        }
    }

    public int getCurrentLineLength(){
        return currentLineLength;
    }

    public int getMaxLineLength(){
        return maxLineLength;
    }

    public boolean isEmpty(){
        return customers.isEmpty();
    }

    public boolean isFull(){
        return customers.isFull();
    }

    public void display(){
        customers.display();
    }

}
