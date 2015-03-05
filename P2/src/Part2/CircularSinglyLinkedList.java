package Part2;

import java.util.ArrayList;

public class CircularSinglyLinkedList {

    private CircularSinglyLinkedNode current;
    private int count;

    /**
     * Creates a circular singly linked list
     * Default constructor, nothing to initialize
     */
    public CircularSinglyLinkedList(){}

    /**
     * Inserts a node to the end of the list
     * @param toAdd - the node to add
     */
    public void insert(CircularSinglyLinkedNode toAdd) {
        if (count == 0) {
            toAdd.setNext(toAdd);
            current = toAdd;
        } else if (count == 1) {
            current.setNext(toAdd);
            toAdd.setNext(current);
        } else {
            toAdd.setNext(current.getNext());
            current.setNext(toAdd);
        }
        count++;
    }

    /**
     * Removes the node from the front of the list
     * @return the node if one is removed, null otherwise
     */
    public CircularSinglyLinkedNode remove(){
        if (count == 0){
            return null;
        } else if (count == 1) {
            CircularSinglyLinkedNode temp = current;
            current.setNext(null);
            current = null;
            count = 0;
            return temp;
        } else {
            CircularSinglyLinkedNode temp = current.getNext();
            current.setNext(current.getNext().getNext());
            count--;
            return temp;
        }
    }

    /**
     * Removes a node at the index desired.
     * NOTE: This method alters the current pointer to be the node right after the one removed. Not advised for a typical 'pop' operation.
     * @param index - the numerical index of the node to be removed. Can be larger than the lists' size, as it is circular and will simply loop around
     * @return the node if it could be removed, null otherwise
     */
    public CircularSinglyLinkedNode removeAt(int index){
        if (count == 0){
            return null;
        } else if (count == 1) {
            if (index == 1) {
                CircularSinglyLinkedNode temp = current;
                current.setNext(null);
                current = null;
                count = 0;
                return temp;
            } else
                return null;
        } else if (count == 2) {
//            System.out.println("Index: "+index);
            if (index%2 == 0){ //the modulus determines if the node to be removed is the current node or the other one (since it is just two elements)
                current = current.getNext();
                current.setNext(current);
                count--;
                return current;
            }else if (index%2 == 1){
                current.setNext(null);
                count--;
                return current;
            }else{
                System.out.println("ERROR"); //should be unreachable
                return null;
            }
        } else {
            CircularSinglyLinkedNode temp = current.getNext();
            if (index == 1){
                current.setNext(current.getNext().getNext());
                count--;
                return temp;
            }else{
                for (int i = 0; i < index - 1; i++) { //have to iterate until the correct location is reached
                    current = current.getNext();
                }
                temp = current.getNext();
                current.setNext(current.getNext().getNext());
                count--;
                return temp;
            }
        }
    }


    public CircularSinglyLinkedNode getCurrent(){ return current; }

    public int getCount(){ return count; }

    /**
     * Displays the contents of the list
     */
    public void display(){
        System.out.println("\nList contents: ");
        int tempCount = count;
        CircularSinglyLinkedNode node = (tempCount == 0) ? null : (tempCount == 1) ? current : current.getNext(); //If the list has 0 items, set node to null, if 1 item set to that node, else set to top of stack (current.next)
        if (node == null)
            System.out.println("Empty list");
        else
            while (tempCount > 0){
                ArrayList myList = node.getAllData();
                if (!myList.isEmpty()){
//                    System.out.println("\nItem #"+tempCount+" contains the data: "); //looks better without this line, in my opinion
                    for (Object obj : myList){
                        System.out.print(obj + " ");
                    }
                }else System.out.println("Empty node");
                node = node.getNext();
                tempCount --;
            }
    }

}
