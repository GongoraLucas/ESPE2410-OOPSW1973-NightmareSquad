

package ec.edu.espe.accountingsystem.exception;

/**
 *
 * @author Lucas Gongora
 */
public class CredentialsNotFoundInPath extends Exception {

    public CredentialsNotFoundInPath() {
        super("Credentials were not found in the system's environment variables");
    }
        
}


