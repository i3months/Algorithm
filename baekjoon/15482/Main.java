import java.io.*;
import java.util.*;
 
public class Main {

    static String str1;
    static String str2;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length()][str2.length()];

        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(LCS(str1.length() - 1, str2.length() - 1));

        // for(int i=0; i<str1.length(); i++){
        //     for(int j=0; j<str2.length(); j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
    }

    static int LCS(int a, int b){
        
        if(a == -1 || b == -1){
            return 0;
        }

        if(dp[a][b] == -1){            

            if(str1.charAt(a) == str2.charAt(b)){
                dp[a][b] = LCS(a - 1, b - 1) + 1;
            }else{
                dp[a][b] = Math.max(LCS(a -1, b), LCS(a, b-1));
            }
        }

        return dp[a][b];
        
    }
}
