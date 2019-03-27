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
public class UnsortedArrayPriorityQueueTest {
    
    public UnsortedArrayPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of head method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue<>(8);
        Object expResult = "bob";
        instance.add("bob", 4);
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue<>(8);
        instance.add("bob", 4);
        assertThat("Array Length", instance.tailIndex, equalTo(0));
    }
    
    /**
     * Test of add method, of class UnsortedArrayPriorityQueue.
     * Checks if the size of the array increases from the initial 8
     */
    @Test
    public void testAddOverEight() throws Exception {
        System.out.println("add max");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue<>(8);
        for(int i=0;i<9;i++){
            instance.add("tim", 3);
        }
        assertThat("Array Length", instance.tailIndex, equalTo(8));
    }

    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue<>(8);
        instance.add("Bob", 4);
        instance.add("tim", 3);
        instance.remove();
        assertThat("Array Length", instance.tailIndex, equalTo(0));
    }

    /**
     * Test of isEmpty method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue<>(8);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UnsortedArrayPriorityQueue.
    */ 
    @Test
    public void testToString() throws QueueOverflowException {
        System.out.println("toString");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue<>(8);
        String expResult = "[(bob, 4), (tim, 6)]";
        instance.add("bob", 4);
        instance.add("tim", 6);
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of highestPriority method, of class UnsortedArrayPriorityQueue.
     * Check if the returns the highest priority item.
     */
    @Test
    public void testHighestPriority() throws QueueOverflowException{
        System.out.println("highestPriority");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue<>(8);
        
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
