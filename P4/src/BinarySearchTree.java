
package src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BST class
 *
 * @author - Max Wason
 * @version - 1.1
 * @since - 4/15/15
 */


public class BinarySearchTree <Value extends Comparable<Value>>{

    private Node root;

    //returns if the tree is empty or not
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Gets the size of the tree. Specifically, counts up the nodes and returns that value.
     * @return - int of the number of node
     */
    public int getSize() {
        int counter = 0;
        Queue<Node> nodeQueue = new LinkedList<Node>();
        if (root != null)
            nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node next = nodeQueue.remove();
            counter++;
            if (next.leftChild != null)
                nodeQueue.add(next.leftChild);
            if (next.rightChild != null)
                nodeQueue.add(next.rightChild);
        }
        return counter;
    }


    /**
     * Finds a value and returns it if it is in the tree.
     * @param val - the value to search for
     * @return - null if nothing found, the value if it was found
     */
    public Value find(Value val) {
        if (isEmpty()) return null;
        Node current = root;
        while(current.value.compareTo(val) != 0) {
            if (current.value.compareTo(val) > 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current.value;
    }


    /**
     * Inserts a value into the tree.
     * @param val - the value inserted
     */
    public void insert(Value val) {
        Node toInsert = new Node(val);
        if (isEmpty())
            root = toInsert;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (current.value.compareTo(val) > 0){ //go left
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = toInsert;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = toInsert;
                        return;
                    }
                }

            }

        }
    }


    /**
     * Deletes a node in the tree (if it exists) and reconnects the new vertices to remake the tree whole.
     * @param val - the value to delete
     */
    public void delete(Value val) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current.value.compareTo(val) != 0) {
            parent = current;
            if (current.value.compareTo(val) > 0){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return;
        }

        //no children
        if (current.leftChild == null && current.rightChild == null){
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }

        //no right children
        else if (current.rightChild == null){
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }

        //no left children
        else if (current.leftChild == null){
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }

        //2 children, find successor
        else{
            Node successor = getSuccessor(current);

            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            successor.leftChild = current.leftChild;
        }

    }

    /**
     * Gets the successor node for deletion. Assumes the node has two children.
     * @param delNode - the node to delete
     * @return - the successor node
     */
    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor.value.compareTo(delNode.rightChild.value) != 0){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }


    /**
     * Prints a level order traversal
     */
    public void printLevelOrder(){
        Queue<Node> nodeQueue = new LinkedList<Node>();
        if (root != null)
            nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node next = nodeQueue.remove();
            System.out.print(next + " ");
            if (next.leftChild != null)
                nodeQueue.add(next.leftChild);
            if (next.rightChild != null)
                nodeQueue.add(next.rightChild);
        }
    }

    /**
     * Prints the tree nicely, formatted as it would appear realistically, with the nodes on the correct "levels"
     */
    public void printTree() {

        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();

        if (root != null)
            currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Iterator<Node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                Node currentNode = iter.next();
                if (currentNode.leftChild != null) {
                    nextLevel.add(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    nextLevel.add(currentNode.rightChild);
                }
                System.out.print(currentNode + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();

        }

    }


    /**
     * Private inner Node class
     */
    private class Node {

        private Value value;
        private Node leftChild;
        private Node rightChild;

       /**
        * Comments for Node constructor, note that Node is inheriting the attributes of Value from the outer class.
        */
        public Node(Value val) {
            this.value = val;
        }

        /**
        * Comments for toString override
        */
        @Override
        public String toString(){
            return value.toString();
        }
    }
}
