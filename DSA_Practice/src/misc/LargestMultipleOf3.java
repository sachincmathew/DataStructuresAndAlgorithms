package misc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SachinMathew
 */
public class LargestMultipleOf3 {

    public static void main(String[] args) {
        Integer[] array = {8, 1, 9, 5};
        //System.out.println(getMaxNumberFromArray(array));
        System.out.println(findMaxMultipleOf3(array));

    }

    static int findMaxMultipleOf3(Integer[] array) {
        int result = -1;
        int sum = 0;
        for (int b : array) {
            sum += b;
        }
        int remainder = sum % 3;
        if (remainder == 0) {
            result=getMaxNumberFromArray(array);
        } else {            
            List<Integer> zeros = new ArrayList<>();
            List<Integer> ones = new ArrayList<>();
            List<Integer> twos = new ArrayList<>();
            for (int number : array) {
                if (number%3==0) {
                    zeros.add(number);
                }
                if (number%3==1) {
                    ones.add(number);
                }
                if (number%3==2) {
                    twos.add(number);
                }
            }
            
            if (remainder == 1) {
                if(ones.size()>1){
                    Collections.sort(ones);
                    ones.remove(0);
                    List<Integer> l = new ArrayList<>();
                    return getMaxNumberFromArray(makeSingleListFromLists(zeros, ones, twos));
                }else{
                    if (twos.size()>2) {
                        Collections.sort(twos);
                        twos.remove(0);
                        twos.remove(1);
                        return getMaxNumberFromArray(makeSingleListFromLists(zeros, ones, twos));
                    }else{
                        return -1;
                    }
                }
            } else if (remainder == 2) {
                if(twos.size()>1){
                    Collections.sort(twos);
                    twos.remove(0);
                    return getMaxNumberFromArray(makeSingleListFromLists(zeros, ones, twos));
                }else{
                    if (ones.size()>2) {
                        Collections.sort(ones);
                        ones.remove(0);
                        ones.remove(1);
                        return getMaxNumberFromArray(makeSingleListFromLists(zeros, ones, twos));
                    }else{
                        return -1;
                    }
                }
            }
        }
        return result;
    }

    public static int getMaxNumberFromArray(Integer[] array) {
        int result = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int temp = (int) (array[i] * (Math.pow(10d, i))); 
            result += temp;
            //System.out.println("i = "+i + "; result = " + result + "; array[i] = " + array[i] + "; temp = " + temp);
        }
        return result;
    }
    
    public static Integer[] makeSingleListFromLists(List l1, List l2, List l3){
        List<Integer> resultList  = new ArrayList();
        resultList.addAll(l1);
        resultList.addAll(l2);
        resultList.addAll(l3);
        
        Integer[] resultArray = new Integer[resultList.size()];
        int i=0;
        for (Integer number : resultList) {
            resultArray[i] = number;
            i++;
        }
        return resultArray;
    }
    
}
