package com.xyzmanillas.manillasxyz;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void price_calculator_test_for_dollars() {
        double price = 100;
        double cant = 2;
        int paymentMethod = 0; // USD

        assertEquals(Methods.calculatePrice(price, cant, paymentMethod), 200.00, 0);
    }

    @Test
    public void price_calculator_test_for_pesos() {
        double price = 100;
        double cant = 1;
        int paymentMethod = 1; // COP

        assertEquals(Methods.calculatePrice(price, cant, paymentMethod), 320000.00, 0);
    }
}