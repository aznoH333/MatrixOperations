package cz.educanet.tranformations;

import jdk.swing.interop.DragSourceContextWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private IMatrix a;
    private IMatrix b;
    private IMatrix c;
    private IMatrix d;
    private IMatrix empty;

    @Before
    public void setUp() throws Exception {
        double[][] rawA = {
                {1, 1, 1},
                {1, 1, 1},
        };
        a = MatrixFactory.create(rawA);

        double[][] rawB = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        b = MatrixFactory.create(rawB);
        double[][] rawC = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        c = MatrixFactory.create(rawC);

        double[][] rawEmpty = {};
        empty = MatrixFactory.create(rawEmpty);

        double[][] rawD = {
                {1, 1}
        };
        d = MatrixFactory.create(rawD);
    }

    @Test
    public void getRows() {
        assertEquals(2, a.getRows());
        assertEquals(3, b.getRows());
        assertEquals(3, c.getRows());
        assertEquals(0, empty.getRows());
    }

    @Test
    public void getColumns() {
        assertEquals(3, a.getColumns());
        assertEquals(3, b.getColumns());
        assertEquals(3, c.getColumns());
        assertEquals(0, empty.getColumns());
        assertEquals(2, d.getColumns());
    }

    @Test
    public void times() {
        double[][] test ={
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0},
        };

        assertArrayEquals(test,b.times(c).getRawArray());
    }

    @Test
    public void timesScalar() {
        assertArrayEquals(a.getRawArray(),a.times(1.0).getRawArray());

        double[][] testB = {
                {2, 2, 2},
                {2, 2, 2},
                {0, 0, 0},
        };

        assertArrayEquals(testB,b.times(2.0).getRawArray());

        double[][] testC = {
                {2.5, 0, 0},
                {0, 2.5, 0},
                {0, 0, 2.5},
        };

        assertArrayEquals(testC,c.times(2.5).getRawArray());
    }

    @Test
    public void add() {
        double[][] test = {
                {2, 1, 1},
                {1, 2, 1},
                {0, 0, 1},
        };
        assertArrayEquals(test,b.add(c).getRawArray());

    }

    @Test
    public void get() {
        assertEquals(1.0,a.get(1,1),0);
        assertEquals(0,b.get(0,2),0);
        assertEquals(0,b.get(1,2),0);
    }

    @Test
    public void transpose() {
    }

    @Test
    public void determinant() {
    }
}
