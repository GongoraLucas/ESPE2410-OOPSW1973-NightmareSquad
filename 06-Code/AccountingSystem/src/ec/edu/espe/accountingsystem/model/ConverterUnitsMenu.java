package ec.edu.espe.accountingsystem.model;

import java.util.Scanner;

public class ConverterUnitsMenu {

    private ConverterUnits converterUnits;
    private Scanner scanner;
    private int option;
    private boolean executionMenu;

    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";
    private static final String SUBHEADER_COLOR = "\u001B[35m";
    private static final String MENU_OPTION_COLOR = "\u001B[32m";
    private static final String ERROR_COLOR = "\u001B[31m";
    private static final String SUCCESS_COLOR = "\u001B[33m";

    public ConverterUnitsMenu() {
        this.converterUnits = new ConverterUnits();
        this.scanner = new Scanner(System.in);
        this.option = 0;
        this.executionMenu = true;
    }

    public void runMenu() {
        do {
            displayMenu();
            try {
                this.option = getUserInput();
                processOption(this.option);
            } catch (Exception e) {
                System.out.println(ERROR_COLOR + "Invalid input. Please enter a number between 1 and 4: " + RESET);
                scanner.nextLine();
            }
        } while (this.executionMenu);
    }

    private void displayMenu() {
        System.out.println(HEADER_COLOR + "\n\t Accounting system \t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Converter" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Convert units" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. View conversion of available units" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Back to the main menu" + RESET);
        System.out.print("Enter the number option: ");
    }

    private int getUserInput() throws Exception {
        int userInput = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (userInput < 1 || userInput > 4) {
            throw new IllegalArgumentException("Option must be between 1 and 4.");
        }
        return userInput;
    }

    private void processOption(int option) {
        switch (option) {
            case 1:
                convertUnits();
                break;
            case 2:
                viewConversionOfAvailableUnits();
                break;
          
            case 3:
                executionMenu = false;
                break;
            default:
                System.out.println(ERROR_COLOR + "Invalid option. Please choose between 1 and 4." + RESET);
        }
    }

    private void convertUnits() {
        try {
            System.out.print("Enter the value to convert: ");
            float value = scanner.nextFloat();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter the initial unit: ");
            String initialUnit = scanner.nextLine();

            System.out.print("Enter the final unit: ");
            String finalUnit = scanner.nextLine();

            float result = converterUnits.convertUnit(value, initialUnit, finalUnit);
            System.out.println("The value in " + finalUnit + " is: " + result);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error during conversion: " + e.getMessage() + RESET);
        }
    }

    private void viewConversionOfAvailableUnits() {
        try {
            converterUnits.listAvailableConversions();
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error displaying conversions: " + e.getMessage() + RESET);
        }
    }

    
}
