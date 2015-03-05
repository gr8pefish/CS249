package Part3;

import Part2.CircularSinglyLinkedList;
import Part2.CircularSinglyLinkedNode;

import java.util.Random;

public class EliminationGame {

    private int numberOfPlayers;
    private int eliminationNumber;
    private int startingLocation;

    private Random random;

    private String[] names = {"Jeff", "Billy", "Sue", "Mike", "Sarah", "George", "Fred", "Nick", "Max", "Joshua",
            "Sharon", "John", "Maggie", "Jean-Paul", "Carson", "Chelsea", "Jared", "Anna", "Cody", "Jenny"};

    private CircularSinglyLinkedList list;

    /**
     * Creates a game where the players form a circle and count up to the elimination number, removing said player.
     * The count begins again at the next player, continuing until only one person(the winner) remains.
     *
     * @param numberOfPlayers - must be 20 or less due to the limited number of names I came up with
     * @param eliminationNumber - leave as 0 and it will be randomly generated
     * @param startingLocation - starts at index 0 to reference the first player
     */
    public EliminationGame(int numberOfPlayers, int eliminationNumber, int startingLocation){
        if (numberOfPlayers > 20) numberOfPlayers = 20; //simple check so bad arguments don't break the game
        this.numberOfPlayers = numberOfPlayers;
        this.eliminationNumber = eliminationNumber;
        this.startingLocation = startingLocation;

        random = new Random();
        list = new CircularSinglyLinkedList();
    }

    /**
     * Loops through each player to set them up. Loops in reverse so the indices match up for this game.
     */
    private void initPlayers(){
        for (int i = numberOfPlayers; i > 0; i--){
            list.insert(new CircularSinglyLinkedNode(names[i], "(Original spot: "+i+")"));
        }
    }

    /**
     * Play ball.
     */
    public void playGame() {

        //form circle
        initPlayers();

        //set/print starting location and elimination number
        System.out.println("Starting location: " + startingLocation);
        if (eliminationNumber == 0) eliminationNumber = random.nextInt(numberOfPlayers) + 1;
        System.out.println("Elimination number: " + eliminationNumber);

        int tempStarting = startingLocation; //moves the starting location to the correct spot by adding it on to the first iteration

        //initially had this as recursive, but this implementation is cleaner
        while (list.getCount() != 1) {
            list.display();
            CircularSinglyLinkedNode removed = list.removeAt(eliminationNumber + tempStarting);
            if (removed != null) System.out.println("\nRemoved "+removed); //TODO: broken w/ two players?
            tempStarting = 0;
        }

        //print the winner
        System.out.println("\n\nWinner is " + list.getCurrent() + " !"); //last person remaining wins (size of 1)
    }

}
