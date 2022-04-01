import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] box = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            box[i] = Integer.parseInt(st.nextToken());    
        }
        
        st = new StringTokenizer(br.readLine());

        int k = 0;
        for(int i = 0; i<M; i++){
            int book_size = Integer.parseInt(st.nextToken());
            
            if(box[k] - book_size >= 0){        
                box[k] = box[k] - book_size;                
            }else{
                while(true){
                    k++;
                    if(box[k] - book_size >= 0){
                        box[k] = box[k] - book_size;
                        break;
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            ans = ans + box[i];
        }

        System.out.println(ans);
    }
}

