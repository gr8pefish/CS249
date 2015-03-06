package Part2;

import java.util.ArrayList;

public class CircularSinglyLinkedNode <T> {

    private T data;
    private CircularSinglyLinkedNode<T> next;

    /**
     * Abstract node class that holds one data elements
     * @param dataElement - the data held
     */
    public CircularSinglyLinkedNode(T dataElement){
        data=dataElement;
    }

    //Return data object
    public T getData(){
        return data;
    }

    //Returns all data as an ArrayList (since this node only has one piece of data it isn't too useful, but for other nodes with more data it can be)
    public ArrayList<T> getAllData(){
        ArrayList temp = new ArrayList();
        temp.add(data);
        return temp;
    }

    //Set data object
    public void setData(T input){
        data = input;
    }

    //Return next node
    public CircularSinglyLinkedNode<T> getNext(){
        return next;
    }

    //Set next node
    public void setNext(CircularSinglyLinkedNode<T> inputNode){
        next = inputNode;
    }

    //Return data
    public String toString(){
        return data.toString();
    }

}

