package com.company.dstructure;

import java.util.Scanner;

public class ArrayExample {
    public void myArray(int size) {
        int[] priceOfPen = new int[size];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < priceOfPen.length; i++) {
            System.out.print("enter number..... ");
            priceOfPen[i] = in.nextInt();
            System.out.println();
        }
        System.out.print("output------");
        for (int i = 0; i < priceOfPen.length; i++) {
            System.out.print(priceOfPen[i] + " ");
        }
        System.out.println();
    }
}
