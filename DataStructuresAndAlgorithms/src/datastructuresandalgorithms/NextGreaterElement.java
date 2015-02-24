package datastructuresandalgorithms;


import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        nextgreaterElement(array);
        for (int b : array) {
            System.out.print(b + ",");
        }
    }

    static void nextgreaterElementWithLoops(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean isGreaterFound = false;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] > array[i]){
                    isGreaterFound = true;
                    array[i] = array[j];
                    break;
                }                
            }    
            if (!isGreaterFound) {
                array[i] = -1;
            }
        }
    }    
    
    static void nextgreaterElement(int[] array){
        int[] returnArray = new int[array.length];
        
        Stack<Integer> stack = new Stack();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (!stack.isEmpty() && (stack.peek() < array[i])) {
                System.out.println(stack.pop() + "'s Next Greatest Element is " + array[i]);
                while (!stack.isEmpty() && stack.peek() < array[i]) {
                    System.out.println(stack.pop() + "'s Next Greatest Element is " + array[i]);
                }
                stack.push(array[i]);
            } else {
                stack.push(array[i]);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + "'s Next Greatest Element is -1");
        }
    }    
}
