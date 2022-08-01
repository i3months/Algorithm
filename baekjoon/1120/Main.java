import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int ans = a.length();

        for(int i=0; i<b.length() - a.length() + 1; i++){
            int cnt = 0;
            for(int j=0; j<a.length(); j++){
                if(a.charAt(j) != b.charAt(i + j)){
                    cnt++;
                }                
            }
            ans = Math.min(cnt, ans);
        }

        System.out.println(ans);
    }
}