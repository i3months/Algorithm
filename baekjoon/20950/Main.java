import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static boolean[] visit;
    static int N;
    static int cnt = Integer.MAX_VALUE;
    static int ans = Integer.MAX_VALUE;
    static Paint[] arr;
    static Paint gom, moon;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        N = Integer.parseInt(br.readLine());
        arr = new Paint[N];
        visit = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Paint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        moon = new Paint();
        gom = new Paint();

        StringTokenizer st = new StringTokenizer(br.readLine());

        gom.R = Integer.parseInt(st.nextToken());
        gom.G = Integer.parseInt(st.nextToken());
        gom.B = Integer.parseInt(st.nextToken());

        bt(0,0);

        System.out.println(ans);
        
        

    }

    static void bt(int depth, int cnt){
        if(cnt >= 2){
            ans = Math.min(ans, Math.abs(moon.R / cnt - gom.R)+ Math.abs(moon.G / cnt - gom.G) + Math.abs(moon.B / cnt - gom.B));
        }

        for(int i = depth; i<N; i++){
            if(!visit[i] && cnt < 7){
                visit[i] = true;
                moon.R += arr[i].R;
                moon.G += arr[i].G;
                moon.B += arr[i].B;

                bt(i + 1, cnt + 1);

                visit[i] = false;
                moon.R -= arr[i].R;
                moon.G -= arr[i].G;
                moon.B -= arr[i].B;

            }
        }
    }
}

class Paint{
    int R, G, B;

    Paint(int R, int G, int B){
        this.R = R;
        this.G = G;
        this.B = B;
    }

    Paint(){}

}