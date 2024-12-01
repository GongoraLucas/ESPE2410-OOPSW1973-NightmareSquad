package ec.edu.espe.accountingsystem.model;

import static ec.edu.espe.accountingsystem.controller.WeightConverter.convertFromArrobaToPound;
import static ec.edu.espe.accountingsystem.controller.WeightConverter.convertFromPoundToArroba;

/**
 *
 * @author Andrés Espinosa
 */
public class MeasuredItem {

    private String description;
    private float value;
    private String unit;

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
        if (finalUnit == this.getUnit()) {
            return;
        }
        
        switch (this.getUnit()) {
            case "lb":
                switch (finalUnit) {
                    case "arroba":
                        this.setValue(convertFromPoundToArroba(this.getValue()));
                        break;

                    default:
                        return;
                }
                break;
            case "arroba":
                switch (finalUnit) {
                    case "lb":
                        this.setValue(convertFromArrobaToPound(this.getValue()));
                        break;

                    default:
                        return;
                }
                break;
                
        }
    }

}
