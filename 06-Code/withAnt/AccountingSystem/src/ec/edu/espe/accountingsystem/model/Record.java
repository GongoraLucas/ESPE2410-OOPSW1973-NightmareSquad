package ec.edu.espe.accountingsystem.model;

import utils.JsonFileManager;

/**
 *
 * @author David Cuichan
 */
public abstract class Record <M>{
    protected JsonFileManager jsonManager;
    protected String horizontalLine = "-------------------------------------------------------";

    /**
     * @return the jsonManager
     */
    public JsonFileManager getJsonManager() {
        return jsonManager;
    }

    /**
     * @param jsonManager the jsonManager to set
     */
    public void setJsonManager(JsonFileManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    /**
     * @return the horizontalLine
     */
    public String getHorizontalLine() {
        return horizontalLine;
    }

    /**
     * @param horizontalLine the horizontalLine to set
     */
    public void setHorizontalLine(String horizontalLine) {
        this.horizontalLine = horizontalLine;
    }
}
