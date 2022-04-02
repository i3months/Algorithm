import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int M = Integer.parseInt(br.readLine());
            char[][] arr = new char[M][M];
            for(int j= 0; j<M; j++){
                for(int k =0; k<M; k++){
                    if(j == 0 || k == 0 || j == M-1 || k == M-1){
                        arr[j][k] = '#';
                    }else{
                        arr[j][k] = 'J';
                    }
                }
            }

            for(int j = 0; j<M; j++){
                for(int k = 0; k<M; k++){
                    System.out.print(arr[j][k]);
                }
                System.out.println();
            }
            System.out.println();

        }

    }
}

