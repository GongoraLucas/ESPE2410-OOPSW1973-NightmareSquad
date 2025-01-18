package ec.edu.espe.accountingsystem.model;

import java.util.HashMap;
import utils.JsonFileManager;

/**
 *
 * @author Lucas Gongora
 */
public class ConversionsRecord {

    JsonFileManager conversions;

    public ConversionsRecord(String conversionsFile) {
        this.conversions = new JsonFileManager(conversionsFile);
    }

    public void add(String sourceUnit, String targetUnit, float conversionFactor) {
        conversions.addItemInMap(sourceUnit, targetUnit, conversionFactor);
    }

    public HashMap<String, HashMap<String, Float>> getConversions() {
        return conversions.readItemsFromMap();
    }

    public void deleteSourceUnit(String sourceUnit) {
        conversions.deleteKeyInMap(sourceUnit);

    }

    public void deleteTargetUnit(String sourceUnit, String targetUnit) {
        conversions.deleteSubkeyInMap(sourceUnit, targetUnit);

    }

    public void updateTargetUnit(String sourceUnit, String targetUnit, float factorConversion) {
        conversions.updateSubkeyInMap(sourceUnit, targetUnit, factorConversion);

    }

}
