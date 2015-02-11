package com.maxwason;

import Part1.SimpleSorting;
import Part2.Queue;
import Part3.Dequeue;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        testSorting();
//        testQueue();
//        testDequeue();
    }



    private static void testSorting(){
        //initialize array to sort
        int[] inverseArray = {12,10,8,6,1};
        int[] partialArray = {1,10,8,6,12};
        //test bubble sort
        SimpleSorting.bubbleSort(inverseArray);
        SimpleSorting.bubbleSort(partialArray);
        //test selection sort
        SimpleSorting.selectionSort(inverseArray);
        SimpleSorting.selectionSort(partialArray);
        //test insertion sort
        SimpleSorting.insertionSort(inverseArray);
        SimpleSorting.insertionSort(partialArray);
    }

    private static void testQueue(){

        //"normal" queue
        System.out.println("QUEUE NORMAL");
        testQueueNormal();

        //wraparound queue
        System.out.println("QUEUE WRAPAROUND");
        testQueueWraparound();

        //queue with one item in it
        System.out.println("QUEUE SINGLE");
        Queue singleQueue = new Queue(4);
        singleQueue.insert(1);
        singleQueue.display();

        //empty queue
        System.out.println("QUEUE EMPTY");
        new Queue(5).display();
    }

    private static void testQueueWraparound() {
        Queue myQueue = new Queue(3);

        myQueue.insert(4);
        myQueue.remove();
        myQueue.insert(5);
        myQueue.insert(6);
        myQueue.insert(7);
        myQueue.insert(9);

        myQueue.display();
//        myQueue.printUnderlyingArray();

        myQueue.remove();
        myQueue.remove();
        myQueue.remove();

        myQueue.display();
//        myQueue.printUnderlyingArray();
    }

    private static void testQueueNormal() {

        Queue myQueue = new Queue(3);

        myQueue.insert(4);
        myQueue.remove();
        myQueue.insert(6);
        myQueue.insert(7);

        myQueue.display();
//        myQueue.printUnderlyingArray();
    }

    private static void testDequeue(){

        //"normal" dequeue
        System.out.println("DEQUEUE NORMAL");
        testDequeueNormal();

        //wraparound dequeue
        System.out.println("DEQUEUE WRAPAROUND");
        testDequeueWraparound();

        //dequeue with one item in it
        System.out.println("DEQUEUE SINGLE");
        Dequeue singleQueue = new Dequeue(4);
        singleQueue.insertRight(1);
        singleQueue.display();

        //empty dequeue
        System.out.println("DEQUEUE EMPTY");
        new Dequeue(5).display();
    }


    private static void testDequeueNormal(){
        Dequeue dequeue = new Dequeue(3);
        dequeue.insertRight(1);
        dequeue.printUnderlyingArray();
        dequeue.insertRight(2);
        dequeue.printUnderlyingArray();
        dequeue.insertLeft(3);
        dequeue.printUnderlyingArray();
        dequeue.display();
    }

    private static void testDequeueWraparound(){
        Dequeue dequeue = new Dequeue(3);
        dequeue.insertLeft(1);
        dequeue.printUnderlyingArray();
        dequeue.insertLeft(2);
        dequeue.printUnderlyingArray();
        dequeue.insertLeft(3);
        dequeue.printUnderlyingArray();
        dequeue.removeRight();
        dequeue.printUnderlyingArray();
        dequeue.insertLeft(5);
        dequeue.printUnderlyingArray();
        dequeue.display(); //should be 5,3,2 some error with remove and the pointers
    }
}
