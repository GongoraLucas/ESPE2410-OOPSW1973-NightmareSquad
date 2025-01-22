package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.model.Record;
import java.util.HashMap;


/**
 *
 * @author Lucas Gongora
 */
public class ConversionsRecord extends Record {

    private static final String COLLECTION = "conversions";

    public ConversionsRecord() {
        super();
    }

    public boolean add(String sourceUnit, String targetUnit, float conversionFactor) {
        boolean successfulAddition= super.getDatabase().addItemInMap(COLLECTION, sourceUnit, targetUnit, conversionFactor);
        return successfulAddition;
    }

    public HashMap<String, HashMap<String, Float>> getConversions() {
       
        return super.getDatabase().readItemsFromMap(COLLECTION);
    }

    public boolean deleteSourceUnit(String sourceUnit) {
        return super.getDatabase().deleteKeyInMap(COLLECTION, sourceUnit);

    }

    public boolean deleteTargetUnit(String sourceUnit, String targetUnit) {
        return super.getDatabase().deleteSubkeyInMap(COLLECTION, sourceUnit, targetUnit);

    }

    public boolean updateTargetUnit(String sourceUnit, String targetUnit, float factorConversion) {
        return super.getDatabase().addItemInMap(COLLECTION, sourceUnit, targetUnit, factorConversion);

    }

}
