import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,m,M,T,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int count = 0;
        int time = 0;
        int current = m;

        while(count<N) {
            if(current+T <= M) {
                count++;
                time++;
                current += T;
            }else {
                if((current - R)< m) {
                    time++;
                    current = m ;
                }else {
                    time++;
                    current -= R;
                }
            }

            if(current + T > M && current == m) {
                System.out.println("-1");
                return;
            }

        }
        System.out.println(time);
    }
}

