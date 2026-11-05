package lw04.prelab;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        sortBranches(sc);
        sortBranches(sc);
        sc.close();
    }
    public static void sortBranches(Scanner sc) {
        int totalBranches = sc.nextInt();
        int[] branches = new int[totalBranches];
        
        for (int i = 0; i < totalBranches; i++) {
            branches[i] = sc.nextInt();
        }

        int totalTarget = sc.nextInt();
        int[] targets = new int[totalTarget];

        for (int i = 0; i < totalTarget; i++) {
            targets[i] = sc.nextInt();
        }

        for (int i = 1; i <= 3; i++) {
            int branch = branches[i];
            int j = i - 1;
            
            while (j >= 0 && branches[j] < branch){
                branches[j + 1] = branches[j];
                j--;
            }

            branches[j + 1] = branch;
        }

        for (int branch: branches) {
            System.out.print(branch + " ");
        }
        System.out.println();

        for (int i = 0; i < targets.length; i++){
            int index = -1;
            int target = targets[i];
            for (int j = 0; j < branches.length; j++) {
                if (target == branches[j]) {
                    index = j;
                    break;
                }
            }
            if (index != -1) {
                System.out.println(target + ": FOUND at index " + index);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
        System.out.println();
    }
}
