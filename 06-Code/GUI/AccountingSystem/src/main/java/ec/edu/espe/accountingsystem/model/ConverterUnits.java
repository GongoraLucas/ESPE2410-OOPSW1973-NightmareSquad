package ec.edu.espe.accountingsystem.model;

import java.util.HashMap;


public class ConverterUnits {
    private static final ConversionsRecord conversionsRecord = new ConversionsRecord();
    private static final HashMap<String, HashMap<String, Float>> conversionMap = conversionsRecord.getConversions();

    
    
    public static float convertUnit(float value, String initialUnit, String finalUnit) {
        try {
            if (conversionMap.containsKey(initialUnit)) {
                if (conversionMap.get(initialUnit).containsKey(finalUnit)) {
                    float conversionFactor = conversionMap.get(initialUnit).get(finalUnit);
                    return value * conversionFactor;
                } else {
                    throw new IllegalArgumentException("The unit to be converted is not available.");
                }
            } else {
                throw new IllegalArgumentException("The item unit is not enabled for conversions at this time.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0.0f;
    }

 

    public static void listAvailableConversions() {
        for (String unit : conversionMap.keySet()) {
            System.out.println("Conversions for " + unit + ":");
            for (String targetUnit : conversionMap.get(unit).keySet()) {
                System.out.println("  " + unit + " -> " + targetUnit + ": " 
                        + conversionMap.get(unit).get(targetUnit));
            }
        }
    }
}
