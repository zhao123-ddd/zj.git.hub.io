package 力扣;

import java.util.Scanner;

public class 坐标移动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(";");
            int x = 0, y = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i].length() == 3) {
                    if ((s[i].charAt(1) <= '9' && s[i].charAt(1) >= '0') && (s[i].charAt(2) <= '9' && s[i].charAt(2) >= '0')) {
                        int b = Integer.parseInt(s[i].substring(1, 3));
                        switch (s[i].charAt(0)) {
                            case 'A':
                                x -= b;
                                break;
                            case 'D':
                                x += b;
                                break;
                            case 'W':
                                y += b;
                                break;
                            case 'S':
                                y -= b;
                                break;
                        }
                    }
                }
                if (s[i].length() == 2) {
                    if ((s[i].charAt(1) <= '9' && s[i].charAt(1) >= '0')) {
                        int b = Integer.parseInt(s[i].substring(1, 2));
                        switch (s[i].charAt(0)) {
                            case 'A':
                                x -= b;
                                break;
                            case 'D':
                                x += b;
                                break;
                            case 'W':
                                y += b;
                                break;
                            case 'S':
                                y -= b;
                                break;
                        }
                    }
                }

            }
            System.out.println(x + "," + y);
        }
    }
    }
