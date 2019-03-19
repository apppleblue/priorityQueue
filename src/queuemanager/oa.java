package queuemanager;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usman
 */
public class oa {
    Scanner stdin = new Scanner(System.in);

    public void oaM(String input){
            
    PriorityQueue<Person> q;
    q = new SortedArrayPriorityQueue<>(8);  
    
        System.out.println("Enter commands at the prompt.");
        System.out.println("A <name> <priority> adds a person to the queue.");
        System.out.println("H displays the name of the person at the head of the queue");
        System.out.println("R removes the person at the head of the queue");
        System.out.println("E checks if the queue is empty");
        System.out.println("P prints the whole queue");
        System.out.println("Q quits from the system");

        System.out.print("> ");
        input = stdin.nextLine();

    
        while (!input.toLowerCase().equals("q")) {
            if (input.toLowerCase().charAt(0) == 'a') {

                /* Add an item to the queue */
                String name = input.substring(2, input.lastIndexOf(' '));
                Person person = new Person(name);
                int priority = Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));
                System.out.println("Adding " + person.getName() + " with priority " + priority);
                try {
                    q.add(person, priority);
                } catch (QueueOverflowException e) {
                    System.out.println("Add operation failed: " + e);
                }
            } else if (input.toLowerCase().charAt(0) == 'h') {

                /* Display the item at the head of the queue */
                try {
                    String name = q.head().getName();
                    System.out.println("The person at the head of the queue is " + name);
                } catch (QueueUnderflowException e) {
                    System.out.println("Can't get head of queue: " + e);
                }
            } else if (input.toLowerCase().charAt(0) == 'r') {

                /* Remove the item at the head of the queue */
                try {
                    String name = q.head().getName();
                    System.out.println("Removing " + name + " from the head of the queue");
                    q.remove();
                } catch (QueueUnderflowException e) {
                    System.out.println("Can't remove head of queue: " + e);
                }
            } else if (input.toLowerCase().charAt(0) == 'e') {

                /* Report if the queue is empty or not */
                if (q.isEmpty()) {
                    System.out.println("The queue is empty");
                } else {
                    System.out.println("The queue is NOT empty");
                }
            } else if (input.toLowerCase().charAt(0) == 'p') {

                /* Print out the entire queue (in no particular order) */
                System.out.println(q);
            }
            System.out.print("> ");
            input = stdin.nextLine();
        }
        System.out.println("Bye");
    }
    } 
    
