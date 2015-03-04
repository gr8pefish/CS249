package maxwason;

import Part1.Store;
import Part2.Stack;
import Part3.EliminationGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        testStore(2, 3);
//        testStack();
        playEliminationGame();
    }

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

    public static void testStack(){
        Stack myStack = new Stack();
        myStack.push(1.3,"hi");
        myStack.push(2,2);
        myStack.pop();
        myStack.push("one", "2");
        myStack.pop();
        myStack.display();
        myStack.pop();
        myStack.display();
        myStack.pop();
        myStack.display();
        myStack.push(22, 1.4);
        myStack.display();
        myStack.push("hi", "u n00b");
        myStack.push(0, '1');
        myStack.display();
    }

    public static void playEliminationGame(){
        EliminationGame game = new EliminationGame(5,3,0);
        game.initGame();
        game.displayPlayers();
    }
}
