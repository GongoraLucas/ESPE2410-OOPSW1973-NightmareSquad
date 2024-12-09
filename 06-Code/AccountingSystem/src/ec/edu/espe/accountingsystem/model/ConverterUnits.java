package ec.edu.espe.accountingsystem.model;

import java.util.HashMap;
import java.util.Map;

public class ConverterUnits {
    
    private static final Map<String, Map<String, Float>> conversionMap = new HashMap<>();

    static {
        Map<String, Float> lbConversions = new HashMap<>();
        Map<String, Float> arrobaConversions = new HashMap<>();

        lbConversions.put("arroba", 0.0667f);
        arrobaConversions.put("lb", 15f);

        conversionMap.put("lb", lbConversions);
        conversionMap.put("arroba", arrobaConversions);
    }
    
    public float convertUnit(float value, String initialUnit, String finalUnit) {
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

 

    public void showAvailableConversions() {
        for (String unit : conversionMap.keySet()) {
            System.out.println("Conversions for " + unit + ":");
            for (String targetUnit : conversionMap.get(unit).keySet()) {
                System.out.println("  " + unit + " -> " + targetUnit + ": " 
                        + conversionMap.get(unit).get(targetUnit));
            }
        }
    }
}
