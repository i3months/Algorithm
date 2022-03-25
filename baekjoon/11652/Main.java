import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        int cnt = 1, max = 1, maxIdx = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]) cnt++;
            else cnt = 1;

            if(cnt > max) {
                max = cnt;
                maxIdx = i;
            }
        }
        System.out.println(arr[maxIdx]);
    }
}