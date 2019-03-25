/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uzzy
 */
public class SortedLinkedPriorityQueueTest {
    
    public SortedLinkedPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isEmpty method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of head method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() {
        System.out.println("head");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        Object expResult = "bob";
        instance.add("bob", 4);
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object item = "bob";
        int priority = 5;
        Object expResult = "bob";
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        instance.add(item, priority);
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Checks if the method is sorting out the objects correctly.
     */
    @Test
    public void testAddSorted() throws Exception {
        System.out.println("add sorted");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        instance.add("Bob", 6);
        instance.add("Tim", 4);
        instance.add("Kim", 8);
        instance.add("Jim", 3);
        instance.add("Tom", 2);
        Object expResult = "Kim";
        Object result = instance.head();
        assertEquals(expResult, result);
    }    
        

    /**
     * Test of remove method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        Object expResult = "bob";
        instance.add("bob", 4);
        instance.add("tom", 7);
        instance.remove();
        Object result = instance.head();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of toString method, of class SortedLinkedPriorityQueue.
    
    @Test
    public void testToString() {
        System.out.println("toString");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
}
