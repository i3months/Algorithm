import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        int board[][] = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'W'){
                    board[i][j] = 1; // w == 1
                }else{
                    board[i][j] = 0; // b == 0
                }
            }

        } // end of for i


        int min_value = 100;

        for(int i=0; i<N-8+1; i++){
            for(int j=0; j<M-8+1; j++){
                int cnt = 0;
                int chk = 0;

                for(int k=i; k<i+8; k++){
                    for(int l=j; l<j+8; l++){

                        if(board[k][l] != chk){
                            cnt++;
                        }
                        if(chk == 0){
                            chk = 1;
                        }else if(chk == 1){
                            chk = 0;
                        } // swap chk 0 to 1 mutally

                        
                    }
                    if(chk == 0){
                        chk = 1;
                    }else if(chk == 1){
                        chk = 0;
                    } // swap chk 0 to 1 mutally
                } // end of for k
                
                cnt = Math.min(cnt, 64-cnt);
                min_value = Math.min(min_value, cnt);
            }
        }

        System.out.println(min_value);

    
 
	}
}

		