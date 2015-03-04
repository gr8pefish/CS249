package Part2;

import java.util.ArrayList;

public class Stack<T,S> {

    private CircularSinglyLinkedList list;

    public Stack(){
        list = new CircularSinglyLinkedList();
    }

    public void push(T first, S second){
        list.insert(new CircularSinglyLinkedNode(first, second));
    }

    public ArrayList<T> pop(){
        CircularSinglyLinkedNode node = list.remove();
        if (node != null)
            return node.getAllData();
        else
            return new ArrayList<T>();
    }

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