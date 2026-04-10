package com.im2ag.m1info.ndarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ndarray {
    List l;
    double[] data; // J'ai pas encore cherché pour gerer à 2 dimensions
    int size;
    int ndim;
    int[] shape;
    String dtype; //Voir faire une enum


    public Ndarray(double[] data_in,int size_in,  int ndim_in, int[] shape_in ) {

        this.data = new double[data_in.length];
        this.data = data_in.clone();
        this.size = size_in;
        this.ndim = ndim_in;
        this.shape = shape_in;

    }

    public void reshape(int axe1, int axe2){

    }

    public void add(Ndarray array_in){
        if (!Arrays.equals(this.shape, array_in.shape)){
            System.out.println("Erreur: Les matrices n'ont pas les mêmes dimensions");
            return;
        }
        for (int i = 0; i< array_in.size;i++){
            this.data[i]+= array_in.data[i];

        }
    }

    public void sub(Ndarray array_in){
        if (!Arrays.equals(this.shape, array_in.shape)){
            System.out.println("Erreur: Les matrices n'ont pas les mêmes dimensions");
            return;
        }
        for (int i = 0; i< array_in.size;i++){
            this.data[i]-= array_in.data[i];

        }
    }

    public void mul(Ndarray array_in){

    }

    //A modifier pour que ça fonctionne à + de dimensions
    public void print(){

        System.out.println(Arrays.toString(this.data));
    }

    List getList() {
        return l;
    }

    int getSize() {
        return size;
    }
}