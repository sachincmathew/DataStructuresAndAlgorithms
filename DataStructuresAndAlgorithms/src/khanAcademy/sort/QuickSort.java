/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanAcademy.sort;

import java.util.Arrays;

/**
 *
 * @author SachinMathew
 */
public class QuickSort implements Sort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        //quickSort(array, 0, array.length - 1);
        Arrays.sort(array);
        for (int b : array) {
            System.out.print(b + ",");
        }
    }

    @Override
    public int[] sort(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void quickSort(int array[], int startIndex, int endIndex) {
        int i = startIndex;                          //left-to-right scan
        int k = endIndex;                            //right-to-left scan

        if (endIndex - startIndex >= 1){
            int pivot = array[startIndex];//pivot = first element

            while (k > i){
                while (array[i] <= pivot && i <= endIndex && k > i){ //first element > pivot
                    i++;
                }
                while (array[k] > pivot && k >= startIndex && k >= i){ //first element < pivot
                    k--;
                }
                if (k > i){//swap i-th and k-th element
                    swap(array, i, k); 
                }
            }
            swap(array, startIndex, k);
            
            quickSort(array, startIndex, k - 1); // quicksort the left partition
            quickSort(array, k + 1, endIndex);   // quicksort the right partition
        }
    }

    public static void swap(int array[], int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
