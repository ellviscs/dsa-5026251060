package lw03.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> courses = new LinkedHashMap<>();
        int rejected = 0;

        System.out.println("===== Enrollment Checks =====");
        while (sc.hasNext()) {
            String type = sc.next();
            String courseCode = sc.next();

            if (type.equals("REGISTER")) {
                int count = sc.nextInt();
                if (count <= 0) {
                    rejected++;
                    continue;
                }
                // Ternary Operator (Diperbolehkan waktu ditanyakan)
                int courseCount = courses.containsKey(courseCode) ? courses.get(courseCode) : 0;
                courses.put(courseCode, courseCount + count);
            } else if (type.equals("CHECK")) {
                String output = courseCode + ": ";
                output += courses.containsKey(courseCode) ? courses.get(courseCode) + " students" : "Not found";
                System.out.println(output);
            } else if (type.equals("WITHDRAW")) {
                int count = sc.nextInt();
                if (!courses.containsKey(courseCode) || courses.get(courseCode) < count) {
                    rejected++;
                    continue;
                }
                int courseCount = courses.get(courseCode) - count;
                courses.replace(courseCode, courseCount);
            }
        }

        System.out.println("\n===== Final Enrollment =====");
        for (String course: courses.keySet()) {
            System.out.println(course + ": " + courses.get(course) + " students");
        }
        System.out.println("\nRejected operations: " + rejected);
        sc.close();
    }
}
