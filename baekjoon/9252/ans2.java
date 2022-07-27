import java.util.*;
 
public class ans2 {

  static StringBuilder sb = new StringBuilder();  

 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		char[] str1 = in.nextLine().toCharArray();
		char[] str2 = in.nextLine().toCharArray();
		
		int length_1 = str1.length;
		int length_2 = str2.length;
				
		int[][] dp = new int[length_1 + 1][length_2 + 1];
				
		for(int i = 1; i <= length_1; i++) {
			for(int j = 1; j <= length_2; j++) {				
				if(str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;	
				}else{
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
    
		sb.append(dp[length_1][length_2] + "\n");

    Stack<Character> st = new Stack<>();

    int i = length_1;
    int j = length_2;

    String str = "";
    for(int a=0; a<length_1; a++){
      str = str + str1[a];
    }

    while(i>0 && j>0) {
			
			if(i == 0 || j ==0)break;
			
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			}else if(dp[i][j] == dp[i][j-1]) {
				j--;
			}else {
				st.push(str.charAt(i-1));
				i--;
				j--;
			}
			
			
		}
		while(!st.isEmpty()) {
			sb.append(st.pop() + "");
		}
    
    System.out.println(sb);
		
	}
}