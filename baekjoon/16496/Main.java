import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            list.add(st.nextToken());
        }

        Collections.sort(list, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String tmp1 = s1 + s2;
                String tmp2 = s2 + s1;

                return -tmp1.compareTo(tmp2);            
            }
        });

        int cnt = 1;
        for(String k : list) {            
            if(k.charAt(0) == '0' && cnt == 1) {
                System.out.println(0);
                return;
            }
            cnt++;
            System.out.print(k);
        }
        
    }
}
