package MyProject.DeveloperArrangementSystem.view;

import java.util.*;


public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @Description select from  1-4
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4') {
                System.out.print("Wrong input, try again：");
            } else break;
        }
        return c;
    }

    /**
     * @Description wait, until enter...
     */
    public static void readReturn() {
        System.out.print("Press ENTER to continue...");
        readKeyBoard(100, true);
    }

    /**
     * @Description sys input numbers
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Wrong input, try again：");
            }
        }
        return n;
    }

    /**
     * @Description y or n?
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Wrong input, try again：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("input length（less than" + limit + "）Wrong, try again：");
                continue;
            }
            break;
        }

        return line;
    }
}

