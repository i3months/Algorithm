import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) list1.add(Integer.parseInt(st.nextToken()));
        for(int i=0; i<n-1; i++) list2.add(list1.get(i+1) - list1.get(i));
        
        Collections.sort(list2);

        int ans = 0;
        for(int i=0; i<n-k; i++) ans += list2.get(i);

        System.out.println(ans);
        

    }
}

