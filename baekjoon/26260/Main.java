import java.io.*;
import java.util.*;
 
public class Main {    	

    static int[] arr;
    static ArrayList<Integer> list2 = new ArrayList<>();

    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }

        int add = Integer.parseInt(br.readLine());
        
        for(int i=1; i<N+1; i++) {
            if(arr[i] == -1) {
                arr[i] = add;
            }
        }

        Arrays.sort(arr);
        
        solve(1, N+1);

        for(int k : list2) {
            System.out.print(k + " ");
        }

        
        
        
    }
    static void solve(int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;

            solve(left, mid);
            solve(mid+1, right);
            list2.add(arr[mid]);
        }
    }
}