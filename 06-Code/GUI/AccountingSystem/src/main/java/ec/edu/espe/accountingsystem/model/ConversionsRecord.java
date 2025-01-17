package ec.edu.espe.accountingsystem.model;

import java.util.HashMap;


/**
 *
 * @author Lucas Gongora
 */
public class ConversionsRecord extends Record {

    private static String collection = "conversions";

    public ConversionsRecord() {
        super();
    }

    public void add(String sourceUnit, String targetUnit, float conversionFactor) {
        super.getDatabase().addItemInMap(collection, sourceUnit, targetUnit, conversionFactor);
    }

    public HashMap<String, HashMap<String, Float>> getConversions() {
        return super.getDatabase().readItemsFromMap(collection);
    }

    public void deleteSourceUnit(String sourceUnit) {
        super.getDatabase().deleteKeyInMap(collection, sourceUnit);

    }

    public void deleteTargetUnit(String sourceUnit, String targetUnit) {
        super.getDatabase().deleteSubkeyInMap(collection, sourceUnit, targetUnit);

    }

    public void updateTargetUnit(String sourceUnit, String targetUnit, float factorConversion) {
        super.getDatabase().addItemInMap(collection, sourceUnit, targetUnit, factorConversion);

    }

}
