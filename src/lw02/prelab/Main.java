package lw02.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transaction.txt"));
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customerRecords = new LinkedList<>();
        Queue<String[]> transactionQueue = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();

        // Read and Store Transaction Data
        while(sc.hasNext()) {
            String[] transaction = new String[3];
            transaction[0] = sc.next();
            transaction[1] = sc.next();
            transaction[2] = sc.next();
            transactions.add(transaction);
        }
        sc.close();

        // Insert Customer Data from Transaction Data to customerRecords
        while (!transactions.isEmpty()) {
            String[] transaction = transactions.poll();
            String customerName = transaction[0];
            String[] customerRecord = {customerName, "0"};
            if (!isRegistered(customerRecords, customerRecord)) {
                customerRecords.add(customerRecord);
            } 
            transactionQueue.add(transaction);
        }


        // Process Transactions
        while (!transactionQueue.isEmpty()) {
            String[] transaction = transactionQueue.poll();
            String customerName = transaction[0];
            String transactionType = transaction[1];
            int amount = Integer.parseInt(transaction[2]);
            String[] customerRecord = findCustomer(customerRecords, customerName);
            if (transactionType.equals("DEPOSIT")) {
                int customerBalance = Integer.parseInt(customerRecord[1]);
                customerBalance += amount;
                customerRecord[1] = Integer.toString(customerBalance); 
            }
            if (transactionType.equals("WITHDRAW")) {
                int customerBalance = Integer.parseInt(customerRecord[1]);
                // Store Transaction to failedTransactions if Balance is less than Withdraw amount
                if (customerBalance < amount) {
                    failedTransactions.add(transaction);
                    continue;
                }
                customerBalance -= amount;
                customerRecord[1] = Integer.toString(customerBalance); 
            }
        }

        // Display Balance and Failed Transaction
        System.out.println("=== Final Balances ===");
        int customerRecordSize = customerRecords.size();
        for (int i = 0; i < customerRecordSize; i++) {
            String[] customerRecord = customerRecords.poll();
            String customerName = customerRecord[0];
            String customerBalance = customerRecord[1]; 
            System.out.println(customerName + " : " + customerBalance);
        }

        System.out.println("\n=== Failed Transaction ===");
        while (!failedTransactions.isEmpty()) {
            String[] failedTransaction = failedTransactions.pop();
            String customerName = failedTransaction[0];
            String transactionType = failedTransaction[1];
            String transactionAmount = failedTransaction[2];
            System.out.println(customerName + " " + transactionType + " " + transactionAmount); 
        }
    }

    public static boolean isRegistered(LinkedList<String[]> records, String[] data) {
        boolean isRegistered = false;
        int recordSize = records.size(); 
        for (int i = 0; i < recordSize; i++) {
            String[] record = records.poll();
            String recordName = record[0];
            String customerName = data[0];
            if (recordName.equals(customerName)) {
                isRegistered = true;
            }
            records.add(record);
        }
        return isRegistered;
    }

    public static String[] findCustomer(LinkedList<String[]> customerRecords, String customerName) {
        String[] customerFounds = new String[2];
        for (String[] customerRecord : customerRecords) {
            String customerRecordName = customerRecord[0];
            if (customerRecordName.equals(customerName)) {
                customerFounds = customerRecord;
            }
        }
        return customerFounds;
    }
}