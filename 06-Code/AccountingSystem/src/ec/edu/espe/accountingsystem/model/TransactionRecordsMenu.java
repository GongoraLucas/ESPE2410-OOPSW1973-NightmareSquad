package ec.edu.espe.accountingsystem.model;


import Utils.JsonFileManager;
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
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Lucas Gongora
 */
public class TransactionRecordsMenu {

    private Scanner scanner;
    private int option;
    private boolean executionMenu;
    private String fileName;
    private JsonFileManager jsonFile;

    public TransactionRecordsMenu() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
        this.option = 0;
        this.executionMenu = true;
        this.fileName = "Transactions.json";
        this.jsonFile = new JsonFileManager(this.fileName);
    }

    public void runMenu() {
        do {
            System.out.println("\tAccounting System\t");
            System.out.println("Transaction record Menu");
            System.out.println("1. Add transacction");
            System.out.println("2. View transacctions");
            System.out.println("3. Update transactions");
            System.out.println("4. Delete transactions");
            System.out.println("5. Back to the main menu");

            System.out.print("Enter the number option: ");
            this.option = this.scanner.nextInt();
            this.scanner.nextLine();

            switch (this.option) {

                case 1:
                    addTransaction();

                    break;
                case 2:
                    viewTransactions();

                    break;
                case 3:
                    updateTransaction();

                    break;
                case 4:
                    deleteTransaction();

                    break;
                case 5:
                    this.executionMenu = false;

                    break;
                default:
                    System.out.println("Enter the correct option");

            }
        } while (this.executionMenu);
    }

    public void addTransaction() {
        String id;
        String type;
        Voucher voucher;
        String paymentStatus;
        Transaction transaction;
        
        System.out.print("Enter the id: ");
        id=this.scanner.nextLine();
        System.out.print("Enter the type: ");
        type=this.scanner.nextLine();
        voucher = this.addVoucher();
        System.out.print("Enter the payment status: ");
        paymentStatus = this.scanner.nextLine();
        
        transaction = new Transaction(id, type, voucher, paymentStatus);
        
        
        
        this.jsonFile.create(transaction, Transaction.class);
        
        
    }

    public void viewTransactions() {
        TransactionsRecord transactionsRecord;
        transactionsRecord= new TransactionsRecord(this.jsonFile.read(Transaction.class));
        System.out.printf(transactionsRecord.toString());

    }

    public void updateTransaction() {

        String id;
        String type;
        Voucher voucher;
        String paymentStatus;
        Transaction transaction;
        
        System.out.print("Enter the id of the transaction: ");
        id=this.scanner.nextLine();
        System.out.print("Enter the type: ");
        type=this.scanner.nextLine();
        voucher = this.addVoucher();
        System.out.print("Enter the payment status: ");
        paymentStatus = this.scanner.nextLine();
        
        transaction = new Transaction(id, type, voucher, paymentStatus);
        
        this.jsonFile.update(id,transaction, Transaction.class);

        

    }

    public void deleteTransaction() {
        String id;

        System.out.print("Enter the id of the product: ");
        id = this.scanner.nextLine();

        this.jsonFile.delete(id, Transaction.class);
    }

    public Voucher addVoucher() {
        String id;
        String type;
        String paymentMethod;
        Client client;
        Supplier supplier;
        System.out.println("Enter the voucher data");
        System.out.print("Enter the id of the voucher: ");
        id = this.scanner.nextLine();
        System.out.print("Enter the type of voucher: ");
        type = this.scanner.nextLine();
        System.out.print("Enter the payment method: ");
        paymentMethod = this.scanner.nextLine();
        supplier = this.addSupplier();
        client = this.addClient();
        
        
        

        return new Voucher(type, id, client, supplier, paymentMethod);
    }

    public Supplier addSupplier() {
        String type;
        String name;
        IdentityCard identityCard;
        String address;
        String phoneNumber;
        String email;
        System.out.println("Enter the supplier data");
        System.out.print("Enter the type of supplier: ");
        type= this.scanner.nextLine();
        System.out.print("Enter the name: ");
        name=this.scanner.nextLine();
        identityCard = this.addIdentityCard();
        System.out.print("Enter the address: ");
        address = this.scanner.nextLine();
        System.out.print("Enter the phone number: ");
        phoneNumber = this.scanner.nextLine();
        System.out.print("Enter the email");
        email= this.scanner.nextLine();
        
        

        return new Supplier(type, name, identityCard, address, phoneNumber, email);

    }
    public Client addClient() {
        String type;
        String name;
        IdentityCard identityCard;
        String address;
        String phoneNumber;
        String email;
        
        System.out.println("Enter the client data");
        System.out.print("Enter the type of supplier: ");
        type= this.scanner.nextLine();
        System.out.print("Enter the name: ");
        name=this.scanner.nextLine();
        identityCard = this.addIdentityCard();
        System.out.print("Enter the address: ");
        address = this.scanner.nextLine();
        System.out.print("Enter the phone number: ");
        phoneNumber = this.scanner.nextLine();
        System.out.print("Enter the email");
        email= this.scanner.nextLine();
        
        

        return new Client(type, name, identityCard, address, phoneNumber, email);

    }

    public IdentityCard addIdentityCard() {
        String type;
        String id;
        System.out.println("Enter the identity card data");
        System.out.print("Enter the type of identity document: ");
        type=this.scanner.nextLine();
        System.out.print("Enter the number of identity document: ");
        id=this.scanner.nextLine();
        return new IdentityCard(type, id);
    }

}
