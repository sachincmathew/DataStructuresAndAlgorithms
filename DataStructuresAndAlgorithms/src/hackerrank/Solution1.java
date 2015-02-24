/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author SachinMathew
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTerms = in.nextInt();
        int[] terms = new int[numberOfTerms];
        
        for (int i = 0; i < numberOfTerms; i++) {
            terms[i] = in.nextInt();
        }
        int[] differences = new int[numberOfTerms - 1];
        for (int i = 1; i < numberOfTerms; i++) {
            //System.out.println(terms[i] + " - " + terms[i-1] + " = " + (terms[i]-terms[i-1]));
            differences[i - 1] = terms[i] - terms[i - 1];
        }
//        System.out.println("--");
//        for (int i = 0; i < differences.length; i++) {
//            System.out.println(differences[i]);
//        }
        int commonDifference = 0;
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < differences.length; i++) {
            if (m.containsKey(differences[i])) {
                int count = m.get(differences[i]);
                m.put(differences[i], count + 1);
                commonDifference = differences[i];
            } else {
                m.put(differences[i], 1);
            }
        }
        int unique=0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value==1) {
                unique=key;
                break;
            }
//            System.out.println("key, " + key + " value " + value);
        }
//        System.out.println(String.valueOf(unique));
        int uniqueIndex = 0;
        for (int i = 0; i < differences.length; i++) {
            if (unique==differences[i]) {
                uniqueIndex=i;
                break;
            }
        }
//        System.out.println(uniqueIndex);
        System.out.println(terms[uniqueIndex] + commonDifference);
        
    }
}
