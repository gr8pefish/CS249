package Part3;

import Part2.CircularSinglyLinkedList;
import Part2.CircularSinglyLinkedNode;

import java.util.Random;

public class EliminationGame {

    private int numberOfPlayers;
    private int eliminationNumber;
    private int startingLocation;

    private Random random;

    private String[] names = {"Jeff", "Billy", "Sue", "Mike", "Sarah", "George"};

    private CircularSinglyLinkedList list;

    public EliminationGame(int numberOfPlayers, int eliminationNumber, int startingLocation){
        this.numberOfPlayers = numberOfPlayers;
        this.eliminationNumber = eliminationNumber;
        this.startingLocation = startingLocation;

        random = new Random();
        list = new CircularSinglyLinkedList();
    }

    private void initPlayers(){
        for (int i = numberOfPlayers; i > 0; i--){
            list.insert(new CircularSinglyLinkedNode(names[i], "(Original spot: "+i+")")); //TODO - breaks if > 6 b/c names
        }
    }

    public void initGame(){

        //form circle
        initPlayers();

        //get elimination  number
        eliminationNumber = random.nextInt(numberOfPlayers) + 1; //between 1 and maximum number of players
        System.out.println("Elimination number: "+eliminationNumber);

        playGame();

        System.out.println("Winner is "+list.getCurrent()); //last person remaining wins (size of 1)
    }

    public void displayPlayers(){
        list.display();
    }

    public void playGame(){
        if (list.getCount() == 1){
            return;
        }else{
            list.display();
            list.removeAt(eliminationNumber); //TODO - removing current breaks it
            playGame();
        }
    }

}
