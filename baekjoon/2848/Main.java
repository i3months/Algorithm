import java.io.*;
import java.util.*;
 
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[27];
        HashSet<Character> hs = new HashSet<>();        
        ArrayList<String> strList = new ArrayList<>();
        int[] inDegree = new int[27];

        for(int i=0; i<27; i++) list[i] = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String str = br.readLine();

            for(int j=0; j<str.length(); j++) hs.add(str.charAt(j));
            strList.add(str);
        
        }

        boolean multiple = false;
        boolean none = false;

        for(int i=0; i<N-1; i++) {
            int len1 = strList.get(i).length();
            int len2 = strList.get(i+1).length();

            int minLen = Math.min(len1, len2);

            for(int j=0; j<minLen; j++) {
                char c1 = strList.get(i).charAt(j);
                char c2 = strList.get(i+1).charAt(j);

                if(c1 != c2) {
                    list[c1 - 'a'].add(c2 - 'a');
                    inDegree[c2 - 'a']++;
                    break;
                }

                if(j == minLen - 1) {
                    if(len1 > len2) none = true;   
                    
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();

        for(char k : hs) {
            if(inDegree[k - 'a'] == 0) q.add(k - 'a');
        }

        ArrayList<Character> ansList = new ArrayList<>();

        while(!q.isEmpty()) {
            if(q.size() >= 2) multiple = true;

            int cur = q.poll();

            ansList.add((char)(cur + 'a'));

            for(int k : list[cur]) {
                inDegree[k]--;

                if(inDegree[k] == 0) q.add(k);
            }
        }

        if(ansList.size() != hs.size()) none = true;

        if(none) System.out.println("!");
        else if(multiple) System.out.println("?");
        else for(int k : ansList) System.out.print((char)k);
        

        

    }
}
