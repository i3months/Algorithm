import java.util.*;

import org.xml.sax.InputSource;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());

            if(N == 0){
                break;
            }
            ArrayList<String> name = new ArrayList<>();

            for(int i=0; i<N; i++){
                name.add(br.readLine());
            }

            int[] arr = new int[101];

            for(int i=0; i<N*2 -1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int temp = Integer.parseInt(st.nextToken());
                char temp2 = st.nextToken().charAt(0);
                
                arr[temp-1]++;
                
            }

            for(int i=0; i<arr.length; i++){
                if(arr[i] == 1){
                    sb.append(cnt + " " + name.get(i) + "\n");
                }
            }

            cnt++;


        }

        System.out.println(sb);
    }

}