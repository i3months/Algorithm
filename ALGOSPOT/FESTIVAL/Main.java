import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            double ans = Double.MAX_VALUE;

            double[] day = new double[N + 1];

            st = new StringTokenizer(br.readLine());

            for(int j=1; j<N + 1; j++){
                day[j] = Double.parseDouble(st.nextToken());
            }

            for(int j=1; j<N + 1; j++){
                day[j] = day[j-1] + day[j];
            }

            for(int a = 0; a < N -  L + 1; a++){
                for(int b = a + L; b < N + 1; b++){
                    double tmp = (day[b] - day[a]) / (double)(b - a);
                    ans = Math.min(ans, tmp);
                }
            }

            sb.append(ans + "\n");
            
        }

        System.out.println(sb);

        
    }
}