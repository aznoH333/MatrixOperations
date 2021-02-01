package cz.educanet.tranformations;

public class MatrixFactory {

    public static IMatrix create(double[][] data) {
        return new Matrix(data);
    }

}
