package by.epam.trainingrpa.triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tstDetectTriangle {

    @DataProvider(name = "dataProviderForRectangular")
    public Object[][] dataForDetectionRectangularTriangles() {
        return new Object[][]
                {
                        {3.0, 4.0, 5.0},
                        {4.0, 5.0, 3.0},
                        {5.0, 3.0, 4.0},
                        {3.0 * Double.MAX_VALUE, 4.0 * Double.MAX_VALUE, 5.0 * Double.MAX_VALUE},
                        {0.6 * Double.MAX_VALUE, 0.8 * Double.MAX_VALUE, Double.MAX_VALUE},
                        {3.0 * Math.pow(10.0, -100.0), 4.0 * Math.pow(10.0, -100.0), 5.0 * Math.pow(10.0, -100.0)}
                };
    }

    @Test(dataProvider = "dataProviderForRectangular")
    public void tstRectangularTriangle(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_RECTANGULAR);
    }

    @DataProvider(name = "dataProviderForEquilateral")
    public Object[][] dataForEquilateralTriangles() {
        return new Object[][]
                {
                        {3.0, 3.0, 3.0},
                        {0.3, 0.3, 0.3}
                };
    }

    @Test(dataProvider = "dataProviderForEquilateral")
    public void tstEquilateralTriangle(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_EQUILATERAL + tr.TR_ISOSCELES);
    }

    @DataProvider(name = "dataProviderForIsosceles")
    public Object[][] dataForIsoscelesTriangles() {
        return new Object[][]
                {
                        {3.0, 4.0, 3.0},
                        {4.0, 3.0, 3.0},
                        {3.0, 3.0, 4.0}
                };
    }

    @Test(dataProvider = "dataProviderForIsosceles")
    public void tstIsoscelesTriangle(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_ISOSCELES);
    }

    @DataProvider(name = "dataProviderForOrdinary")
    public Object[][] dataForOrdinaryTriangles() {
        return new Object[][]
                {
                        {17.0, 16.0, 2.0},
                        {Math.pow(0.21, 100.0), Math.pow(0.211, 100.0), Math.pow(0.212, 100.0)},
                        {18.99999, 19.0, 19.00001}
                };
    }

    @Test(dataProvider = "dataProviderForOrdinary")
    public void tstOrdinaryTriangle(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_ORDYNARY);
    }

    @DataProvider(name = "dataProviderForRectAndIsos")
    public Object[][] dataForRectAndIsosTriangles() {
        return new Object[][]
                {
                        {4.0, 4.0, 4.0 * Math.sqrt(2.0)},
                        {6.0 * Math.sqrt(2.0), 6.0 * Math.sqrt(2.0), 12.0}
                };
    }

    @Test(dataProvider = "dataProviderForRectAndIsos")
    public void tstRectAndIsosTriangle(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertEquals(tr.detectTriangle(), tr.TR_ISOSCELES + tr.TR_RECTANGULAR);
    }
}