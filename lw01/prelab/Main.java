import CampusPrintingService.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));  
        List<PrintJob> printJobs = new ArrayList<>();
        while (sc.hasNext()) {
            String printType = sc.next();
            if (printType.equals("MONO")) {
                String id = sc.next();
                int pages = sc.nextInt();
                PrintJob monoPrint = new MonoPrint(id, pages);
                print.add(monoPrint);
            } else if (printType.equals("COLOUR")) {
                String id = sc.next();
                int pages = sc.nextInt();
                PrintJob colourPrint = new ColourPrint(id, pages);
                print.add(colourPrint);
            }
        }
        sc.close();
        for (PrintJob job : print) {
            System.out.println(job.summary());
        }
    }
}
