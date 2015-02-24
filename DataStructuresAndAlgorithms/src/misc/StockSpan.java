package misc;


import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SachinMathew
 */
public class StockSpan {

    public static void main(String[] args) {
        int[] array = {100, 80, 60, 70, 60, 75, 85};
        int[] stockSpan = StockSpan(array);
        for (int b : stockSpan) {
            System.out.print(b + ",");
        }
    }

    static int[] StockSpanWithLoops(int[] array) {
        int[] stockSpan = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i], count = 0;

            for (int j = i; j >= 0; j--) {
                if (array[j] > array[i]) {
                    break;
                }
                count++;
            }
            stockSpan[i] = count;
        }
        return stockSpan;
    }

    static int[] StockSpan(int[] array) {
        Stack<Integer> st = new Stack<Integer>();
        int[] stockSpan = new int[array.length];
        int n = array.length;
        stockSpan[0] = 1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            stockSpan[i] = 1;
            while (!st.empty() && array[st.peek()] <= array[i]) {
                stockSpan[i] += stockSpan[st.peek()];
                st.pop();
            }
            st.push(i);
        }
        st.clear();
        return stockSpan;
    }
}
