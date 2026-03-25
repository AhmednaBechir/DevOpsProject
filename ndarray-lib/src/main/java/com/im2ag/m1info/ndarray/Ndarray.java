package com.im2ag.m1info.ndarray;

import java.util.ArrayList;
import java.util.List;

public class Ndarray {
    List l;
    int size;
    int ndim;
    int[] shape;
    String dtype; //Voir faire une enum


    public Ndarray() {
        l = new ArrayList<>();
    }

    public Ndarray array(int[] array){

        return new Ndarray();
    }

    public Ndarray zeros(){

        return new Ndarray();
    }

    public Ndarray arange(int nb){

        return new Ndarray();
    }

    public void reshape(int axe1, int axe2){


    }

    List getList() {
        return l;
    }

    int getSize() {
        return size;
    }
}