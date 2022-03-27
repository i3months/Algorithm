import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, String> hm = new HashMap<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            hm.put(num,str);
        }


        List<Integer> kl = new ArrayList<>(hm.keySet());

        Collections.sort(kl);

        System.out.println(hm.get(kl.get(0)));


    }
}