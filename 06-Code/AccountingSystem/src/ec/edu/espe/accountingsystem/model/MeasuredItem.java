package ec.edu.espe.accountingsystem.model;

import static ec.edu.espe.accountingsystem.controller.WeightConverter.convertFromArrobaToPound;
import static ec.edu.espe.accountingsystem.controller.WeightConverter.convertFromPoundToArroba;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class MeasuredItem {

    private String description;
    private float value;
    private String unit;

    private static final Map<String, Map<String, Float>> conversionMap = new HashMap<>();

    static {
        Map<String, Float> lbConversions = new HashMap<>();
        Map<String, Float> arrobaConversions = new HashMap<>();

        lbConversions.put("arroba", 0.0667f);
        arrobaConversions.put("lb", 15f);

        conversionMap.put("lb", lbConversions);
        conversionMap.put("arroba", arrobaConversions);
    }

    @Override
    public String toString() {
        return "MeasuredItem{" + "description=" + description + ", value=" + value + ", unit=" + unit + '}';
    }

    public MeasuredItem(String description, float value, String unit) {
        this.description = description;
        this.value = value;
        this.unit = unit;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void convertUnit(String finalUnit) {
        try {
            if (conversionMap.containsKey(this.unit)) {
                if (conversionMap.get(this.unit).containsKey(finalUnit)) {
                    float conversionFactor = conversionMap.get(this.unit).get(finalUnit);
                    this.value = this.value * conversionFactor;
                } else {
                    throw new IllegalArgumentException("The unit to be converted is not available");
                }
            } else {
                throw new IllegalArgumentException("The item unit is not enabled for conversions at this time");
            }
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        } 
    }

}
