package com.im2ag.m1info.ndarray;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Ndarray myarr1 = Numja.array(0.0,1.0,2.0);
        // myarr1.print();

        // Ndarray myarr2 = Numja.arange(10.0,30.0,5.0);
        // myarr2.print();

        // Ndarray myarr3 = Numja.arange(30.0,20.0,5.0);
        // myarr3.print();

        // Ndarray myarr4 = Numja.arange(30.0,10.0,-5.0);
        // myarr4.print();

        // Ndarray myarr5 = Numja.array(new double [][]{{1.0,2.0,3.0,4.0},{5.0,6.0,7.0,8.0,9.0}});
        // myarr5.print();
        // Ndarray myarr10 = Numja.zeros(new int[]{10,1});
        // myarr10.print();
        // myarr2.add(myarr1);
        // myarr2.print();
        // myarr2.add(myarr4);
        // myarr2.print();
        // myarr2.sub(Numja.array(10.0,10.0,10.0,10.0,10.0));
        // myarr2.print();

        Ndarray arr1 = Numja.array(0.0,1.0,2.0);
        arr1.print();
        Ndarray arr2  = Numja.stretch(arr1, 1, 5);
        arr2.print();
    }
}
