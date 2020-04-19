import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sb = scanner.nextLine();
        int m = scanner.nextInt();
        int count = 0;
        int index = 0;
        for (int i = 0; i < sb.length() - m + 1; i++) {
            int k = 0;
            for (int j = 0; j < m; j++) {
                if (sb.charAt(i+j) == 'C' || sb.charAt(i+j) == 'G') {
                    k++;
                }
            }
            if (k > count) {
                count = k;
                index = i;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(sb.charAt(index + i));
        }
    }
}
