import java.util.Scanner;

public class MakingChangeDP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of coin types
        System.out.print("Enter number of coin types: ");
        int n = sc.nextInt();

        int coins[] = new int[n];

        // Input coin values
        System.out.println("Enter coin values:");

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // Input amount
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        // DP array
        int dp[] = new int[amount + 1];

        // Initialize
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Dynamic Programming
        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < n; j++) {

                if (coins[j] <= i) {

                    int subResult = dp[i - coins[j]];

                    if (subResult != Integer.MAX_VALUE &&
                        subResult + 1 < dp[i]) {

                        dp[i] = subResult + 1;
                    }
                }
            }
        }

        // Output
        if (dp[amount] == Integer.MAX_VALUE) {
            System.out.println("Change cannot be made");
        } else {
            System.out.println("Minimum coins required = " + dp[amount]);
        }

        sc.close();
    }
}
