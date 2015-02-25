/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanAcademy.search;

/**
 *
 * @author SachinMathew
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        System.out.println(search(primes, 37));
    }

    public static int search(int[] array, int targetValue) {
        int lower = 0;
        int upper = array.length - 1;
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (array[mid] == targetValue) {
                return mid;
            } else if (array[mid] < targetValue) {
                lower = mid + 1;
            } else if (array[mid] > targetValue) {
                upper = mid - 1;
            }
        }
        return -1;
    }
}