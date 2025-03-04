package ec.edu.espe.accountingsystem.model;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Lucas Gongora
 */
public abstract class Menu {

    public Scanner scanner;
    private boolean executionMenu;
    private int option;

    public Menu() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
        this.executionMenu = true;
        this.option = 0;
    }

    /**
     * @return the scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param scanner the scanner to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @return the executionMenu
     */
    public boolean isExecutionMenu() {
        return executionMenu;
    }

    /**
     * @param executionMenu the executionMenu to set
     */
    public void setExecutionMenu(boolean executionMenu) {
        this.executionMenu = executionMenu;
    }

    /**
     * @return the option
     */
    public int getOption() {
        return option;
    }

    /**
     * @param option the option to set
     */
    public void setOption(int option) {
        this.option = option;
    }

    public int getUserInput() {
        int userInput = 0;
            try {
                System.out.print("Please, press a option number: ");
                userInput = scanner.nextInt(); 
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number."); 
                scanner.nextLine(); 
            }
        return userInput;
    }

    public void run(){
        do {
            showOptions();
            try {
                setOption(getUserInput());
                processOption(getOption());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Press enter to continue");
                getScanner().nextLine();
            }
        } while (isExecutionMenu());
    }

    public abstract void showOptions();

    public abstract void processOption(int option);
}
