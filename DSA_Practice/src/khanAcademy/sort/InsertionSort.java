/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanAcademy.sort;

/**
 *
 * @author SachinMathew
 */
public class InsertionSort implements Sort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        array = new InsertionSort().sort(array);
        for (int b : array) {
            System.out.print(b + ",");
        }
    }

    @Override
    public int[] sort(int[] array) {//in place sorting
        int lastSortedIndex = 0;
        int currentElement;
        for (int i = 1; i < array.length; i++) {
            currentElement = array[i];
            for (int j = lastSortedIndex; j >= 0; j--) {
                if (currentElement < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = currentElement;
                }
            }
            lastSortedIndex = i;
        }
        return array;
    }
}