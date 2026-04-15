package com.im2ag.m1info.ndarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ndarray {

    /**
     * La variable contenant notre matrice
     */
    double[][] data; // J'ai pas encore cherché pour gerer à 2 dimensions
    /**
     * Le nombre total d'élements dans la matrice
     */
    int size;
    /**
     * Le nombre de dimensions
     */
    int ndim;
    /**
     * Les dimensions de la matrice
     */
    int[] shape;

    public Ndarray(double[][] data_in,int size_in,  int ndim_in, int[] shape_in ) {

        this.data = new double[shape_in[0]][shape_in[1]];
        this.data = data_in.clone();
        this.size = size_in;
        this.ndim = ndim_in;
        this.shape = shape_in;

    }

<<<<<<< HEAD
    /**
     * <p>Fonction d'addition equivalente à l'opérateur +=
     * L'opération est faite sur objet appelant la methode
     * Les matrices doivent avoir la même dimension sinon une exception IncorrectDimension est levée
     * </p>
     * @param array_in La matrice qui sera additionnée
     */
=======
    // Met la matrice "à plat"
    public void ravel() {
        int[] new_shape = new int[2];
        new_shape[0] = 1;
        new_shape[1] = shape[0] * shape[1];
        double[][] new_data = new double[new_shape[0]][new_shape[1]];
        for(int i = 0; i < shape[0]; i++) {
            for(int j = 0; j < shape[1]; j++) {
                new_data[0][i*shape[1] + j] = data[i][j];
            }
        }
        data = new_data;
        shape[0] = new_shape[0];
        shape[1] = new_shape[1];
    }

    // Change la forme de la matrice
    public void reshape(int axe1, int axe2) {
        double[][] new_data = new double[axe1][axe2];
        for (int i = 0; i < axe1; i++) {
            for (int j = 0; j < axe2; j++) {
                new_data[i][j] = data[0][i*axe2 + j];
            }
        }
        shape[0] = axe1;
        shape[1] = axe2;
        data = new_data;
    }
>>>>>>> 9640ec3 (ajout des fonctions ravel et reshape)

    public void add(Ndarray array_in){
        if (!Arrays.equals(this.shape, array_in.shape)){
            throw new IncorrectDimension("Erreur: Les matrices n'ont pas les mêmes dimensions");

        }
        int rows = this.shape[0];
        int cols = this.shape[1];
        for (int i = 0; i< rows;i++){
            for (int j = 0; j < cols ; j++){
                this.data[i][j]+= array_in.data[i][j];
            }
        }
    }

    /**
     * <p>Fonction de soustraction equivalente à l'opérateur -=
     * L'opération est faite sur objet appelant la methode
     * Les matrices doivent avoir la même dimension sinon une exception IncorrectDimension est levée
     * </p>
     * @param array_in La matrice qui sera soustrée
     */
    public void sub(Ndarray array_in){
        if (!Arrays.equals(this.shape, array_in.shape)){
            throw new IncorrectDimension("Erreur: Les matrices n'ont pas les mêmes dimensions");

        }
        int rows = this.shape[0];
        int cols = this.shape[1];
        for (int i = 0; i< rows;i++){
            for (int j = 0; j < cols ; j++){
                this.data[i][j]-= array_in.data[i][j];
            }
        }
    }

    /**
     * <p>Fonction de multiplication equivalente à l'opérateur *=
     * L'opération est faite sur objet appelant la methode
     * Les matrices doivent avoir la même dimension en m et p sinon une exception IncorrectDimension est levée
     * mat1(m,n)*mat2(n,p) = mat1(m,p)
     * </p>
     * @param array_in La matrice qui sera multipliée
     */
    public void mul(Ndarray array_in){
        if (this.shape[1] != array_in.shape[0]){
            throw new IncorrectDimension("Erreur: Les matrices n'ont pas les mêmes dimensions");
        }
        int rows1 = this.shape[0];
        int cols1 = this.shape[1];
        int rows2 = array_in.shape[0];
        int cols2 = array_in.shape[1];
        double[][] res = new double[rows1][cols2];

        int[] newshape = {rows1,cols2};
        int newsize = Numja.calcSize(newshape);
        for(int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < rows2; k++) {
                    res[i][j] += this.data[i][k] * array_in.data[k][j];
                }
            }
        }
        //TODO calculer la bonne dimension
        this.shape = newshape;
        this.size = newsize;
        this.data = res;
    }

    /**
     * <p>Fonction qui retourne une chaine de caractère représentant la matrice. Utilisée ensuite pour print
     * </p>
     * @return Une String représentant l'affichage de la matrice
     */
    public String print(){
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

        return (str);
    }

    int getSize() {
        return size;
    }

}