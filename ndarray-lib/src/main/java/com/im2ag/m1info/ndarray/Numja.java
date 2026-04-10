package com.im2ag.m1info.ndarray;

import java.util.Arrays;

abstract public class Numja {

    private static int calcSize(int[] shape_in){
        int size = 1;
        for (int j : shape_in) {
            size *= j;
        }
        return size;
    }
    // Attention C'est mega nul mon code, J'ai pas encore cherché pour gerer à 2 dimensions.
    public static Ndarray array(double... data_in){
        int dimension = 2;
        double[] tmp_arr = new double[data_in.length];
        int[] shape = new int[2];
        shape[0] = 1;
        shape[1] = data_in.length;
        System.arraycopy(data_in, 0, tmp_arr, 0, data_in.length);
        //Va falloir que je corrige la ligne en dessous car c'est n'importe quoi avec les dimensions , shapes...
        return new Ndarray(tmp_arr,data_in.length,tmp_arr.length,shape);
    }

    // Attention C'est mega nul mon code, J'ai pas encore cherché pour gerer à 2 dimensions.
    public static Ndarray zeros(int[] shape_in){
        int dimension = shape_in.length;
        int size = calcSize(shape_in);
        double[] tmp_arr = new double[size];
        Arrays.fill(tmp_arr,0.0);
        return new Ndarray(tmp_arr.clone(),size,dimension,shape_in);
    }
    // Attention C'est mega nul mon code, J'ai pas encore cherché pour gerer à 2 dimensions.
    public static Ndarray arange(double start, double end, double step){
        if(end > start && step < 0 || end < start && step > 0 ){
            System.out.println("Erreur sur les bornes");
            return new Ndarray(new double[]{0.0},1,1,new int[]{1,1});
        }
        int dimension = 1;

        int size = (int)Math.floor((end-start)/step)+1;
        int[] shape = new int[]{1,size};
        double[] tmp_arr = new double[size];
        for (int i = 0; i < size; i++ ){
            tmp_arr[i] = start;
            start += step;
        }
        return new Ndarray(tmp_arr.clone(),size,dimension, shape);
    }




}