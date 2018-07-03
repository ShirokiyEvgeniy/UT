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
}