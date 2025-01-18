package ec.edu.espe.accountingsystem.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterUnitsMenu extends Menu {

    private ConversionsRecord conversionsRecord;

    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";
    private static final String SUBHEADER_COLOR = "\u001B[35m";
    private static final String MENU_OPTION_COLOR = "\u001B[32m";
    private static final String ERROR_COLOR = "\u001B[31m";
    private static final String SUCCESS_COLOR = "\u001B[33m";

    public ConverterUnitsMenu() {
        super();
        this.conversionsRecord = new ConversionsRecord("conversions.json");
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\t Accounting system \t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Converter" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Convert units" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. View conversion of available units" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Add conversion" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Delete  list of conversion" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Delete conversion" + RESET);
        System.out.println(MENU_OPTION_COLOR + "6. Update conversion" + RESET);
        System.out.println(MENU_OPTION_COLOR + "7. Back to main menu" + RESET);
    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                convertUnits();
                break;
            case 2:
                viewConversionOfAvailableUnits();
                break;
            case 3:
                addConversion();
                break;
            case 4:
                deleteAllConversionOfAUnit();
                break;
            case 5:
                deleteTargetUnit();
                break;
            case 6:
                updateConversion();
                break;
            case 7:
                super.setExecutionMenu(false);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 7.");
        }
    }

    private void convertUnits() {
        try {
            System.out.print("Enter the value to convert: ");
            float value = super.getScanner().nextFloat();
            super.getScanner().nextLine();

            System.out.print("Enter the initial unit: ");
            String initialUnit = super.getScanner().nextLine();

            System.out.print("Enter the final unit: ");
            String finalUnit = super.getScanner().nextLine();

            float result = ConverterUnits.convertUnit(value, initialUnit, finalUnit);
            System.out.println("The value in " + finalUnit + " is: " + result);
        } catch (InputMismatchException ex) {
            System.out.println(ERROR_COLOR + "Error during conversion: " + ex.getMessage() + RESET);
        }
    }

    private void viewConversionOfAvailableUnits() {
        try {
            ConverterUnits.listAvailableConversions();
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error displaying conversions: " + e.getMessage() + RESET);
        }
    }

    private void addConversion() {
        String sourceUnit;
        String targetUnit;
        float conversionFactor;

        try {
            System.out.print("Enter from source unit: ");

            sourceUnit = super.getScanner().nextLine();

            System.out.print("Enter the unit you want to convert");
            targetUnit = super.getScanner().nextLine();
            System.out.print("Enter the conversion factor");
            conversionFactor = super.getScanner().nextFloat();
            super.getScanner().nextLine();

            conversionsRecord.add(sourceUnit, targetUnit, conversionFactor);
        } catch (InputMismatchException ex) {
            System.out.println("Enter the correct conversionFactor");
        }

    }

    public void deleteAllConversionOfAUnit() {
        String sourceUnit;

        System.out.print("Enter from source unit: ");

        sourceUnit = super.getScanner().nextLine();

        conversionsRecord.deleteSourceUnit(sourceUnit);

    }

    public void deleteTargetUnit() {
        String sourceUnit;
        String targetUnit;

        System.out.print("Enter from source unit: ");
        sourceUnit = super.getScanner().nextLine();
        System.out.print("Enter the target unit: ");
        targetUnit = super.getScanner().nextLine();

        conversionsRecord.deleteTargetUnit(sourceUnit, targetUnit);

    }

    public void updateConversion() {
        String sourceUnit;
        String targetUnit;
        float conversionFactor;

        try {

            System.out.print("Enter from source unit: ");

            sourceUnit = super.getScanner().nextLine();

            System.out.print("Enter the unit you want to convert: ");
            targetUnit = super.getScanner().nextLine();
            System.out.print("Enter the conversion factor: ");
            conversionFactor = super.getScanner().nextFloat();
            super.getScanner().nextLine();

            conversionsRecord.updateTargetUnit(sourceUnit, targetUnit, conversionFactor);

        } catch (InputMismatchException ex) {
            System.out.println("Enter the correct conversion factor");
            
        }
    }

}
