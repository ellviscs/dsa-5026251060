package lw02.unguided;

import java.util.*;;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> stock = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        LinkedList<String[]> success = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedRequest = new Stack<>();

        while (sc.hasNext()) {
            String[] borrow = {sc.next(), sc.next()};
            request.add(borrow);
        }
        sc.close();

        String[] kalkulus = {"Kalkulus", "2"};
        stock.add(kalkulus);
        String[] fisika = {"Fisika", "1"};
        stock.add(fisika);
        String[] statistika = {"Statistika", "2"};
        stock.add(statistika);

        for (String[] requester: request) {
            String requesterName = null;
            
            for(String[] member: members) {
                if (requester[0].equals(member[0])) {
                    requesterName = member[0];
                    break;
                }
            }

            if (requesterName == null) {
                String[] member = {requester[0], "0"};
                members.add(member);
            }
        }

        queue = request;

        while (!queue.isEmpty()) {
            String[] borrow = queue.poll();
            String[] member = new String[2];
            String[] book = new String[2];
            for (String[] mem : members) {
                if (mem[0].equals(borrow[0])) {
                    member = mem;
                    break;
                }
            }
            for (String[] books : stock) {
                if (books[0].equals(borrow[1])) {
                    book = books;
                    break;
                }
            }

            int memberBorrow = Integer.parseInt(member[1]);
            int bookStock = Integer.parseInt(book[1]);
            if (memberBorrow <= 1 && bookStock > 0) {
                book[1] = Integer.toString(bookStock - 1);
                member[1] = Integer.toString(memberBorrow + 1);
                success.add(borrow);
            } else {
                failedRequest.add(borrow);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for (String[] successRequest : success) {
            System.out.println(successRequest[0] + " " + successRequest[1]);
        }
        System.out.println("\n=== Remaining Book Stock ===");
        for (String[] book : stock) {
            System.out.println(book[0] + " " + book[1]);
        }
        System.out.println("\n=== Failed Requests ===");
        while (!failedRequest.isEmpty()) {
            String[] fail = failedRequest.pop();
            System.out.println(fail[0] + " " + fail[1]);
        }
    }
}
