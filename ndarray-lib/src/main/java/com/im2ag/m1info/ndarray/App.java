package com.im2ag.m1info.ndarray;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Ndarray myarr1 = Numja.array(0.0,1.0,2.0);
        System.out.println("Matrice 1 :");
        System.out.println(myarr1.print());

        Ndarray myarr2 = Numja.arange(10.0,30.0,5.0);
        System.out.println("Matrice 2 :");
        System.out.println(myarr2.print());

        Ndarray myarr3 = Numja.arange(30.0,20.0,-5.0);
        System.out.println("Matrice 3 :");
        System.out.println(myarr3.print());

        Ndarray myarr4 = Numja.arange(30.0,10.0,-5.0);
        System.out.println("Matrice 4 :");
        System.out.println(myarr4.print());

        Ndarray myarr5 = Numja.array(new double [][]{{1.0,2.0,3.0,4.0},{5.0,6.0,7.0,8.0,9.0}});
        System.out.println("Matrice 5 :");
        System.out.println(myarr5.print());
        Ndarray myarr10 = Numja.zeros(new int[]{10,1});
<<<<<<< feature/basics
        System.out.println("Matrice zeros 10*1 :");
        System.out.println(myarr10.print());
        
        Ndarray numja1 = Numja.array(new double [][]{{2,2,2}, {2,2,2}});
        Ndarray numja2 = Numja.array(new double [][]{{1,1,1}, {1,1,1}});
        
        Ndarray numja_add = Numja.add(numja1, numja2);
        
        System.out.println("Numja1 + Numja2 =");
        System.out.println(numja_add.print());
        
        Ndarray numja_sub = Numja.sub(numja1, numja2);
        
        System.out.println("Numja1 - Numja2 =");
        System.out.println(numja_sub.print());
        
        
        Ndarray numja3 = Numja.array(new double [][]{{1,2,3}, {4,5,6}});
        Ndarray numja4 = Numja.array(new double [][]{{1,2}, {3,4}, {5,6}});

        Ndarray numja_mul = Numja.mul(numja3, numja4);
        
        System.out.println("Numja3 * Numja4 =");
        System.out.println(numja_mul.print());
=======
        myarr10.print();
        myarr2.add(myarr1);
        myarr2.print();
        myarr2.add(myarr4);
        myarr2.print();
        myarr2.sub(Numja.array(10.0,10.0,10.0,10.0,10.0));
        myarr2.print();


        System.out.println("Hello World!");
        myarr5.print();
        myarr5.ravel();
        myarr5.print();
        myarr5.reshape(5, 2);
        myarr5.print();
>>>>>>> develop
    }
}
