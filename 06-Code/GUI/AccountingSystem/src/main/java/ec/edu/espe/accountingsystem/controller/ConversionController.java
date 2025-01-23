package ec.edu.espe.accountingsystem.controller;

import ec.edu.espe.accountingsystem.model.ConversionsRecord;
import ec.edu.espe.accountingsystem.model.ConverterUnits;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Lucas Gongora
 */
public class ConversionController {

    private ConversionsRecord conversionsRecord;

    public ConversionController() {
        this.conversionsRecord = new ConversionsRecord();
    }

    public Set<String> getSourceUnits() {

        Set<String> sourceUnits = this.conversionsRecord.getConversions().keySet();

        if (sourceUnits == null) {
            return new HashSet();
        }

        return sourceUnits;
    }

    public ArrayList<String> getFinalUnits(String sourceUnit) {
        ArrayList<String> finalUnits = new ArrayList<>();
        HashMap<String, Float> subunits = this.conversionsRecord.getConversions().get(sourceUnit);
        if (subunits == null) {
            return finalUnits;
        }
        Set<String> subkeys = subunits.keySet();
        for (String subkey : subkeys) {
            finalUnits.add(subkey);
        }
        return finalUnits;
    }

    public boolean createConversion(String sourceUnit, String finalUnit, Float conversionFactor) {
        
           return  this.conversionsRecord.add(sourceUnit, finalUnit, conversionFactor);
           

    }

    public float conversion(float value, String sourceUnit, String finalUnit) {
        float newValue;

        newValue = ConverterUnits.convertUnit(value, sourceUnit, finalUnit);
        ConverterUnits.listAvailableConversions();

        return newValue;

    }

    public boolean updateConversion(String sourceUnit, String finalUnit, String inputNewConversionFactor) {
        boolean successfullUpdating = false;
        boolean sourceUnitValidation = sourceUnit == null || sourceUnit.isEmpty();
        boolean finalUnitValidation = finalUnit == null || finalUnit.isEmpty();
        if (sourceUnitValidation || finalUnitValidation) {
            return false;
        }
        try {
            float conversionFactor = Float.parseFloat(inputNewConversionFactor);
            successfullUpdating = this.conversionsRecord.updateTargetUnit(sourceUnit, finalUnit, conversionFactor);
            return successfullUpdating;

        } catch (NumberFormatException ex) {
            System.err.println("conversionFactor must be a floating number");
            return false;
        }
    }

    public boolean deleteSubUnit(String sourceUnit, String finalUnit) {
        boolean successfullUpdating = false;
        boolean sourceUnitValidation = sourceUnit == null || sourceUnit.isEmpty();
        boolean finalUnitValidation = finalUnit == null || finalUnit.isEmpty();
        if (sourceUnitValidation || finalUnitValidation) {
            return false;
        }
        successfullUpdating = this.conversionsRecord.deleteTargetUnit(sourceUnit, finalUnit);
        return successfullUpdating;

    }
    
    public boolean deleteUnit(String sourceUnit){
        boolean successfullUpdating = false;
        boolean sourceUnitValidation = sourceUnit == null || sourceUnit.isEmpty();
        if (sourceUnitValidation) {
            return false;
        }
        successfullUpdating = this.conversionsRecord.deleteSourceUnit(sourceUnit);
        return successfullUpdating;
    }
    
    public float getConversionFactor(String sourceUnit, String finalUnit){
        return this.conversionsRecord.getConversions().get(sourceUnit).get(finalUnit);
    }

}
