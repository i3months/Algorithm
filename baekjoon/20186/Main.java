import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            list.add( Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, Collections.reverseOrder());
        int sum = 0;

        for(int i=0; i<K; i++){
            sum += list.get(i);
        }

        System.out.println(sum - (K*(K-1)/2));
    }
}