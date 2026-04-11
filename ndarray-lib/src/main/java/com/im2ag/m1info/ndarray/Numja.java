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
        double[][] tmp_arr = new double[1][data_in.length];
        int[] shape = new int[2];
        shape[0] = 1;
        shape[1] = data_in.length;
        System.arraycopy(data_in, 0, tmp_arr[0], 0, data_in.length);
        //Va falloir que je corrige la ligne en dessous car c'est n'importe quoi avec les dimensions , shapes...
        return new Ndarray(tmp_arr,data_in.length,tmp_arr.length,shape);
    }

    public static Ndarray array(double[]... data_in){
        int dimension = data_in.length;
        double[][] tmp_arr = new double[dimension][data_in[0].length];
        int[] shape = new int[2];
        shape[0] = data_in.length;
        shape[1] = data_in[0].length;
        System.arraycopy(data_in, 0, tmp_arr, 0, data_in.length);
        //Va falloir que je corrige la ligne en dessous car c'est n'importe quoi avec les dimensions , shapes...
        return new Ndarray(tmp_arr,data_in.length,tmp_arr.length,shape);
    }

    // Attention C'est mega nul mon code, J'ai pas encore cherché pour gerer à 2 dimensions.
    public static Ndarray zeros(int[] shape_in){
        int dimension = shape_in.length;
        int size = calcSize(shape_in);
        double[][] tmp_arr = new double[shape_in[0]][shape_in[1]];
        for (int i = 0; i < shape_in[0]; i++){
            Arrays.fill(tmp_arr[i],0.0);
        }

        return new Ndarray(tmp_arr.clone(),size,dimension,shape_in);
    }
    // Attention C'est mega nul mon code, J'ai pas encore cherché pour gerer à 2 dimensions.
    public static Ndarray arange(double start, double end, double step){
        if(end > start && step < 0 || end < start && step > 0 ){
            System.out.println("Erreur sur les bornes");
            return new Ndarray(new double[][]{{0.0}},1,1,new int[]{1,1});
        }
        int dimension = 1;

        int size = (int)Math.floor((end-start)/step)+1;
        int[] shape = new int[]{1,size};
        double[][] tmp_arr = new double[1][size];
        for (int i = 0; i < size; i++ ){
            tmp_arr[0][i] = start;
            start += step;
        }
        return new Ndarray(tmp_arr.clone(),size,dimension, shape);
    }

    public static Ndarray add(Ndarray mat1,Ndarray mat2){
        if (!Arrays.equals(mat1.shape, mat2.shape)){
            System.out.println("Erreur: Les matrices n'ont pas les mêmes dimensions");
            return null;
        }
        double[][] res = new double[mat1.shape[0]][mat1.shape[1]];
        int rows = mat1.shape[0];
        int cols = mat1.shape[1];
        for (int i = 0; i< rows;i++){
            for (int j = 0; j < cols ; j++){
                res[i][j] = mat1.data[i][j] + mat2.data[i][j];
            }
        }
        return new Ndarray(res,mat1.size,mat1.ndim,mat1.shape);
    }

    public static Ndarray sub(Ndarray mat1,Ndarray mat2){
        if (!Arrays.equals(mat1.shape, mat2.shape)){
            System.out.println("Erreur: Les matrices n'ont pas les mêmes dimensions");
            return null;
        }
        double[][] res = new double[mat1.shape[0]][mat1.shape[1]];
        int rows = mat1.shape[0];
        int cols = mat1.shape[1];
        for (int i = 0; i< rows;i++){
            for (int j = 0; j < cols ; j++){
                res[i][j] = mat1.data[i][j] - mat2.data[i][j];
            }
        }
        return new Ndarray(res,mat1.size,mat1.ndim,mat1.shape);
    }
    public static Ndarray mul(Ndarray mat1, Ndarray mat2){

        int rows1 = mat1.shape[0];
        int cols1 = mat1.shape[1];
        int rows2 = mat2.shape[0];
        int cols2 = mat2.shape[1];
        double[][] res = new double[rows1][cols2];
        int[] newshape = {rows1,rows2};
        int newsize = calcSize(newshape);
        for(int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    res[i][j] += mat1.data[i][k] * mat2.data[k][j];
                }
            }
        }
        //TODO calculer la bonne dimension
        return new Ndarray(res,newsize,mat1.ndim,newshape);
    }




}