package com.company;

public class SquareMatrix extends Matrix {
    int size;
    double[][] m;
    public SquareMatrix(int size) {
        super(size, size);
    }
    public double det(double[][] minor) {
        double calcResult = 0.0;
        if (size == 2) {
            calcResult = m[0][0] * m[1][1] - m[1][0] * m[0][1];
        } else {
            int koeff;
            for (int i = 0; i < size; i++) {
                if (i % 2 == 1) {
                    koeff = -1;
                } else {
                    koeff = 1;
                }
                calcResult += koeff * m[0][i] * this.det(this.minor(m, i));
            }
        }
        return calcResult;
    }

    private double[][] minor(double[][] m, int column) {
        int minorLength = size - 1;
        double[][] minor = new double[minorLength][minorLength];
        int dI = 0;
        int dJ;
        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == 0) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor[i - dI][j - dJ] = m[i][j];
                    }
                }
            }
        }
        return minor;
    }
}