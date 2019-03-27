package main.Utility;

import java.util.Random;

public class Utility {

    public static double randomNumberInASetRange(double rangeMin, double rangeMax) {
        
        Random random = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        return randomValue;
    }
}
