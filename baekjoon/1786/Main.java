import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = br.readLine();

        list = new ArrayList<>();

        int[] pi = new int[target.length()];

        int j = 0;

        for(int i=1; i<target.length(); i++){
            while(j > 0 && target.charAt(j) != target.charAt(i)){
                j = pi[j-1];
            }

            if(target.charAt(j) == target.charAt(i)){
                j++;
                pi[i] = j;
            }
        }

//        for(int k : pi){
//            System.out.print(k + " ");
//        }


        j = 0;
        int str_len = str.length();
        int target_len = target.length();

        for(int i=0; i<str_len; i++){
            while(j > 0 && str.charAt(i) != target.charAt(j)){
                j = pi[j-1];
            }

            if(str.charAt(i) == target.charAt(j)){
                if(j + 1 == target_len){
                    list.add(i - target_len + 2);
                    j = pi[j];
                }else{
                    j++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int k : list){
            sb.append(k + " ");
        }

        System.out.println(list.size());
        System.out.println(sb);

        

    }
}
