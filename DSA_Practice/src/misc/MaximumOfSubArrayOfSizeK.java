package misc;


import java.util.ArrayDeque;
import java.util.Deque;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SachinMathew
 */
public class MaximumOfSubArrayOfSizeK {

    public static void main(String a[]) {
        int array[] = {2, 5, 1, 0, 2, 7, 6};
        int size = 3;
        MaximumOfSubArrayOfSizeK.findMax(array, size);
    }

    static void findMax(int[] array, int size) {        
        int i = 0;

        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e., 
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> q = new ArrayDeque<Integer>();

        for (; i < size; i++) {
            // For every element, the previous smaller elements are useless so
            // remove them from q
            while (!q.isEmpty() && array[q.peekLast()] <= array[i]) {
                q.removeLast();
            }
            q.addLast(i); // Add new element at rear of queue
        }
        for (; i < array.length; ++i) {

            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.println(array[q.peek()]);

            // Remove the elements which are out of this window
            while (!q.isEmpty() && q.peekFirst() <= i - size) {
                q.removeFirst();// Remove from rear
            }

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while (!q.isEmpty() && array[q.peekLast()] <= array[i]) {
                q.removeLast();
            }

            q.addLast(i);
        }

        System.out.println(array[q.peek()]);
    }
}
