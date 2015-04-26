package src;

/**
 * Comments for a class you can use in your BST
 *
 * @author - Max Wason
 * @version - 1.0
 * @since - 4/15/15
 */
/*
    Implementing Interfaces in Java: implements

    In Java, an Interface is a class which contains method definitions with no functionality.
    When another class is written to implement this interface class, it is making a promise to the compiler.
    By implementing the interface, the programmer is forced into creating those methods in the interface,
    and providing them with functionality.

    By writing our SimpleStudent class to implement Comparable, we are agreeing to provide the method
    in Comparable called "compareTo" in our class. This returns an int which is negative if our class is 
    'smaller' than the other class, is 0 if our class is equal to the other class, and is positive if our class is
    'greater' than the other class.

    You may delete this comment when you no longer need it.
*/
public class SimpleStudent implements Comparable<SimpleStudent> {

    private String name;
    private float gpa;

    /**
     * Constructor
     * @param name - the student's name
     * @param gpa - the student's GPA
     */
    public SimpleStudent(String name, float gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public float getGpa(){
        return gpa;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name +" with a GPA of "+gpa;
    }

    /**
     * Compares GPA of this student and another.
     * @param other_student - the other student to compare to
     * @return - 0 if equal, 1 if this student's gpa is larger, -1 if the other student's gpa is larger
     */
    @Override
    public int compareTo(SimpleStudent other_student) {
        if (this.gpa == other_student.gpa) return 0;
        return this.gpa > other_student.gpa ? 1 : -1;
    }
}
