package ec.edu.espe.accountingsystem.view;

import ec.edu.espe.accountingsystem.model.Client;
import ec.edu.espe.accountingsystem.model.IdentityCard;
import ec.edu.espe.accountingsystem.model.Inventory;
import ec.edu.espe.accountingsystem.model.MeasuredItem;
import ec.edu.espe.accountingsystem.model.Price;
import ec.edu.espe.accountingsystem.model.Product;
import ec.edu.espe.accountingsystem.model.Supplier;
import ec.edu.espe.accountingsystem.model.Transaction;
import ec.edu.espe.accountingsystem.model.TransactionsRecord;
import ec.edu.espe.accountingsystem.model.Voucher;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Lucas Gongora
 * @author Sebastian Charij
 * @author Andrés Espinosa
 */
public class AccountingSystemApp {

    public static void main(String[] args) {
        System.out.println("Accounting System Project");
        ArrayList<Product> products;

        products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product milkChocolate;
            Price priceMilkChocolate;
            MeasuredItem measuredItemMilkChocolate;

            Inventory inventory;

            measuredItemMilkChocolate = new MeasuredItem("funda", 2f + i, "lb");
            priceMilkChocolate = new Price(1.7f + i, 1.5f + i, 1.4f + i);
            milkChocolate = new Product("1" + (i + 1), "chocolate" + (i + 1), "milkChocolate" + (i + 1), priceMilkChocolate, 40 + i, measuredItemMilkChocolate);
            products.add(milkChocolate);
        }
        Inventory inventory = new Inventory(products);

        Client client;
        IdentityCard identityCard;

        identityCard = new IdentityCard("RUC", "111122");
        client = new Client("mayorista", "1", "nose", identityCard, "Av.nose", "0933232", "ssad@asdsa.com");

        Supplier supplier;
        IdentityCard identityCard2;

        identityCard2 = new IdentityCard("RUC", "1111223333");
        supplier = new Supplier("mayorista", "1", "nose", identityCard2, "Av.nose", "0933232", "ssad@asdsa.com");

        Voucher voucher;
        Date date;
        date = new Date();
        voucher = new Voucher("invoice", 1, date, products, client, supplier, 0.15f, "transferencia");
        
        Transaction transaction;
        ArrayList<Transaction> transactions;
        
        transactions = new ArrayList<>();
        
        transaction = new Transaction("1", "sale", voucher, "pagado");
        transactions.add(transaction);
        
        TransactionsRecord record;
        record = new TransactionsRecord(transactions);

        inventory.viewProductsForConsole();
        System.out.println("------------------------------------------------------------");
        voucher.generateVoucherForConsole();
         System.out.println("------------------------------------------------------------");
        record.viewTransactionsByTypeForConsole("compra");
         System.out.println("------------------------------------------------------------");
        record.viewTransactionsForConsole();
        
        
        
        
        

//        Scanner scanner = new Scanner(System.in);
//        int opcion;
//
//        do {
//            System.out.println("---- Menu Principal ----");
//            System.out.println("1. Gestion de Clientes");
//            System.out.println("2. Gestion de Proveedores");
//            System.out.println("3. Gestion de Productos");
//            System.out.println("4. Gestion de Precios");
//            System.out.println("5. Gestion de Compras");
//            System.out.println("6. Gestion de Ventas");
//            System.out.println("7. Gestion de Transacciones");
//            System.out.println("8. Gestion de Identificaciones");
//            System.out.println("9. Gestion de Vouchers");
//            System.out.println("10. Salir");
//            System.out.print("Seleccione una opcion: ");
//            opcion = scanner.nextInt();
//            scanner.nextLine(); // Limpiar el buffer
//
//            switch (opcion) {
//                case 1:
//                    // Lógica para gestión de clientes
//                    //gestionarClientes(scanner);
//                    break;
//                case 2:
//                    // Lógica para gestión de proveedores
//                    //gestionarProveedores(scanner);
//                    break;
//                case 3:
//                    // Lógica para gestión de productos
//                    //gestionarProductos(scanner);
//                    break;
//                case 4:
//                    // Lógica para gestión de precios
//                    //gestionarPrecios(scanner);
//                    break;
//                case 5:
//                    // Lógica para gestión de compras
//                    //gestionarCompras(scanner);
//                    break;
//                case 6:
//                    // Lógica para gestión de ventas
//                    //gestionarVentas(scanner);
//                    break;
//                case 7:
//                    // Lógica para gestión de transacciones
//                    //gestionarTransacciones(scanner);
//                    break;
//                case 8:
//                    // Lógica para gestión de identificaciones
//                    //gestionarIdentificaciones(scanner);
//                    break;
//                case 9:
//                    // Lógica para gestión de vouchers
//                    //gestionarVouchers(scanner);
//                    break;
//                case 10:
//                    System.out.println("Saliendo del programa...");
//                    break;
//                default:
//                    System.out.println("Opción no valida. Intente de nuevo.");
//            }
//        } while (opcion != 10);
//        scanner.close();

    }
}