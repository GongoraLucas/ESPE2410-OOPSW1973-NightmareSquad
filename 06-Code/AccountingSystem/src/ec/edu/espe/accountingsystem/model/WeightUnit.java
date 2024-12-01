package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Andrés Espinosa
 */
public class WeightUnit {
    private float value;
    private String unit;

    @Override
    public String toString() {
        return "Convertion{" + "value=" + value + ", unit=" + unit + '}';
    }

    public WeightUnit(float value, String unit) {
        this.value = value;
        this.unit = unit;
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
    public void convertUnit(WeightUnit weightUnit){
        if("kg".equals(weightUnit.unit)){
            this.value = weightUnit.value*2.2046F;
            this.unit = "lb";
        }
        else{
            this.value = weightUnit.value*0.4536F;
            this.unit = "kg";
        }
    }

}