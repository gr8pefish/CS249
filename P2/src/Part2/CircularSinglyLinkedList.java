package Part2;

import java.util.ArrayList;

public class CircularSinglyLinkedList {

    private CircularSinglyLinkedNode current;
    private int count;

    public CircularSinglyLinkedList(){} //Default constructor, nothing to initialize

    public void insert(CircularSinglyLinkedNode toAdd) { // insert node after current
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

    public CircularSinglyLinkedNode removeAt(int index){ //HAVE TO MOVE CURRENT FOR NEXT ITERATION, also use display as debug
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
            System.out.println("Index: "+index);
            if (index%2 == 0){
                current = current.getNext();
                current.setNext(current);
                count--;
                return current;
            }else if (index%2 == 1){
                current.setNext(null);
                count--;
                return current;
            }else{
                System.out.println("ERROR");
                return null;
            }
        } else {
            CircularSinglyLinkedNode temp = current.getNext();
            if (index == 1){
                current.setNext(current.getNext().getNext());
                count--;
                return temp;
            }else{
                for (int i = 0; i < index - 1; i++) {
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
//                    System.out.println("\nItem #"+tempCount+" contains the data: ");
                    for (Object obj : myList){
                        System.out.print(obj + " ");
                    }
                }else System.out.println("Empty node");
                node = node.getNext();
                tempCount --;
            }
    }

}
