import java.util.Scanner;

public class MatrixChainMultiplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int p[] = new int[n + 1];

        
        System.out.println("Enter dimensions:");

        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        
        int dp[][] = new int[n][n];

      
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i < n - len + 1; i++) {

                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + p[i] * p[k + 1] * p[j + 1];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

       
        System.out.println("Minimum number of multiplications = "
                           + dp[0][n - 1]);

      
    }
}
