package ec.edu.espe.accountingsystem.exception;

public class InvalidTypeCustomer extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidTypeCustomer() {
        super("Invalid customer type");
    }

    public InvalidTypeCustomer(String message) {
        super(message);
    }

    public InvalidTypeCustomer(String message, Throwable cause) {
        super(message, cause);
    }

    public static void validateCustomerType(String customerType) throws InvalidTypeCustomer {
        String[] validTypes = {"Regular", "Premium", "VIP"};
        boolean isValid = false;

        for (String type : validTypes) {
            if (type.equalsIgnoreCase(customerType)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new InvalidTypeCustomer("El tipo de cliente '" + customerType + "' no es válido. " +
                                           "Tipos válidos son: Regular, Premium, VIP.");
        }
    }

    public int getErrorCode() {
        return 2001;
    }

    @Override
    public String toString() {
        return "InvalidTypeCustomer: " + getMessage() + " [Error Code: " + getErrorCode() + "]";
    }
}

