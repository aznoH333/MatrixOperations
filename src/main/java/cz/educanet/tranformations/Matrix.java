package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public double[][] getRawArray() {
        return rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        double[][] out = new double[getRows()][matrix.getColumns()];

        if (getColumns() == matrix.getRows()) {
            for (int y = 0;y < matrix.getColumns();y++){
                for (int x = 0;x < getRows();x++){
                    for (int i = 0;i < getColumns();i++){
                        out[y][x] += get(i,y) * matrix.get(x,i);
                    }
                }
            }

            return new Matrix(out);

        } else {
            System.out.println("hej hej probléme máš tady strážníka");
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public IMatrix times(double scalar) {

        for (int x = 0;x < getColumns();x++){
            for (int y = 0;y < getRows();y++){
                rawArray[y][x] *= scalar;
            }
        }

        return this;
    }

    @Override
    public IMatrix add(IMatrix matrix) {

        if (getRows() == matrix.getRows() && getColumns() == matrix.getColumns()){

            for (int x = 0;x < getColumns();x++){
                for (int y = 0;y < getRows();y++){
                    rawArray[y][x] += matrix.get(x,y);
                }
            }

            return this;
        }else{
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public double get(int n, int m) {
        return rawArray[m][n];
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }
    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(rawArray, matrix.rawArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
