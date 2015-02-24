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
public class SelectionSort implements Sort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        array = new SelectionSort().sort(array);
        for (int b : array) {
            System.out.print(b + ",");
        }
    }

    @Override
    public int[] sort(int[] array) {        
        int sortedUpto = 0;
        int minimum = array[sortedUpto];
        int temp;
        for (int count = 0; count < array.length - 1; count++) {
            int minIndex=0;
            for (int i = sortedUpto; i < array.length; i++) {
                if (array[i] <= minimum) {
                    minimum = array[i];
                    minIndex = i;
                }
            }
            temp = array[sortedUpto];
            array[sortedUpto] = minimum;
            array[minIndex] = temp;
            sortedUpto++;            
            minimum = array[sortedUpto];            
        }
        return array;
    }
}
