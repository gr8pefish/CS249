package Part3;

public class Dequeue {

    private int[] dequeueArray;
    private int front;
    private int rear;
    private int numberItems;

    public Dequeue(int size){
        dequeueArray = new int[size];
        front = 0;
        rear = -1;
        numberItems = 0;
    }

    public boolean insertLeft(int insert){
        if (isFull())
            return false;
        else {
            if (front == 0) front = dequeueArray.length;
            dequeueArray[--front] = insert;

            numberItems++;
            return true;
        }
        //constant time
    }

    public boolean insertRight(int insert){
        if (isFull())
            return false;
        else {
            if (rear == dequeueArray.length - 1) rear = -1;
            dequeueArray[++rear] = insert;

            numberItems++;
            return true;
        }
        //constant time
    }

    public int removeLeft(){
        if (numberItems > 0) {
            //remove
            int temp = dequeueArray[--front];
            if (front == dequeueArray.length -1) front = -1;
            front++;

            numberItems--;
            return temp;
        }else
            return 0;
        //constant time
    }

    public int removeRight(){
        if (numberItems > 0) {
            //remove
            int temp = dequeueArray[++rear];
            if (rear == 0) rear = dequeueArray.length-1;
            rear--;

            numberItems--;
            return temp;
        }else
            return 0;
        //constant time
    }

    public boolean isEmpty(){
        return numberItems == 0;
        //constant time
    }

    public boolean isFull(){
        return numberItems == dequeueArray.length;
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
                print(front, dequeueArray.length - 1);
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
            if (dequeueArray[i] != 0) { //empty spot
                System.out.print(dequeueArray[i]);
                if (!(i >= endIndex)){
                    System.out.print(", ");
                }
            }
        }
        //O(n)
    }

    public void printUnderlyingArray(){
        System.out.println("Underlying array: ");
        for (long element : dequeueArray){
            System.out.print(element);
        }
        System.out.println("");
        //O(n)
    }

}
