package by.epam.trainingrpa.triangle;

import org.testng.Assert;
import org.testng.annotations.Test;

public class tstCheckTriangle {

    @Test
    public void tstSideCLessThan0() {
        Triangle tr = new Triangle(4.0, 2.0, -2.0);

        Assert.assertTrue(tr.checkTriangle());
    }
}
