package ec.edu.espe.accountingsystem.controller;

/**
 *
 * @author Lucas Gongora
 */
public class WeightConverter {

    public static float convertFromPoundToArroba(float pound) {
        return pound * 0.0667f;
    }

    public static float convertFromArrobaToPound(float arroba) {
        return arroba * 15f;
    }
}
