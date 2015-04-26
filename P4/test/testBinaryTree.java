package test;

import src.BinarySearchTree;
import src.SimpleStudent;

public class testBinaryTree {

    public static void main(String[] args) {
        testWithStudents();
        testWithIntegers();
    }

    public static void testWithStudents(){

        System.out.println("STUDENT OBJECTS\n");

        SimpleStudent fred = new SimpleStudent("Fred", 2.0F);
        SimpleStudent george = new SimpleStudent("George", 2.7F);
        SimpleStudent bill = new SimpleStudent("Bill", 1.3F);
        SimpleStudent ron = new SimpleStudent("Ron", 3.2F);
        SimpleStudent ginny = new SimpleStudent("Ginny", 4.0F);
        BinarySearchTree<SimpleStudent> studentBinarySearchTree = new BinarySearchTree<SimpleStudent>();

        System.out.println("TESTING INSERT");
        studentBinarySearchTree.insert(fred);
        System.out.println("Single Student");
        studentBinarySearchTree.printTree();
        studentBinarySearchTree.insert(george);
        studentBinarySearchTree.insert(bill);
        studentBinarySearchTree.insert(ron);
        studentBinarySearchTree.insert(ginny);
        System.out.println("\nMore students");
        studentBinarySearchTree.printTree();
        System.out.println("\nLevel order traversal: ");
        studentBinarySearchTree.printLevelOrder();
        System.out.println("\nSize of the tree (number of nodes): "+studentBinarySearchTree.getSize());

        System.out.println("\nTESTING FIND");
        SimpleStudent foundGeorge = studentBinarySearchTree.find(george);
        if (foundGeorge != null) System.out.println("Found george: "+foundGeorge);
        SimpleStudent nullStudent = studentBinarySearchTree.find(new SimpleStudent("nonexistent", 3.3F));
        if (nullStudent == null) System.out.println("Didn't find null student");

        System.out.println("\nTESTING DELETE");
        System.out.println("before delete");
        studentBinarySearchTree.printTree();
        System.out.println("\ndeleting bill (easy case)");
        studentBinarySearchTree.delete(bill);
        studentBinarySearchTree.printTree();
        System.out.println("\ntrying to remove null student should do nothing");
        studentBinarySearchTree.delete(new SimpleStudent("does not exist", 7.0F));
        studentBinarySearchTree.printTree();
    }

    public static void  testWithIntegers(){

        System.out.println("\n\nINTEGER OBJECTS\n");

        BinarySearchTree<Integer> integerBinarySearchTree = new BinarySearchTree<Integer>();

        System.out.println("TESTING INSERT");
        integerBinarySearchTree.insert(5);
        integerBinarySearchTree.insert(3);
        integerBinarySearchTree.insert(8);
        integerBinarySearchTree.insert(6);
        integerBinarySearchTree.insert(7);
        integerBinarySearchTree.insert(4);
        integerBinarySearchTree.insert(2);
        System.out.println("Many nodes");
        integerBinarySearchTree.printTree();
        System.out.println("Size of the tree (number of nodes): "+integerBinarySearchTree.getSize());

        System.out.println("\nTESTING FIND");
        Integer foundFour = integerBinarySearchTree.find(4);
        if (foundFour != null) System.out.println("Found four: "+foundFour);
        Integer nullInt = integerBinarySearchTree.find(88);
        if (nullInt == null) System.out.println("Didn't find nonexistent Integer");

        System.out.println("\nTESTING DELETE");
        System.out.println("before delete");
        integerBinarySearchTree.printTree();
        System.out.println("\ndeleting 8 (hardest case)");
        integerBinarySearchTree.delete(8);
        integerBinarySearchTree.printTree();
        System.out.println("\ntrying to remove null integer should do nothing");
        integerBinarySearchTree.delete(20);
        integerBinarySearchTree.printTree();
    }
}
