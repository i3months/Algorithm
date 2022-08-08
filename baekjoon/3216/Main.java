import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Music[] arr = new Music[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = new Music(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] ans = new int[N+1];

        ans[N] = 0;

        for(int i = N-1; i>=0; i--){
            ans[i] = arr[i].down_len + Math.max(0, ans[i+1] - arr[i].song_len);
        }

        System.out.println(ans[0]);
        
        
    }
}

class Music{
    int song_len, down_len;

    Music(int song_len, int down_len){
        this.song_len = song_len;
        this.down_len = down_len;
    }
}