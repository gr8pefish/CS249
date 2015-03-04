package Part1;

public class Store {

    private Line[] lines;

    public Store(int numberLines, int maxLineLength){
        lines = new Line[numberLines];
        for (int i = 0; i < numberLines;i++){
            lines[i] = new Line(maxLineLength);
        }
    }

    public Line getShortestLine(){ //just check number of customers, not items
        Line tempMin = lines[0];
        for (Line line : lines){
            if (line.getCurrentLineLength() < tempMin.getCurrentLineLength()){
                tempMin = line;
            }
        }
        return tempMin;
    }

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

    public void displayLines(){
        //TODO - crude
        System.out.println("\nLine contents: ");
        for (Line line : lines){
            line.display();
        }
        System.out.println("");
    }

    public void tick(){
        System.out.println("\nOne tick occurred...\n");
        for (Line line : lines){
            line.tick();
        }
    }





}
