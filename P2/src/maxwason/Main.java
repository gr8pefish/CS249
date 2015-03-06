package maxwason;

import Part1.Store;
import Part2.CircularSinglyLinkedNode;
import Part2.Stack;
import Part3.EliminationGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        testStore(2, 3);
        testStack();
//        playEliminationGame(5,4,1);
    }


    /**
     * Runs the store loop, creates a menu and waits for user input.
     * @param maximumNumberOfLines - analogous to the number of clerks
     * @param maximumLineLength - the maximum length of each line
     */
    public static void testStore(int maximumNumberOfLines, int maximumLineLength){
        Store myStore = new Store(maximumNumberOfLines, maximumLineLength);

        boolean keepLooping = true;
        Scanner scanner = new Scanner(System.in);

        while (keepLooping){
            try {
                System.out.println("Menu: \n 1) Add a new customer. \n 2) Display the lines. \n 3) Simulate one tick of time passing. \n 4) Exit \n Please enter a number (1-4): ");
                int input = scanner.nextInt();
                switch (input){
                    case 1:
                        myStore.addCustomer();
                        break;
                    case 2:
                        myStore.displayLines();
                        break;
                    case 3:
                        myStore.tick();
                        break;
                    case 4:
                        keepLooping = false;
                        break;
                    default:
                        System.out.println("Please enter a number between 1 and 4");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a number between 1 and 4.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Tests the stack by inputting a wide range of cases
     */
    public static void testStack(){

        //creates two stacks
        Stack<Integer> firstStack = new Stack<Integer>();
        Stack<String> secondStack = new Stack<String>();

        firstStack.push(1);
        secondStack.push("hi");

        //display both stacks
        firstStack.display();
        secondStack.display();

        //proper pushing
        firstStack.push(2);
        firstStack.push(4);
        firstStack.display();

        //proper popping
        secondStack.push("maybe");
        secondStack.display();
        secondStack.pop();
        secondStack.display();
        secondStack.pop();
        secondStack.display();
        secondStack.pop(); //works with empty stacks (doesn't do anything)
        secondStack.display();

    }

    /**
     * Plays the elimination game to determine the winning spot with the given inputs.
     * @param numberOfPlayers - must be 20 or less (only due to the limited number of names I came up with)
     * @param eliminationNumber - leave as 0 and it will be randomly generated
     * @param startingLocation - starts at index 0 to reference the first player
     */
    public static void playEliminationGame(int numberOfPlayers, int eliminationNumber, int startingLocation){
        EliminationGame game = new EliminationGame(numberOfPlayers, eliminationNumber, startingLocation);
        game.playGame();
    }
}
