package Part2;

import java.util.ArrayList;

public class CircularSinglyLinkedNode <T, S> {

    private T first;
    private S second;
    private CircularSinglyLinkedNode<T,S> next;

    /**
     * Abstract node class that holds two data elements
     * @param firstElement
     * @param secondElement
     */
    public CircularSinglyLinkedNode(T firstElement, S secondElement){
        first=firstElement;
        second=secondElement;
    }

    //Return first object
    public T getFirst(){
        return first;
    }

    //Return second object
    public S getSecond(){
        return second;
    }

    //Returns all data as an ArrayList
    public ArrayList<T> getAllData(){
        ArrayList temp = new ArrayList();
        temp.add(first);
        temp.add(second);
        return temp;
    }

    //Set first object
    public void setFirst(T input){
        first = input;
    }

    //Set second object
    public void setSecond(S input){
        second = input;
    }

    //Return next node
    public CircularSinglyLinkedNode<T,S> getNext(){
        return next;
    }

    //Set next node
    public void setNext(CircularSinglyLinkedNode<T,S> inputNode){
        next = inputNode;
    }

    //Return objects as a pair such as (X,Y)
    public String toString(){
        return "(" + first + "," + second + ")";
    }

}

