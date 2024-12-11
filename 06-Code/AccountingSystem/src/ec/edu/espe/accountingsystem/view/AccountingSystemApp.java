package ec.edu.espe.accountingsystem.view;

import ec.edu.espe.accountingsystem.model.Access;
import ec.edu.espe.accountingsystem.model.AdministratorMenu;
/**
 * @author Lucas Gongora
 * @author Sebastian Charij
 * @author Andrés Espinosa
 * @author David Cuichan
 */
public class AccountingSystemApp {

    public static void main(String[] args){
        
        Access access;
        access = new Access();
        access.runMenu();
    }  
}


