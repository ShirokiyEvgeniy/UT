package by.epam.trainingrpa.triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tstGetSquare {

    @DataProvider(name = "dataProviderForRegular")
    public Object[][] dataForRegular() {
        return new Object[][]
                {
                        {4.0, 5.0, 3.0},
                        {0.3, 0.4, 0.5},
                        {17.0, 1.0, 17.0}
                };
    }

    @Test
    public void tstRegularCheck1() {
        Triangle tr = new Triangle(3.0, 4.0, 5.0);
        Assert.assertEquals(tr.getSquare(), 6.0);
    }

    @Test
    public void tstRegularCheck2() {
        Triangle tr = new Triangle(0.3, 0.4, 0.5);
        Assert.assertEquals(tr.getSquare(), 0.06);
    }

    @Test
    public void tstRegularCheck3() {
        Triangle tr = new Triangle(0.6, 0.8, 1.0);
        Assert.assertEquals(tr.getSquare(), 0.24);
    }

    @DataProvider(name = "dataProviderForNaN")
    public Object[][] dataForNaN() {
        return new Object[][]
                {
                        {4.0, 5.0, -10.0},
                        {0.3, 0.4, 0.1}
                };
    }

    @Test(dataProvider = "dataProviderForNaN")
    public void tstNaNResult(double a, double b, double c) {
        Triangle tr = new Triangle(a, b, c);
        Assert.assertNotEquals(tr.getSquare(), Double.NaN);
    }
}
