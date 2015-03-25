package test;

import src.LinkedMatrix;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <H1>LinkedMatrixApp</H1>
 * Models a 2D Matrix through the command line for exploratory visual testing.
 * Lots of formatted strings and scanner loops in here.
 *
 * @author      firstname lastname uid@nau.edu
 * @version     1.0
 * @since       3-20-2015
 */
public class LinkedMatrixApp {
    private static LinkedMatrix matrix; //the static linked matrix app
    private static int rows; //local value of rows to help with display formatting
    private static int columns; //local value of columns to help with display formatting

	// this main method should use scanner to query the user and provide an interface for testing the matrix
    public static void main(String[] args){

        boolean keepLooping = true;
        Scanner scanner = new Scanner(System.in);

        while (keepLooping) {
            try {
                System.out.println("Menu: \n To create a matrix please enter a 2 digit number representing the respective amount of rows and columns, offset by 1 (ex: 22 will be a 3x3 matrix) [Valid inputs: 00-99]: ");
                String input = scanner.next();
                if (input.length() == 2) {
                    rows = Character.getNumericValue(input.charAt(0));
                    columns= Character.getNumericValue(input.charAt(1));
                    matrix = new LinkedMatrix(rows, columns);
                    keepLooping = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a 2 digit number between 00 and 99.");
                scanner.nextLine();
            }
        }

        keepLooping = true;
        while (keepLooping) {
            try {
                System.out.println("Menu: \n 0) Run default test. \n 1) Insert. \n 2) Fill. \n 3) Display Sums. \n 4) Display Matrix. \n 5) Exit \n Please enter a number (0-5): ");
                int input = scanner.nextInt();
                String inp;
                switch (input) {
                    case 0:
                        testLinkedMatrix.main(new String[]{""});
                        break;
                    case 1:
                        System.out.println("Please enter the 2 digit number followed by the location. Ex: 0912 will insert the number 9 into the second row and the third column (because indices start at 0). : ");
                        inp = scanner.next();
                        matrix.insert(Integer.valueOf(inp.substring(0, 2)), Character.getNumericValue(inp.charAt(2)), Character.getNumericValue(inp.charAt(3)));
                        System.out.println("\n" + matrix.display());
                        break;
                    case 2:
                        System.out.println("Please enter the 2 digit number to fill the array with: ");
                        inp = scanner.next();
                        matrix.insert(Integer.valueOf(inp));
                        System.out.println("\n" + matrix.display());
                        break;
                    case 3:
                        System.out.println("\n" + matrix.displaySummed());
                        break;
                    case 4:
                        System.out.println("\n" + matrix.display());
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        keepLooping = false;
                        break;
                    default:
                        System.out.println("Please enter a number between 0 and 5");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number between 0 and 5.");
                scanner.nextLine();
            }
        }
       
    }

    // this private helper method should be used to indicate to the user when the system is ready for a new command
    // you can make more helper methods for other prompts as needed
    private static void promptReady(){

        
    }
}
