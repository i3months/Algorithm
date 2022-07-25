import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            sb.append(calcXOR(S, F) + "\n");
        }

        System.out.println(sb);
    }

    static int calcXOR(int m, int n) {
        int[] pattern;
    
        if(m % 2 == 0)
            pattern = new int[] {n, 1, n^1, 0};
        else
            pattern = new int[] {m, m^n, m-1, (m-1)^n};
    
        return pattern[(n-m) % 4];
    }
}