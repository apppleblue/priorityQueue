package queuemanager;

import java.util.Scanner;

/**
 * Simple text based driver program for the PriorityQueue ADT and its different
 * implementations.
 */
public class QueueManager {

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        
        oa oa = new oa();

        /* Welcome and prompt for implementation choices */
        System.out.println("Welcome to the Priority Queue manager.");
        System.out.println();
        System.out.println("Select priority queue implementation");
        System.out.println("SA for a sorted array");
        System.out.println("UA for an unsorted array");
        System.out.println("SL for a sorted linked list");
        System.out.println("UL for an unsorted linked list");
        System.out.println("H for a heap");
        System.out.println();
        System.out.print("Your choice > ");
        String input = stdin.nextLine();

        /* Select implementation version to use */
        switch (input.toLowerCase()) {
            case "sa":
                oa.oaM(input);
                System.out.println("Using a sorted array.");
                break;
            case "ua":
            case "sl":
            case "ul":
            case "h":
            default:
                //q = new SortedArrayPriorityQueue<>(8);
                //System.out.println("Invalid choice, using sorted array.");
                //break;
        }


        
    }
}
