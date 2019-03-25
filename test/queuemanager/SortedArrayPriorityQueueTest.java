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
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Uzzy
 */
public class SortedArrayPriorityQueueTest {
    
    public SortedArrayPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of head method, of class SortedArrayPriorityQueue.
     * Checks to see if the returns the head of the array.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        Object expResult = "bob";
        instance.add("bob", 4);
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Object item = "bob";
        int priority = 5;
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        instance.add(item, priority);
        assertThat("Array Length", instance.tailIndex, equalTo(0));
    }
    
    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Checks if two items can be added to the array.
     */
    @Test
    public void testAddTwo() throws Exception {
        System.out.println("add two");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        instance.add("Bob", 4);
        instance.add("tim", 3);
        assertThat("Array Length", instance.tailIndex, equalTo(1));
    }
    
    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Checks if the whole array can be filled.
     */
    @Test
    public void testAddMax() throws Exception {
        System.out.println("add max");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        for(int i=0;i<8;i++){
            instance.add("tim", 3);
        }
        assertThat("Array Length", instance.tailIndex, equalTo(7));
    }
    
    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Checks if the QueueOverflowException class works.
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void testQueueOverflowException() throws Exception {
        exception.expect(QueueOverflowException.class);
        exception.expectMessage("Queue is full");
        throw new QueueOverflowException();
    }
    
    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Checks if the method is sorting out the objects correctly.
     */
    @Test
    public void testAddSorted() throws Exception {
        System.out.println("add sorted");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
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
     * Test of remove method, of class SortedArrayPriorityQueue.
     * Checks if items are removed from the list.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        instance.add("Bob", 4);
        instance.add("tim", 3);
        instance.remove();
        assertThat("Array Length", instance.tailIndex, equalTo(0));
    }
    
    /**
     * Test of remove method, of class SortedArrayPriorityQueue.
     * Checks if items are removed then if the next item is moved to the head.
     */
    @Test
    public void testRemoveMoveUp() throws Exception {
        System.out.println("remove move up");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        instance.add("Bob", 4);
        instance.add("Tim", 3);
        instance.remove();
        Object expResult = "Tim";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveMax() throws Exception {
        System.out.println("remove max");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        for(int i=0;i<8;i++){
            instance.add("tim", 3);
        }
        for(int i=0;i<8;i++){
            instance.remove();
        }
        assertThat("Array Length", instance.tailIndex, equalTo(-1));
    }
    
    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Checks if the QueueUnderflowException class works.
     */
    @Test
    public void testQueueUnderflowException() throws Exception {
        exception.expect(QueueUnderflowException.class);
        exception.expectMessage("Queue is empty");
        throw new QueueUnderflowException();
    }

    /**
     * Test of isEmpty method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SortedArrayPriorityQueue.
     
    @Test
    public void testToString() {
        System.out.println("toString");
        SortedArrayPriorityQueue instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
