import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    static int n, k, d;
    static Node[] arr;    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new Node[k];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = new Node(a, b, c);            
        }

        int left = 0;
        int right = n;
        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(solve(mid)) {
                right = mid - 1;                
                ans = mid;
            } else {
                left = mid + 1;                
            }
        }


        System.out.println(ans);
    }

    static boolean solve(int num) {
        long sum = 0;

        for(int i=0; i<k; i++) {
            if(num < arr[i].from) continue;
            sum += (Math.min(arr[i].to, num) - arr[i].from) / (arr[i].interval) + 1;            
        }

        return sum >= d;
    }
}

class Node {
    int from, to, interval;

    Node(int a, int b, int c) {
        from = a; to = b; interval = c;
    }
}

