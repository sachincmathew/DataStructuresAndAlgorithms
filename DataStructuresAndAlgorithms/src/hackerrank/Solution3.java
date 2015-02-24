/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(getNumberOfPrimes(100));
    }

    static int getNumberOfPrimes(int N) {
        int count, numberOfPrimes=0;
        
        int[] listOfPrimes;
        
        for (int i = 2; i < N; i++) {
            count = 0;
            for (int j = 1; j <= i; j++) {
                if( i % j == 0){
                    count++;
                }
            }
            if(count == 2){
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }
}
