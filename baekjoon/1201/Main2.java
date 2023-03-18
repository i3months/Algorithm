import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        if (n < m + k - 1 || m * k < n) {
            System.out.println(-1);
            return;
        }

        Deque<Integer> dq = new LinkedList<>();

        dq.offer(0);
        dq.offer(k);
        n -= k;
        m -= 1;

        int size = m == 0 ? 0 : n / m;
        int r = m == 0 ? 0 : n % m;

        for (int i = 0; i < m; i++) {
            dq.offer(dq.getLast() + size + (r > 0 ? 1 : 0));
            if (r > 0)
                r--;
        }

        int start = 0;
        int end = dq.pollFirst();
        while (!dq.isEmpty()) {
            start = end;
            end = dq.pollFirst();

            for (int j = end - 1; j >= start; j--) {
                sb.append(nums[j]).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}