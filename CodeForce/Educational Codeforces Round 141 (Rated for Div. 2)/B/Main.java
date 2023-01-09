import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {    
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                              

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int ptr1 = 1;
            int ptr2 = N*N;
            int cnt = 1;

            int[][] arr = new int[N+1][N+1];

            for(int i=1; i<N+1; i++) {
                if(i % 2 == 1) {
                    for(int j=1; j<N+1; j++) {
                        if(cnt % 2 == 1) {
                            arr[i][j] = ptr1;
                            ptr1++;
                            cnt++;
                        } else {
                            arr[i][j] = ptr2;
                            ptr2--;
                            cnt++;
                        }
                    }
                } else {
                    for(int j=N; j>=1; j--) {
                        if(cnt % 2 == 1) {
                            arr[i][j] = ptr1;
                            ptr1++;
                            cnt++;
                        } else {
                            arr[i][j] = ptr2;
                            ptr2--;
                            cnt++;
                        }
                    }
                }                              
            }

            for(int i=1; i<N+1; i++) {
                for(int j=1; j<N+1; j++) {
                    System.out.print(arr[i][j] + " ");
                }System.out.println();
            }



        }
        
    }
}
