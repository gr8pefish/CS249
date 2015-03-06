package Part2;

import java.util.ArrayList;

public class Stack<T> {

    private CircularSinglyLinkedList list;

    /**
     * Implements a generic stack using the circular singly linked list as the underlying data structure (also composed of generic nodes)
     */
    public Stack(){
        list = new CircularSinglyLinkedList<T>();
    }

    /**
     * Pushes a new node onto the stack
     * @param data - the data element
     */
    public void push(T data){
        list.insert(new CircularSinglyLinkedNode<T>(data));
    }

    /**
     * Pops the node from the top of the stack
     * @return an ArrayList of the data removed (will be empty if nothing was popped)
     */
    public ArrayList<T> pop(){
        CircularSinglyLinkedNode node = list.remove();
        if (node != null)
            return node.getAllData();
        else
            return new ArrayList<T>();
    }

    /**
     * Displays the stack
     */
    public void display(){
        System.out.println("\nStack contents: ");
        int tempCount = list.getCount();
        CircularSinglyLinkedNode node = (tempCount == 0) ? null : (tempCount == 1) ? list.getCurrent() : list.getCurrent().getNext(); //If the list has 0 items, set node to null, if 1 item set to that node, else set to top of stack (current.next)
        if (node == null)
            System.out.println("Empty stack");
        else {
            System.out.println("Top of Stack");
            while (tempCount > 0) {
                ArrayList myList = node.getAllData();
                if (!myList.isEmpty()) {
//                    System.out.println("Item #"+tempCount+" contains the data: ");
                    for (int i = 0; i < myList.size(); i++) {
                        System.out.print(myList.get(i));
                        if (!(i + 1 == myList.size()))
                            System.out.print(", ");
                        else
                            System.out.println("");
                    }
                } else System.out.println("Empty node");
                node = node.getNext();
                tempCount--;
            }
            System.out.println("Bottom of Stack");
        }
    }


}
