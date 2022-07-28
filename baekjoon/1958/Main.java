import java.io.*;
import java.util.*;
 
public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] dp;    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();


        int[][][] dp = new int[len1 + 1][len2 + 1][len3 + 1];

        for(int i=1; i<len1 +1; i++){
            for(int j =1; j<len2 + 1; j++){
                for(int k = 1; k<len3 + 1; k++){
                    if(str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }else{
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
		

        System.out.println(dp[len1][len2][len3]);
	}
}
