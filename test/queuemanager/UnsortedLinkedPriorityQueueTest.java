/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uzzy
 */
public class UnsortedLinkedPriorityQueueTest {
    
    public UnsortedLinkedPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isEmpty method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of head method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() {
        System.out.println("head");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        Object expResult = "bob";
        instance.add("bob", 4);
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        Object expResult = "bob";
        instance.add("bob", 4);
        instance.add("tom", 7);
        instance.remove();
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        Object expResult = "bob";
        instance.add("bob", 4);
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UnsortedLinkedPriorityQueue.
    */
    @Test
    public void testToString() {
        System.out.println("toString");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        String expResult = "LinkedStack: size = 2, contents = [tim 6, bob 4]";
        instance.add("bob", 4);
        instance.add("tim", 6);
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of highestPriority method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testHighestPriority() {
        System.out.println("highestPriority");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        
        instance.add("Bob", 6);
        instance.add("Tim", 4);
        instance.add("Kim", 8);
        instance.add("Jim", 3);
        instance.add("Tom", 2);

        int expResult = 2;
        int result = instance.highestPriority();
        assertEquals(expResult, result);
    }
    
}
