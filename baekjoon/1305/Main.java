import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int[] pi = getPi(str);

        System.out.println(L - pi[L-1]);



    }

    static int kmp(int[] pi, String str, String target){
        int j=0;
        int str_len = str.length();
        int target_len = target.length();

        for(int i=0; i<str_len; i++){
            while(j > 0 && str.charAt(i) != target.charAt(j)){
                j = pi[j-1];
            }

            if(str.charAt(i) == target.charAt(j)){
                if(j+1 == target_len){
                    return 1;
                }else{
                    j++;
                }
            }
        }

        return 0;
    }

    static int[] getPi(String str){
        int j = 0;
        int n = str.length();
        int[] pi = new int[n];

        for(int i = 1; i < n; i++) {
            while(j > 0 && str.charAt(j) != str.charAt(i)) {
                j = pi[j - 1];
            }

            if(str.charAt(j) == str.charAt(i)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
