import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] cmd = new int[M+1][3];

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            cmd[i][0] = Integer.parseInt(st.nextToken());
            cmd[i][1] = Integer.parseInt(st.nextToken());
            cmd[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] cal = new int[N+2];

        for(int i=1; i<M+1; i++){
            cal[cmd[i][0]] += cmd[i][2];
            cal[cmd[i][1]+1] -= cmd[i][2];            
        }

        // int[] sum = new int[N+2];

        // for(int i=1; i<N+1; i++){            
        //     sum[i] += sum[i-1] + cal[i];
        // }
            
        int z = 0;

        for(int i=1; i<N+1; i++){
            z += cal[i];
            arr[i] += z;
            System.out.print(arr[i] +" ");
        }

    }
}