package ec.edu.espe.accountingsystem.exception;

/**
 *
 * 
 * @author Sebastian Charij
 */

public class InvalidIdentityCardException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidIdentityCardException(String message) {            
        super(message);
    }

    public InvalidIdentityCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getErrorCode() {
        return 1001; // Un código de error arbitrario
    }

    public static void validateIdentityCard(String identityCard) throws InvalidIdentityCardException {
        if (!isValid(identityCard)) {
            throw new InvalidIdentityCardException("La cédula de identidad es inválida: " + identityCard);
        }
    }

    private static boolean isValid(String identityCard) {
        // Implementa la lógica de validación aquí
        return true; // Cambia esto según la lógica de validación
    }
}