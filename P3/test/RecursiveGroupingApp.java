package test;

import src.RecursiveGrouping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecursiveGroupingApp {

    public static void main(String[] args) {

        boolean keepLooping = true;
        Scanner scanner = new Scanner(System.in);

        while (keepLooping) {
            try {
                System.out.println("Menu: \n Enter 2 sequential numbers (this means type your number, press 'Enter', type the other number, and then press 'Enter' again). They will respectively represent the number of players (n) and the group size (k).  Enter two zeroes to exit.\n");
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                if (first == 0 && second == 0)
                    keepLooping = false;
                else
                    RecursiveGrouping.main(new String[]{Integer.toString(first), Integer.toString(second)});
            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only.");
                scanner.nextLine();
            }
        }
    }
}
