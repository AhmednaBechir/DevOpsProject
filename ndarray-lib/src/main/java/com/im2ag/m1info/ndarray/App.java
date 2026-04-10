package com.im2ag.m1info.ndarray;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Ndarray myarr1 = Numja.array(0.0,1.0,2.0);
        myarr1.print();

        Ndarray myarr2 = Numja.arange(10.0,30.0,5.0);
        myarr2.print();

        Ndarray myarr3 = Numja.arange(30.0,20.0,5.0);
        myarr3.print();

        Ndarray myarr4 = Numja.arange(30.0,10.0,-5.0);
        myarr4.print();

        Ndarray myarr10 = Numja.zeros(new int[]{10});
        myarr10.print();
        myarr2.add(myarr1);
        myarr2.print();
        myarr2.add(myarr4);
        myarr2.print();
        myarr2.sub(Numja.array(10.0,10.0,10.0,10.0,10.0));
        myarr2.print();


        System.out.println("Hello World!");


    }
}
