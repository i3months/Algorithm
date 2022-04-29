import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int temp[][] = new int[N][M];
        
        for(int i=0; i<N; i++){            
            for(int j=0; j<M; j++){
                temp[i][j] = arr[i][j];
            }
        }

        for(int i=0; i<N; i++){            
            for(int j=0; j<M; j++){
                arr[i][j] = temp[i][M-j-1];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        


   }
}