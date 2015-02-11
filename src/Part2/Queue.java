package Part2;

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

    public void insert(long toInsert){
        if (rear == maxSize - 1) rear = -1;
        queueArray[++rear] = toInsert;
        numberItems++;
        //constant time
    }

    public long remove(){
        long temp = queueArray[front++];
        if (front == maxSize) front = 0;
        numberItems--;
        return temp;
        //constant time

    }

    public long peek(){
        return queueArray[front];
        //constant time
    }

    public boolean isEmpty(){
        return (rear+1==front || (front+maxSize-1==rear));
        //constant time
    }

    public boolean isFull(){
        return (rear+2==front || (front+maxSize-2==rear));
        //constant time
    }

    public int size(){
        if (rear >= front)
            return rear-front+1; //continuous
        else
            return (maxSize-front) + (rear+1); //wraparound
        //constant time
    }

    public void display(){
        if (numberItems > 0) {
            if (rear >= front) {
                System.out.print("Queue contents: ");
                print(front, rear);
                System.out.println("");
            } else {
                System.out.print("Queue contents: ");
                print(front, queueArray.length - 1);
                if (rear >= 0) System.out.print(", ");
                print(0, rear);
                System.out.println("");
            }
        }else{
            System.out.print("Queue is empty.\n");
        }
        //O(n) if inner loops runs, otherwise constant time
    }

    private void print(int startIndex, int endIndex){
        if (startIndex == -1) startIndex = 0; //for corner cases
        for (int i = startIndex; i <= endIndex; i++){
            if (queueArray[i] != 0) { //empty spot
                System.out.print(queueArray[i]);
                if (!(i >= endIndex)){
                    System.out.print(", ");
                }
            }
        }
        //O(n)
    }

    public void printUnderlyingArray(){
        System.out.println("Underlying array: ");
        for (long element : queueArray){
            System.out.print(element);
        }
        System.out.println("");
        //O(n)
    }

}
