package datastructuresandalgorithms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SachinMathew
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
    public static void main(int[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
        
    }

}
