import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    static int n, k, fuel;
    static Locate[] arr;    
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new Locate[n+2];        
        visit = new boolean[n+2];

        arr[0] = new Locate(0, 0);
        // arr[n+1] = new Locate(10000, 10000);

        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Locate(a, b);
        }

        int left = 0; 
        int right = INF;
        int ans = INF;

        while(left <= right) {
            int mid = (left + right) / 2;
            
            Arrays.fill(visit, false);

            Queue<Locate> q = new LinkedList<>();
            visit[0] = true;
            q.add(new Locate(0,0,0));

            boolean flag = false;

            while(!q.isEmpty()) {
                Locate cur = q.poll();

                if(cur.cnt == k + 1) continue;
                if(mid >= getDistance(cur.r, cur.c, 10000, 10000)) {
                    flag = true;
                    break;
                }                

                for(int i=1; i<n+1; i++) {
                    int nextR = arr[i].r;
                    int nextC = arr[i].c;

                    if(getDistance(cur.r, cur.c, nextR, nextC) <= mid && !visit[i]) {
                        visit[i] = true;
                        q.add(new Locate(nextR, nextC, cur.cnt + 1));
                    }
                }
            }

            if(flag) {
                right = mid - 1;
                ans = Math.min(mid, ans);
            } else {
                left = mid + 1;
            }
            
        }

        System.out.println(ans);

    }

    static int getDistance(int r1, int c1, int r2, int c2) {
        int distance = (int)Math.ceil(Math.sqrt(Math.pow(r1 - r2, 2) + Math.pow(c1 - c2, 2)));

        if(distance % 10 == 0) return distance / 10;
        else return (distance / 10) + 1;
    }
}

class Locate {
    int r, c;
    int cnt = 0;
    Locate(int r, int c) {
        this.r = r; this.c = c;
    }
    Locate(int r, int c, int cnt) {
        this.r = r; this.c = c; this.cnt = cnt;
    }
}
