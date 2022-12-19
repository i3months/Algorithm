import java.io.*;
import java.util.*;
 
public class Main {

    static int[] arr;
    static int N, C;
    static int idx;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();

        dfs(1, N/2, list1, 0);
        dfs(N/2+1, N, list2, 0);

        Collections.sort(list2);

        long ans = 0;

        for(long k : list1) {            
            idx = -1;
            binarySearch(0, list2.size() - 1, k, list1, list2);
            ans += idx + 1;
        }

        System.out.println(ans);

        // for(long k : list1) {
        //     System.out.println(k);
        // }

        // System.out.println("dbug");
        // for(long k : list2) {
        //     System.out.println(k);
        // }
     


    }

    static void binarySearch(int start, int end, long val, ArrayList<Long> li1, ArrayList<Long> li2) {
        if(start > end) return;

        int mid = (start + end) / 2;
        
        if(li2.get(mid) + val <= C) {
            idx = mid;
            binarySearch(mid + 1, end, val, li1, li2);
        } else {
            binarySearch(start, mid - 1, val, li1, li2);
        }
        
        
    }

    static void dfs(int start, int end, ArrayList<Long> li, long sum) {
        if(start > end) {
            li.add(sum);
            return;
        } else {
            dfs(start + 1, end, li, sum);
            dfs(start + 1, end, li, sum + arr[start]);   
        }

    }
}