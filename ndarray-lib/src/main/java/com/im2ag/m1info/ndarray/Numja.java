package com.im2ag.m1info.ndarray;

import java.util.Arrays;

abstract public class Numja {


    /**
     * <p>Fonction pour calculer la taille d'une matrice
     * </p>
     * @param shape_in La dimension de la matrice
     * @return Le nombre d'élements dans la matrice
     */
    public static int calcSize(int[] shape_in){
        int size = 1;
        for (int j : shape_in) {
            size *= j;
        }
        return size;
    }

    /**
     * <p>Constructeur d'un Ndarray 1D
     * </p>
     * @param data_in La liste des doubles qui composerons la matrice 1D
     * @return Retourne un objet Ndarray représentant la matrice 1D
     */
    public static Ndarray array(double... data_in){

        double[][] tmp_arr = new double[1][data_in.length];
        int[] shape = new int[2];
        shape[0] = 1;
        shape[1] = data_in.length;
        int newsize = calcSize(shape);
        System.arraycopy(data_in, 0, tmp_arr[0], 0, data_in.length);

        return new Ndarray(tmp_arr,newsize,tmp_arr.length,shape);
    }

    /**
     * <p>Constructeur d'un Ndarray 2D
     * </p>
     * @param data_in La liste des  doubles[] qui composerons la matrice 2D
     * @return Retourne un objet Ndarray représentant la matrice 2D
     */
    public static Ndarray array(double[]... data_in){
        int dimension = data_in.length;
        double[][] tmp_arr = new double[dimension][data_in[0].length];
        int[] shape = new int[2];
        shape[0] = data_in.length;
        shape[1] = data_in[0].length;
        int newsize = calcSize(shape);
        System.arraycopy(data_in, 0, tmp_arr, 0, data_in.length);

        return new Ndarray(tmp_arr,newsize,tmp_arr.length,shape);
    }

    /**
     * <p>Fonctoin de création d'une matrice contenant que des zéros
     * </p>
     * @param shape_in un couple d'Integer représentant la forme de la matrice
     * @return Retourne un objet Ndarray représentant la matrice 1D/2D
     */
    public static Ndarray zeros(int[] shape_in){
        int dimension = shape_in.length;
        int size = calcSize(shape_in);
        int m, n;
        if (shape_in.length == 1){
            if(shape_in[0] == 0){
                m = shape_in[0];
                n = shape_in[0];

            }else {
                m = 1;
                n = shape_in[0];
            }

        } else if (shape_in.length == 2) {
            m = shape_in[0];
            n = shape_in[1];
        }else{
            throw new IncorrectDimension("Erreur de dimension: 1D et 2D pris en charge seulement");
        }

        double[][] tmp_arr = new double[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(tmp_arr[i],0.0);
        }
        return new Ndarray(tmp_arr.clone(),size,dimension,new int[]{m,n});
    }
    /**
     * <p>Fonctoin de création d'une matrice contenant des nombre allant de start à end avec un pas de step
     * </p>
     * @param start le début de la séquancede nombre
     * @param end la fin de la séquance de nombre
     * @param step le pas entre chaque nombre
     * @return Retourne un objet Ndarray représentant la matrice 1D
     */
    public static Ndarray arange(double start, double end, double step){
        if(end > start && step < 0 || end < start && step > 0 ){
            throw new IncorrectDimension("Erreur sur les bornes et le pas");

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

    /**
     * <p>Fonction d'addition equivalente à l'opérateur +     *
     * Les matrices doivent avoir la même dimension sinon une exception IncorrectDimension est levée
     * </p>
     * @param mat1 La matrice 1
     * @param mat2 La matrice 2
     * @return Une matrice Ndarray qui est le résultat de mat1 + mat2
     */
    public static Ndarray add(Ndarray mat1,Ndarray mat2){
        if (!Arrays.equals(mat1.shape, mat2.shape)){
            throw new IncorrectDimension("Erreur: Les matrices n'ont pas les mêmes dimensions");
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
    /**
     * <p>Fonction de soustraction equivalente à l'opérateur +
     * Les matrices doivent avoir la même dimension sinon une exception IncorrectDimension est levée
     * </p>
     * @param mat1 La matrice 1
     * @param mat2 La matrice 2
     * @return Une matrice Ndarray qui est le résultat de mat1 - mat2
     */
    public static Ndarray sub(Ndarray mat1,Ndarray mat2){
        if (!Arrays.equals(mat1.shape, mat2.shape)){
            throw new IncorrectDimension("Erreur: Les matrices n'ont pas les mêmes dimensions");

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

    /**
     * <p>Fonction de multiplication equivalente à l'opérateur *
     * Les matrices doivent avoir la même dimension m et p sinon une exception IncorrectDimension est levée
     * avec mat1(m,n) et mat2(n,p)
     * </p>
     * @param mat1 La matrice 1
     * @param mat2 La matrice 2
     * @return Une matrice Ndarray qui est le résultat de mat1 * mat2
     */
    public static Ndarray mul(Ndarray mat1, Ndarray mat2){
        if (mat1.shape[1] != mat2.shape[0]){
            throw new IncorrectDimension("Erreur: Les matrices n'ont pas les mêmes dimensions");
        }
        int rows1 = mat1.shape[0];
        int cols1 = mat1.shape[1];
        int rows2 = mat2.shape[0];
        int cols2 = mat2.shape[1];
        double[][] res = new double[rows1][cols2];

        int[] newshape = {rows1,cols2};
        int newsize = calcSize(newshape);
        for(int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < rows2; k++) {
                    res[i][j] += mat1.data[i][k] * mat2.data[k][j];
                }
            }
        }
        //TODO calculer la bonne dimension
        return new Ndarray(res,newsize,mat1.ndim,newshape);
    }




}