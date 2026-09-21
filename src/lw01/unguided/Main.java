package lw01.unguided;

import lw01.unguided.CampusRental.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int totalRental = sc.nextInt();
        Rental[] rentalRecord = new Rental[totalRental];
        for(int i = 0; i < totalRental; i++) {
            String rentalType = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();
            if (rentalType.equals("LAPTOP")) {
                Rental laptop = new LaptopRental(id, days, units);
                rentalRecord[i] = laptop;
            } else if (rentalType.equals("PROJECTOR")) {
                Rental projector = new ProjectorRental(id, days, units);
                rentalRecord[i] = projector;
            }
        }
        sc.close();
        for(Rental rentals : rentalRecord) {
            System.out.println(rentals.summary());
        }
    }
}
