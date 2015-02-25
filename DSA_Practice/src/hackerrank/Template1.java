/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author SachinMathew
 */
public class Template1 {
    static String getUserInput(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public static void main(String[] args) {
        
        String s = getUserInput();
        System.out.println("s=" + s);
    }    
}
