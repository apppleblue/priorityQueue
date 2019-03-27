/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import java.nio.charset.Charset;
import java.util.Random;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usman
 */
public class HeapPriorityQueueTest {
    
    public HeapPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of head method, of class HeapPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        HeapPriorityQueue instance = new HeapPriorityQueue<>(20);
        Object expResult = "bob";
        instance.add("bob", 4);
        Object result = instance.head();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of head method, of class HeapPriorityQueue.
     * Checks that when multiple values are entered if it returns the right head.
     */
    @Test
    public void testHeadMultiple() throws Exception {
        System.out.println("head");
        HeapPriorityQueue instance = new HeapPriorityQueue<>(20);
        Object expResult = "kim";
        instance.add("bob", 4);
        instance.add("jim", 6);
        instance.add("kim", 8);
        instance.add("tim", 2);
        instance.add("tom", 6);
        Object result = instance.head();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of add method, of class HeapPriorityQueue.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        HeapPriorityQueue instance = new HeapPriorityQueue<>(20);
        instance.add("bob", 4);
        assertThat("Array Length", instance.tailIndex, equalTo(1)); 
    }
    
    /**
     * Test of add method, of class HeapPriorityQueue.
     * checks to see if multiple items can be added to the array.
     */
    @Test
    public void testAddMultiple() {
        System.out.println("add multiple");
        HeapPriorityQueue instance = new HeapPriorityQueue<>(20);
        
        for(int i=0;i<15;i++){
            byte[] array = new byte[3];
            new Random().nextBytes(array);
            String gs = new String(array, Charset.forName("UTF-8"));
            int random = (int)(Math.random() * 50 + 1);
            instance.add(gs,random);
        }
        
        assertThat("Array Length", instance.tailIndex, equalTo(15)); 
    }

    /**
     * Test of toString method, of class HeapPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HeapPriorityQueue instance = new HeapPriorityQueue<>(20);
        instance.add("bob", 4);
        instance.add("bob", 6);
        instance.add("bob", 8);
        String expResult = " PARENT : (bob, 8) LEFT CHILD : (bob, 4) RIGHT CHILD :(bob, 6)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of remove method, of class HeapPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        HeapPriorityQueue instance = new HeapPriorityQueue<>(20);
        instance.add("Bob", 4);
        instance.add("tim", 3);
        instance.remove();
        assertThat("Array Length", instance.tailIndex, equalTo(1));
    }

    /**
     * Test of isEmpty method, of class HeapPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        HeapPriorityQueue instance = new HeapPriorityQueue<>(20);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
}
