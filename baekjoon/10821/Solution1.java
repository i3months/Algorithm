import java.io.*;
import java.util.*;
// 1번 답
public class Solution1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        int cnt  = 0;
        while(st.hasMoreTokens()){
            st.nextToken();
            cnt++;
        }
        System.out.println(cnt);



    }
}