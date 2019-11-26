import java.io.IOException;
import java.util.Scanner;

public class ATM {

    private Scanner in;
    private BankAccount activeAccount;

    public static final int VIEW = 1;
    public static final int DEPOSIT = 2;
    public static final int WITHDRAW = 3;
    public static final int LOGOUT = 4;

    public static final int INVALID = 0;
    public static final int INSUFFICIENT = 1;
    public static final int SUCCESS = 2;

    /* constructor and methods not shown */
}

    public ATM() {
        in = new Scanner(System.in);

        try {

            this.bank = new Bank();

        } catch (IOException e) {

          in.close();

        }
    }

    public void startup() {

          long accountNo;
          int pin;

          boolean createAccount = false;

        System.out.println("Welcome to the AIT ATM!\n");

        while (true) {

            System.out.print("Account No.: ");
            String accountNum = in.nextLong();

            if (accountNum.isEmpty()) {

              accountNo = 0;

            } else if (accountNum.charAt(0) == '+') {

              accountNo = 0;
              createAccount = true;

            } else if (accountNum.matches("[0-9]+")) {

              accountNo = Long.parseLong(accountNum);

            } else if (!(accountNum.contains("-")) && !(accountNum.matches("[0-9]+"))) {

              accountNo = -1;

            } else {

              accountNo = 0;

            }

////////////////////////////////////////////////////////////////////////////////

                if (!(createAccount)) {

                  System.out.print("PIN        : ");
                  String accountPin = in.nextLine

                  if (accountPin.isEmpty()) {

                    pin = 0;

                  } else if (accountPin.matches("[0-9]+")) {

                    pin = Integer.parseInt(accountPin);

                  } else if (accountPin.matches("-")) {

                    pin = 0;

                  } else if (!(accountPin.contains("-")) && !(accountPin.matches("[0-9]+"))) {

                    pin = 0;

                  } else {

                    pin = 0;

                  }

///////////////////////////////////////////////////////////////////////////////

            if (isValidLogin(accountNo, pin)) {

                boolean validLogin = true;

                System.out.println("\nHello, again, " + activeAccount.getAccountHolder().getFirstName() + "!\n");

                while (validLogin) {
                    switch (getSelection()) {

                        case VIEW: showBalance(); break;
                        case DEPOSIT: deposit(); break;
                        case WITHDRAW: withdraw(); break;
                        case LOGOUT: validLogin = false; break;
                        default: System.out.println("\nInvalid selection.\n"); break;
                    }
                }
            } else {

                if (accountNo = -1 && pin == -1) {

                    shutdown();

                } else {

                    System.out.println("\nInvalid account number and/or PIN.\n");
                }
            }

        } else {

          System.out.print("\nFirst Name: ");
            String firstName = in.nextLine();

            if (firstName.length() > 0 && firstName.length() <= 20) {

                System.out.print("Last Name: ");
                 String lastName = in.nextLine();


            if (lastName.length() > 0 && lastName.length() <= 30) {

                System.out.print("Pin: ");

                if (in.has.NextInt()) {

                  pin = in.nextInt();
                  in.nextLine();

                if ()
                }
            }

          }
        }
    }






    public boolean isValidLogin(long accountNo, int pin) {
        return accountNo == activeAccount.getAccountNo() && pin == activeAccount.getPin();
    }

    public int getSelection() {
        System.out.println("[1] View balance");
        System.out.println("[2] Deposit money");
        System.out.println("[3] Withdraw money");
        System.out.println("[4] Logout");

        return in.nextInt();
    }

    public void showBalance() {
        System.out.println("\nCurrent balance: " + activeAccount.getBalance());
    }

    public void deposit() {

      System.out.print("\nEnter amount: ");
      double amount = in.nextDouble();

      int status = activeAccount.deposit(amount);

      if (status == ATM.INVALID) {

        System.out.println("\nDeposit rejected. Amount must be greater than $0.00.\n");

      } else if (status == ATM.SUCCESS) {

        System.out.println("\nDeposit accepted.\n");
    }
}

    public void withdraw() {

    System.out.print("\nEnter amount: ");
    double amount = in.nextDouble();

    int status = activeAccount.withdraw(amount);
    if (status == ATM.INVALID) {

        System.out.println("\nWithdrawal rejected. Amount must be greater than $0.00.\n");

      } else if (status == ATM.INSUFFICIENT) {

        System.out.println("\nWithdrawal rejected. Insufficient funds.\n");

      } else if (status == ATM.SUCCESS) {

        System.out.println("\nWithdrawal accepted.\n");
    }
  }

    public void shutdown() {
        if (in != null) {
            in.close();
        }

        System.out.println("\nGoodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.startup();
    }
}
