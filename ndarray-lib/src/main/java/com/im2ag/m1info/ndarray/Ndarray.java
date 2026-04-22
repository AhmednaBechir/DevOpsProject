package com.im2ag.m1info.ndarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ndarray {
    List l;
    double[][] data; // J'ai pas encore cherché pour gerer à 2 dimensions
    int size;
    int ndim;
    int[] shape;
    String dtype; //Voir faire une enum


    public Ndarray(double[][] data_in,int size_in,  int ndim_in, int[] shape_in ) {

        this.data = new double[shape_in[0]][shape_in[1]];
        this.data = data_in.clone();
        this.size = size_in;
        this.ndim = ndim_in;
        this.shape = shape_in;

    }

    public void reshape(int axe1, int axe2){

    }
    // Fonction d'addition equivalente à l'opérateur +=
    public void add(Ndarray array_in){
        if (!Arrays.equals(this.shape, array_in.shape)){
            System.out.println("Erreur: Les matrices n'ont pas les mêmes dimensions");
            return;
        }
        int rows = this.shape[0];
        int cols = this.shape[1];
        for (int i = 0; i< rows;i++){
            for (int j = 0; j < cols ; j++){
                this.data[i][j]+= array_in.data[i][j];
            }
        }
    }
    // Fonction d'addition equivalente à l'opérateur -=
    public void sub(Ndarray array_in){
        if (!Arrays.equals(this.shape, array_in.shape)){
            System.out.println("Erreur: Les matrices n'ont pas les mêmes dimensions");
            return;
        }
        int rows = this.shape[0];
        int cols = this.shape[1];
        for (int i = 0; i< rows;i++){
            for (int j = 0; j < cols ; j++){
                this.data[i][j]-= array_in.data[i][j];
            }
        }
    }
    // Fonction de multiplication equivalente à l'opérateur *= MAIS ce n'est peut-être utile de garder cette fonction
    public void mul(Ndarray array_in){
        if (!Arrays.equals(this.shape, array_in.shape)){
            System.out.println("Erreur: Les matrices n'ont pas les mêmes dimensions");
            return;
        }
        int rows1 = this.shape[0];
        int cols1 = this.shape[1];
        int rows2 = array_in.shape[0];
        int cols2 = array_in.shape[1];

        // Mutliplying Two matrices

        for(int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    this.data[i][j] += this.data[i][k] * array_in.data[k][j];
                }
            }
        }
    }

    //A modifier pour que ça fonctionne à +2 de dimensions
    public void print(){
        String str ="";
        if (this.shape[0] > 1){
            str = str.concat("[");
        }
        for (int i = 0; i < this.shape[0]; i++){
            str = str.concat(Arrays.toString(this.data[i]));
            if (i < (this.shape[0]-1)){
                str =  str.concat("\n");
            }
        }
        if (this.shape[0] > 1){
            str =  str.concat("]");
        }

        System.out.println(str);
    }

    List getList() {
        return l;
    }

    int getSize() {
        return size;
    }

    int[] getShape() {
        return shape.clone();
    }
}