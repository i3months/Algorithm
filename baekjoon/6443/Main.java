import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int TC;
    static char[] select;
    static int[] visit;
    static char[] string;

    static int ans;

    static TreeSet<String> ts = new TreeSet<>();

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        
        TC = Integer.parseInt(br.readLine());

        while(TC-- > 0){
            ts.clear();
            string = br.readLine().toCharArray();

            visit = new int[27];
            select = new char[string.length];   
            
            for(char k : string){
                visit[k - 'a']++;
            }

            bt(0);

            for(String k :ts){
                sb.append(k + "\n");
            }
        }

        System.out.println(sb);
            
        
    }

    
    static void bt(int len){
        if(len == string.length){
            String tmp = "";
            for(char k : select){
                tmp += k + "";
            }
            
            ts.add(tmp);
            return;
        }

        for(int i=0; i<26; i++){
            if(visit[i] > 0){
                visit[i]--;
                select[len] = (char)(i + 'a');
                bt(len + 1);
                visit[i] ++;       
                select[len] = ' ';         
            }
        }
            
    }
}