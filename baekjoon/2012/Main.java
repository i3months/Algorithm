import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int[][] map = new int[5][5];    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int destinationR = 0;
    static int destinationC = 0;

    static int[][] visit = new int[5][5];

    static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine())      ;

        int[] arr = new int[N+1];

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long sum = 0;

        Arrays.sort(arr);

        for(int i=1; i<N+1; i++){
            sum += Math.abs(i - arr[i]);
        }

        System.out.println(sum);
    }
}