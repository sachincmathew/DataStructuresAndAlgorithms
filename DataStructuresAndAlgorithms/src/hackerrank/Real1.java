/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author SachinMathew
 */
public class Real1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTerms = in.nextInt();
        in.nextLine();
        String[] terms = new String[numberOfTerms];
        
        for (int i = 0; i < numberOfTerms; i++) {
            terms[i] = in.nextLine();
        }
        
        List<Set<Character>> l = new ArrayList();
        
        for (int i = 0; i < numberOfTerms; i++) {
            l.add(findUniqueCharactersInWord(terms[i]));
        }
        
        Map<Character, Integer> m = new HashMap();
        for (Set<Character> l1 : l) {            
            for (Character l11 : l1) {
                if(m.containsKey(l11)){
                    int currentCount = m.get(l11);
                    m.put(l11, currentCount+1);
                }else{
                    m.put(l11, 1);
                }
            }
        }
        int popularNumbers = 0;
        for (Map.Entry<Character, Integer> entrySet : m.entrySet()) {
            Character key = entrySet.getKey();
            Integer value = entrySet.getValue();
            if(value ==  numberOfTerms){
                popularNumbers+=1;
            }            
        }
        System.out.println(popularNumbers);
        
    }
    
    static Set<Character> findUniqueCharactersInWord(String s){
        Set<Character> set = new HashSet();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}
