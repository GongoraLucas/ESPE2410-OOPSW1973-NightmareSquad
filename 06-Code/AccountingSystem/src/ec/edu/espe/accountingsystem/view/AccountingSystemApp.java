package ec.edu.espe.accountingsystem.view;

import ec.edu.espe.accountingsystem.model.MainMenu;
/**
 * @author Lucas Gongora
 * @author Sebastian Charij
 * @author Andrés Espinosa
 * @author David Cuichan
 */
public class AccountingSystemApp {

    public static void main(String[] args){
        
        MainMenu mainMenu;
        
        mainMenu = new MainMenu();
        
        mainMenu.runMenu();
    }  
}


