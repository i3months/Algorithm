import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static ArrayList<Integer> list2 = new ArrayList<>();

    static int N;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R + 1][C + 1];

        for (int i = 1; i < R + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < C + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] wall = new int[2][2];

        st = new StringTokenizer(br.readLine());
        wall[0][0] = Integer.parseInt(st.nextToken());
        wall[0][1] = Integer.parseInt(st.nextToken());
        wall[1][0] = Integer.parseInt(st.nextToken());
        wall[1][1] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[R + 1][C + 1];

        for (int i = 0; i < R + 1; i++)
            for (int j = 0; j < C + 1; j++)
                dp[i][j] = INF;

        dp[1][1] = map[1][1];

        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {

                if (i == 1 && j == 1)
                    continue;

                if (wall[0][0] == wall[1][0] && i == wall[0][0] + 1 && Math.min(wall[0][1], wall[1][1]) < j
                        && Math.max(wall[0][1], wall[1][1]) >= j) {

                    if (dp[i][j - 1] == INF) {
                        dp[i][j] = INF;
                        continue;
                    } else {
                        dp[i][j] = dp[i][j - 1] + map[i][j];
                        continue;
                    }

                } else if (wall[0][1] == wall[1][1] && j == wall[1][1] + 1 && Math.min(wall[0][0], wall[1][0]) < i
                        && Math.max(wall[0][0], wall[1][0]) >= i) {

                    if (dp[i - 1][j] == INF) {
                        dp[i][j] = INF;
                        continue;
                    } else {
                        dp[i][j] = dp[i - 1][j] + map[i][j];
                    }
                } else if (dp[i][j - 1] == INF && dp[i - 1][j] == INF) {
                    dp[i][j] = INF;
                } else if (dp[i][j - 1] == INF) {
                    dp[i][j] = dp[i - 1][j] + map[i][j];
                } else if (dp[i - 1][j] == INF) {
                    dp[i][j] = dp[i][j - 1] + map[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
                }                
            }
        }

        // int ans = dp[R][C] == INF ? 0 : dp[R][C] + map[1][1];

        // System.out.println(ans);

        if(dp[R][C] == INF) {
            System.out.println("Entity");
        } else {
            System.out.println(dp[R][C]);
        }

        // for (int i = 1; i < R + 1; i++) {
        //     for (int j = 1; j < C + 1; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

    }
}