package P1.Part2;

/**
 * Queue class from Project 1
 */
public class Queue {

    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int numberItems;

    public Queue(int size){
        maxSize = size+1;
        queueArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    /**
     * Inserts an item into the queue
     * @param toInsert - a long data element
     */
    public void insert(long toInsert){
        if (rear == maxSize - 1) rear = -1; //alter the rear pointer if necessary (wraparound)
        queueArray[++rear] = toInsert;
        numberItems++;
        //O(1) efficiency (no looping)
    }

    /**
     * Removes an item from the queue
     * @return - the long data element removed, or null
     */
    public long remove(){
        long temp = queueArray[front++];
        if (front == maxSize) front = 0; //alter the front pointer if necessary (wraparound)
        numberItems--;
        return temp;
        //O(1) efficiency (no looping)

    }

    public long peek(){
        return queueArray[front];
        //O(1) efficiency (no looping)
    }

    public boolean isEmpty(){
        return (rear+1==front || (front+maxSize-1==rear)); //alternatively, return (numberItems <= 0);
        //O(1) efficiency (no looping)
    }

    public boolean isFull(){
        return (rear+2==front || (front+maxSize-2==rear)); //alternatively, return (numberItems >= queueArray.length);
        //O(1) efficiency (no looping)
    }

    public int size(){
        if (rear >= front)
            return rear-front+1; //continuous
        else
            return (maxSize-front) + (rear+1); //wraparound
        //O(1) efficiency (no looping)
    }

    public void changeFront(long newNumber){
        queueArray[front] = newNumber;
    }

    /**
     * Displays all the items in the queue
     */
    public void display(){
        if (numberItems > 0) {
            if (rear >= front) {
                System.out.print("Queue contents: ");
                print(front, rear);
                System.out.println("");
                //O(n) efficiency due to print() running
            } else {
                System.out.print("Queue contents: ");
                print(front, queueArray.length - 1);
                if (rear >= 0) System.out.print(", ");
                print(0, rear);
                System.out.println("");
                //O(2n) efficiency due to print() running twice
            }
        }else{
            System.out.print("Queue is empty.\n");
            //O(1) efficiency
        }
        //O(2n) as worst case efficiency
    }

    /**
     * Helper method for display
     * @param startIndex - where to start printing in the queue
     * @param endIndex - where to end printing in the queue
     */
    private void print(int startIndex, int endIndex){
        if (startIndex == -1) startIndex = 0; //circumvents IndexOutOfBoundsExceptions by altering the start point to always be in the array
        for (int i = startIndex; i <= endIndex; i++){
            if (queueArray[i] != 0) { //empty spot
                System.out.print(queueArray[i]);
                if (!(i >= endIndex)){
                    System.out.print(", "); //just a comma for aesthetics
                }
            }
        }
        //O(n), because loop from startIndex to endIndex (so n times)
    }

    public void printUnderlyingArray(){
        System.out.println("Underlying array: ");
        for (long element : queueArray){
            System.out.print(element);
        }
        System.out.println(""); //new line for aesthetics
        //O(n), because loop through every item in the queueArray
    }

}
