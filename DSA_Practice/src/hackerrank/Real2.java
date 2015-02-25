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
public class Real2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTerms = in.nextInt();
        in.nextLine();
        int minx=0, miny=0;
        for (int i = 0; i < numberOfTerms; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            minx = Math.min(minx, x);
            miny = Math.min(miny, y);
            in.nextLine();
        }
        System.out.println(minx*miny);
    }
    /*
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i;
        long minX, minY;
        int numberOfTerms = Integer.parseInt(in.nextLine());

        if (numberOfTerms > 0) {
            minX = in.nextLong();
            minY = Long.parseLong(in.next());
//            in.nextLine();

            for (i = 1; i < numberOfTerms; i++) {
                long a = in.nextLong();
                long b = Long.parseLong(in.next());
//                in.nextLine();

                if (a < minX) {
                    minX = a;
                }
                if (b < minY) {
                    minY = b;
                }
            }

            System.out.println(minX * minY);
        }
    
    */
}
