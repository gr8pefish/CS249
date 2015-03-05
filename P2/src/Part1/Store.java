package Part1;

public class Store {

    private Line[] lines;

    /**
     * Creates a store, or an array of lines
     * @param numberLines - the number of lines in the store
     * @param maxLineLength - the maximum line length of every line
     */
    public Store(int numberLines, int maxLineLength){
        lines = new Line[numberLines];
        for (int i = 0; i < numberLines;i++){
            lines[i] = new Line(maxLineLength);
        }
    }

    /**
     * Determines the shortest line by looking at the number of customers.
     * Does not take into account the number of items each customer has (a variance of only 1-9 items is insufficient to warrant an item count check)
     * @return the shortest line
     */
    public Line getShortestLine(){
        Line tempMin = lines[0];
        for (Line line : lines){
            if (line.getCurrentLineLength() < tempMin.getCurrentLineLength()){
                tempMin = line;
            }
        }
        return tempMin;
    }

    /**
     * Adds a customer to the shortest line in the store
     * @return true if the customer can be added, false if the customer cannot
     */
    public boolean addCustomer(){
        Line toAdd = getShortestLine();
        if (toAdd != null && toAdd.addCustomer()) {
            System.out.println("\nAdded a customer\n");
            return true;
        }else{
            System.out.println("\nCouldn't add a customer\n");
            return false;
        }
    }

    /**
     * Displays the contents of each line
     */
    public void displayLines(){
        System.out.println("\nStore's lines and contents: \nShows the number of items each customer has, displayed from the front of each line to the rear.\n");
        for (Line line : lines){
            line.display();
        }
        System.out.println("");
    }

    /**
     * Progresses the store by having each line in the store tick
     * (i.e. remove an item from the first customer in each line,
     * and if the customer is out of items remove them from that line).
     */
    public void tick(){
        System.out.println("\nOne tick occurred...\n");
        for (Line line : lines){
            line.tick();
        }
    }





}
