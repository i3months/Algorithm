import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while(--TC >= 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[][] friends = new boolean[n][n];
            boolean[] taken = new boolean[n];

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<m; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                friends[a][b] = true;
                friends[b][a] = true;
            }

            sb.append(countPair(friends, taken, n) + "\n");
        }
        System.out.println(sb);


    }

    static int countPair(boolean[][] friends, boolean[] taken, int n){
        int firstFree = -1;

        for(int i=0; i<n; i++){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }

        if(firstFree == -1){
            return 1;
        }

        int ret = 0;

        for(int i= firstFree + 1; i<n; i++){
            if(!taken[i] && friends[firstFree][i]){
                taken[firstFree] = true;
                taken[i] = true;
                ret += countPair(friends, taken, n);
                taken[firstFree] = false;
                taken[i] = false;
            }
        }
        return ret;
    }
}
