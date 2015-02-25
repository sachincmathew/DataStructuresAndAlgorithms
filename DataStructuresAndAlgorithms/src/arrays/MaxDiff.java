/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author SachinMathew
 */
public class MaxDiff {

    public static void main(String[] args) {
        int[] array = {7, 9, 5, 6, 3, 2};        
        System.out.println(findMaxDiff(array));
    }
    static int findMaxDiff(int[] array){//MAX(right - left)
        int maxdiff = -1;
        int min=array[0];
        for (int i = 1; i < array.length-1; i++) {
            if (array[i]>min) {
                if (array[i] - min > maxdiff) {
                    maxdiff = array[i] - min;
                }
            }else{
                min=array[i];
            }
        }
        return maxdiff;        
    }
    
}
