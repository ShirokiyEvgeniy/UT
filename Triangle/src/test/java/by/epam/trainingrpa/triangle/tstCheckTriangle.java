package by.epam.trainingrpa.triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tstCheckTriangle {

    @DataProvider(name = "dataProviderForSides")
    public Object[][] dataForSides() {
        return new Object[][]
                {
                        {4.0, 2.0, 0.0},
                        {0.0, 4.0, 2.0},
                        {2.0, 0.0, 4.0},
                        {5.0, 5.0, 10.0}
                };
    }

    @DataProvider(name = "dataProviderForRightSides")
    public Object[][] dataForRightSides() {
        return new Object[][]
                {
                        {3.0, 4.0, 5.0},
                        {5.0, 5.0, 9.99},
                        {4.99, 4.99, 4.99}
                };
    }

    @Test
    public void tstSideCLessThan0() {
        Triangle tr = new Triangle(2.0, 2.0, 0.0);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"c<=0");
    }

    @Test
    public void tstSideBLessThan0() {
        Triangle tr = new Triangle(2.0, 0.0, 2.0);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"b<=0");
    }

    @Test
    public void tstSideALessThan0() {
        Triangle tr = new Triangle(0.0, 2.0, 2.0);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"a<=0");
    }

    @Test(dataProvider = "dataProviderForSides")
    public void tstIrregularTriangles(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertFalse(tr.checkTriangle());
    }

    @Test(dataProvider = "dataProviderForRightSides")
    public void tstRegularTriangles(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertTrue(tr.checkTriangle());
    }
}
