import java.util.Scanner;

class BankAccount {
    private double balance;
    private int pin;

    public BankAccount(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public boolean authenticate(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withDraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

}

public class ATM {
    private static final Scanner sc = new Scanner(System.in);
    private static BankAccount userAccount = new BankAccount(5000, 1234); //Default amount and password

    public static void main(String[] args) {
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (userAccount.authenticate(enteredPin)) {
            System.out.println("Login successfully!\n");

            while (true) {
                System.out.println("\n------ ATM MENU -----");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.println("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your balance: ₹" + userAccount.getBalance());
                        break;

                    case 2:
                        System.out.println("Enter amount to deposit: ₹");
                        double depositAmount = sc.nextDouble();
                        userAccount.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.println("Enter amount to withdraw: ₹");
                        double withdrawAmount = sc.nextDouble();
                        userAccount.withDraw(withdrawAmount);
                        break;

                    case 4:
                        System.out.println("Thank you for using ATM machine.");
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter existing");
                }

            }
        } else {
            System.out.println("Incorrect Pin");
        }
    }
}