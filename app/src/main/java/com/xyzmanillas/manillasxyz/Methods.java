package com.xyzmanillas.manillasxyz;

public class Methods {

    public static double calculatePrice(double price, double cant, int paymentMethodIndex){
        double result = price * cant;

        if (paymentMethodIndex == 1) { // that means that the user selected "Pesos"
            result*= 3200;
        }

        return result;
    }
}
