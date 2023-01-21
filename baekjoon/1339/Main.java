import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<n; i++) {
            String str = br.readLine();

            int idx = -1;
            for(int j=str.length()-1; j>=0; j--) {
                idx++;
                char tmp = str.charAt(j);                                                    
                int val = hm.getOrDefault(tmp, 0);
                val += Math.pow(10, idx);
                hm.put(tmp, val);                
            }
        }

        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Character> li = new ArrayList<>(hm.keySet());

        for(Character k : li) {
            int val = hm.get(k);
            list.add(new Node(k, val));            
        }

        Collections.sort(list);
        int sum = 0;

        int z = 9;
        for(Node k : list) {
            // String str = String.valueOf(k.v);
            // String str2 = str.replace('1', String.valueOf(z).charAt(0));
            int vvv = k.v * z;
            sum += vvv;   
            // int vv = Integer.parseInt(str2);
            z--;
            // sum += vv;
            
        }

        System.out.println(sum);



        
        
        

    }   

    static class Node implements Comparable<Node>{
        char c;
        int v;

        Node(char c, int v) {
            this.c = c;
            this.v = v;
        }

        @Override
        public int compareTo(Node o2) {
            // return this.v - v;
            return o2.v - this.v;
            
        }
    }
}
