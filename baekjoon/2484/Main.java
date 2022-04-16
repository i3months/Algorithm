import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
     
        int N = Integer.parseInt(br.readLine());
        int[] arr123 = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int arr[] = {0,0,0,0,0,0,0};

            arr[a]++;
            arr[b]++;
            arr[c]++;
            arr[d]++;

            int max = 0;
            int max_val = 0;

            for(int j = 1; j<7; j++){
                if(arr[j] > max){
                    max = arr[j];
                    max_val = j;
                }
            }
            int doublearr[] = {0,0};
            int doublecnt = 0;
            for(int j=1; j<7; j++){
                if(arr[j] == 2){
                    doublecnt ++;
                }
            }
            int k =0;
            if(doublecnt == 2){
                for(int j=1; j<7; j++){
                    if(arr[j] == 2){
                        doublearr[k] = j;
                        k++;
                    }
                }
            }

            // j is dice value
            // max is count 
            int ans = 0;

            if(doublecnt == 2){
                ans = ans + 2000 + doublearr[0]*500 + doublearr[1] * 500;
            }else if(max == 4){
                ans = ans + 50000;
                ans = ans + max_val * 5000;
            }else if(max == 3){
                ans = ans + 10000;
                ans = ans + max_val * 1000;
            }else if(max == 2){
                ans = ans + 1000;
                ans = ans + max_val * 100;
            }else if(max == 1){                
                if(arr[6] == 1){
                    ans = ans + 100 * 6;
                }else if(arr[5] == 1){
                    ans = ans + 100 * 5;
                }else if(arr[4] == 1){
                    ans = ans + 100 * 4;
                }
            }



            arr123[i] = ans;


        }

        Arrays.sort(arr123);

        System.out.println(arr123[N-1]);


    }
}