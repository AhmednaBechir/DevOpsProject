package com.im2ag.m1info.ndarray;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        Ndarray arr = Numja.array(4.0,7.0,9.0);
        arr.print();

        Ndarray arr2 = Numja.exp(arr);

        arr2.print();

        System.out.println();

        Ndarray arr3 = Numja.array(1.0,2.0,3.0);
        arr3.print();

        Ndarray arr4 = Numja.pow(arr3, 3);

        arr4.print();
    }
}
