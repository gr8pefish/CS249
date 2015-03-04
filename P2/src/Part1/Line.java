package Part1;

import Part2.Queue;

import java.util.Random;

public class Line {

    private Queue customers;
    private int maxLineLength;
    private int currentLineLength;
    private Random randomNumber;

    public Line(int lineLength){
        maxLineLength = lineLength;
        customers = new Queue(lineLength);
        randomNumber = new Random();
    }

    public boolean addCustomer(){
        if (!isFull()) {
            customers.insert(randomNumber.nextInt(10) + 1); //generates a random number between 1 and 10
            currentLineLength++;
            return true;
        }else{
            return false;
        }
    }

    //since customers are designated by only their number of items it would always return 0 and is therefore unnecessary to have a return value here
    public boolean removeCustomer(){
        if (!isEmpty()) {
            customers.remove();
            currentLineLength--;
            return true;
        }else{
            return false;
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

    public void tick(){
        if (!isEmpty()){
            long items = customers.peek();
            if (items > 1)
                customers.changeFront(--items);
            else
                removeCustomer();
        }
    }

}
