public class ATMTransactionAuthorizer {
    public static void main(String[] args) {
        String inputUser = "joie_arjona";
        int inputPin = 1234;

        String validUser = "joie_arjona";
        int validPin = 1234;

        double balance = 25000.00;
        double withdrawalAmount = 8000.00;

        if (inputUser.equals(validUser)) {
            if (inputPin == validPin) {

                String accountTier;
                if (balance >= 100000.00) {
                    accountTier = "Platinum";
                } else if (balance >= 50000.00) {
                    accountTier = "Gold";
                } else if (balance >= 20000.00) {
                    accountTier = "Silver";
                } else {
                    accountTier = "Bronze";
                }

                double feePercentage;
                double dailyLimit;

                switch (accountTier) {
                    case "Platinum":
                        feePercentage = 0.00;
                        dailyLimit = 50000.00;
                        break;
                    case "Gold":
                        feePercentage = 0.01;
                        dailyLimit = 30000.00;
                        break;
                    case "Silver":
                        feePercentage = 0.02;
                        dailyLimit = 15000.00;
                        break;
                    case "Bronze":
                    default:
                        feePercentage = 0.03;
                        dailyLimit = 5000.00;
                        break;
                }

                double transactionFee = withdrawalAmount * feePercentage;
                double totalDeduction = withdrawalAmount + transactionFee;

                System.out.println("--- Account Details ---");
                System.out.println("Account Tier: " + accountTier);
                System.out.println("Current Balance: Php " + balance);
                System.out.println("Requested Withdrawal: Php " + withdrawalAmount);
                System.out.println("Transaction Fee (" + (int)(feePercentage * 100) + "%): Php " + transactionFee);
                System.out.println();

                if (withdrawalAmount <= dailyLimit) {
                    if (totalDeduction <= balance) {
                        double remainingBalance = balance - totalDeduction;
                        System.out.println("STATUS: APPROVED");
                        System.out.println("Please collect your cash. Remaining balance: Php " + remainingBalance);
                    } else {
                        System.out.println("STATUS: DENIED");
                        System.out.println("Reason: Insufficient funds to cover withdrawal and transaction fee.");
                    }
                } else {
                    System.out.println("STATUS: DENIED");
                    System.out.println("Reason: Withdrawal exceeds daily limit of Php " + dailyLimit + " for " + accountTier + " tier.");
                }

            } else {
                System.out.println("STATUS: DENIED");
                System.out.println("Reason: Incorrect PIN entered.");
            }
        } else {
            System.out.println("STATUS: DENIED");
            System.out.println("Reason: Invalid username.");
        }
    }
}
