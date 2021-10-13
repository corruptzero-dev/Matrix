package com.company;

public class Matrix {
    int rows;
    int cols;
    double[][] m;

    public Matrix(int rows, int cols) {
        this.m = new double[rows][cols];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < i; j++) {
                m[i][j] = Math.random();
            }
        }
    }
    void add(Matrix m1) throws Exception {
        if(this.rows == m1.rows && this.cols == m1.rows){
            for (int i = 0; i < m1.m.length; i++) {
                for (int j = 0; j < i; j++) {
                    m1.m[i][j] += this.m[i][j];
                }
            }
        } else {
            throw new Exception("bruh");
        }

    }
    void mult(int num){
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < i; j++) {
                this.m[i][j] *= num;
            }
        }
    }
    void print(){
        for(double[] arr: this.m){
            for(double val: arr){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static Matrix mult(Matrix m1, Matrix m2) throws Exception {
        if (m1.m[0].length != m2.m.length) {
            throw new Exception("bruh");
        }
        Matrix m3 = new Matrix(m1.m.length, m1.m.length);
        for (int i = 0; i < m3.m.length; i++) {
            for (int j = 0; j < m3.m.length; j++) {
                for (int k = 0; k < m3.m.length; k++) {
                    m3.m[i][j] += m1.m[i][k] * m2.m[k][j];
                }
            }
        }
        return m3;
    }
}
