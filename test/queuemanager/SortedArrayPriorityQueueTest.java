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
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        Object expResult = "b";
        instance.add("b", 4);
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
    
    @Test
    public void testAddTwo() throws Exception {
        System.out.println("add");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        instance.add("Bob", 4);
        instance.add("tim", 3);
        assertThat("Array Length", instance.tailIndex, equalTo(1));
    }

    /**
     * Test of remove method, of class SortedArrayPriorityQueue.
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
    
    public void testRemoveTwo() throws Exception {
        System.out.println("remove Two");
        SortedArrayPriorityQueue instance = new SortedArrayPriorityQueue<>(8);
        instance.add("Bob", 4);
        instance.add("tim", 3);
        instance.remove();
        instance.remove();
        assertThat("Array Length", instance.tailIndex, equalTo(3));
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
