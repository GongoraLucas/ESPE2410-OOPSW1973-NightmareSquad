package ec.edu.espe.accountingsystem.view;

import java.util.Scanner;

/**
 *
 * @author Sebastian Charij
 * @author Andrés Espinosa
 */
public class AccountingSystemApp {

    public static void main(String[] args) {
        System.out.println("Accounting System Project");

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---- Menu Principal ----");
            System.out.println("1. Gestion de Clientes");
            System.out.println("2. Gestion de Proveedores");
            System.out.println("3. Gestion de Productos");
            System.out.println("4. Gestion de Precios");
            System.out.println("5. Gestion de Compras");
            System.out.println("6. Gestion de Ventas");
            System.out.println("7. Gestion de Transacciones");
            System.out.println("8. Gestion de Identificaciones");
            System.out.println("9. Gestion de Vouchers");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Lógica para gestión de clientes
                    //gestionarClientes(scanner);
                    break;
                case 2:
                    // Lógica para gestión de proveedores
                    //gestionarProveedores(scanner);
                    break;
                case 3:
                    // Lógica para gestión de productos
                    //gestionarProductos(scanner);
                    break;
                case 4:
                    // Lógica para gestión de precios
                    //gestionarPrecios(scanner);
                    break;
                case 5:
                    // Lógica para gestión de compras
                    //gestionarCompras(scanner);
                    break;
                case 6:
                    // Lógica para gestión de ventas
                    //gestionarVentas(scanner);
                    break;
                case 7:
                    // Lógica para gestión de transacciones
                    //gestionarTransacciones(scanner);
                    break;
                case 8:
                    // Lógica para gestión de identificaciones
                    //gestionarIdentificaciones(scanner);
                    break;
                case 9:
                    // Lógica para gestión de vouchers
                    //gestionarVouchers(scanner);
                    break;
                case 10:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
            }
        } while (opcion != 10);
        scanner.close();
    }
}
