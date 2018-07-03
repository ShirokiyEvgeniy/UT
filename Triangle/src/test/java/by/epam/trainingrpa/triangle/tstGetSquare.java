package by.epam.trainingrpa.triangle;

import org.testng.Assert;
import org.testng.annotations.Test;

public class tstGetSquare {

    @Test
    public void tstRegularCheck() {
        Triangle tr = new Triangle(3.0, 4.0, 5.0);
        Assert.assertEquals(tr.getSquare(), 6.0);
    }

    @Test
    public void tstPerimeterLessThan0() {
        Triangle tr = new Triangle(4.0, 5.0, -10.0);
        Assert.assertNotEquals(tr.getSquare(), Double.NaN);
    }
}
