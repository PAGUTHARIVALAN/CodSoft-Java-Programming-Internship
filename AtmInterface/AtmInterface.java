import java.util.Scanner;

public class AtmInterface {
    private BankAccount userAccount;
    private Scanner sc;

    public AtmInterface(BankAccount userAccount) {
        this.userAccount = userAccount;
        this.sc = new Scanner(System.in);
    }

    public void startATM() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = validateChoice();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }
        System.out.println("Exiting the ATM. Thank you for using our services!");
    }

    private void displayMenu() {
        System.out.println("=== ATM ===");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int validateChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw :");
        double amount = validateAmount();

        if (userAccount.getBalance() >= amount) {
            userAccount.withdraw(amount);
            System.out.println("Withdrawal successful!!. Current balance: " + userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit : ");
        double amount = validateAmount();

        userAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + userAccount.getBalance());
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }

    private double validateAmount() {
        while (true) {
            try {
                double amount = Double.parseDouble(sc.nextLine());
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.println("Invalid amount!. Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!. Please enter a valid amount.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500); //Putting minimum balance as 500
        AtmInterface atm = new AtmInterface(userAccount);
        atm.startATM();
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance =balance - amount;
    }

    public void deposit(double amount) {
        balance =balance+amount;
    }
}
