import java.io.*;
import java.util.*;
// 2번 답
public class Solution2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

    }
}