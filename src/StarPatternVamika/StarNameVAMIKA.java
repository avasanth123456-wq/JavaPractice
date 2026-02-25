package StarPatternVamika;

public class StarNameVAMIKA {
    public static void main(String[] args) {
        int n = 7; // height of letters

        for (int i = 0; i < n; i++) {

            // V
            for (int j = 0; j < n; j++) {
                if (j == i || j == n - 1 - i) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("  ");

            // A
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0 && j < n - 1) System.out.print("*");
                else if (j == 0 || j == n - 1) System.out.print("*");
                else if (i == n / 2) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("  ");

            // M
            for (int j = 0; j < n; j++) {
                if (j == 0 || j == n - 1 || (i == j && i <= n/2) || (i + j == n-1 && i <= n/2)) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("  ");

            // I
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == n / 2) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("  ");

            // K
            for (int j = 0; j < n; j++) {
                if (j == 0 || i + j == n / 2 || i - j == n / 2) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("  ");

            // A
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0 && j < n - 1) System.out.print("*");
                else if (j == 0 || j == n - 1) System.out.print("*");
                else if (i == n / 2) System.out.print("*");
                else System.out.print(" ");
            }

            System.out.println();
        }
    }
}

