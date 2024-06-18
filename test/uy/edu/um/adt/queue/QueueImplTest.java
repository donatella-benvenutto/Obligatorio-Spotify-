package uy.edu.um.adt.queue;

import static org.junit.Assert.*;

import org.junit.Test;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;

public class QueueImplTest {

    @Test
    public void testFlujoCompleto() {
        MyQueue<Integer> queue = new MyQueue<Integer>() {
            @Override
            public void enqueue(Integer value) {

            }

            @Override
            public Integer dequeue() throws EmptyQueueException {
                return null;
            }

            @Override
            public boolean contains(Integer value) {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        queue.enqueue(new Integer(21));
        queue.enqueue(new Integer(34));
        queue.enqueue(new Integer(3));

        assertTrue(queue.contains(21));
        assertEquals(3, queue.size());

        try {

            assertEquals(new Integer(21), queue.dequeue());

        } catch (EmptyQueueException e) {

            fail(e.getMessage());

        }

        assertFalse(queue.contains(21));

        assertEquals(2, queue.size());

        assertTrue(queue.contains(34));

        assertFalse(queue.contains(18));

        try {

            assertEquals(new Integer(34), queue.dequeue());

        } catch (EmptyQueueException e) {

            fail(e.getMessage());

        }

        try {

            assertEquals(new Integer(3), queue.dequeue());

        } catch (EmptyQueueException e) {

            fail(e.getMessage());

        }

        try {

            queue.dequeue();

            fail("Se espera excepción");
        } catch (EmptyQueueException e) {

            assertTrue(true);

        }
    }

}
