

package ec.edu.espe.accountingsystem.exception;

/**
 *
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class VariablesNotFoundInPathException extends Exception {

    public VariablesNotFoundInPathException() {
        super("Credentials were not found in the system's environment variables");
    }
        
}


