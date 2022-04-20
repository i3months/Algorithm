import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashSet<String> hs = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");

            if(str[1].equals("enter")){
                hs.add(str[0]);
            }else{
                hs.remove(str[0]);
            }
        }

        ArrayList<String> list = new ArrayList<>(hs);

        Collections.sort(list, Collections.reverseOrder());

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}