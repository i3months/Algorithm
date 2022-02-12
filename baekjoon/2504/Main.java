import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		Stack<Character> st = new Stack<>();
		int ans = 0;
		int temp = 1;

		for(int i=0; i<str.length(); i++){

			if(str.charAt(i)=='('){
				st.push('(');
				temp = temp * 2;
			}else if(str.charAt(i)=='['){
				st.push('[');
				temp = temp * 3;
			}else if(str.charAt(i)==')'){
				if(st.empty()||st.peek()!='('){
					ans = 0;
					break;
				}else if(str.charAt(i-1)=='('){
					ans = ans + temp;
				}		
					st.pop();
					temp = temp / 2;
			}else if(str.charAt(i)==']'){
				if(st.empty()||st.peek()!='['){
					ans =0;
					break;
				}else if(str.charAt(i-1)=='['){
					ans = ans + temp;
				}
					st.pop();
					temp = temp / 3;
			}
		}

		if(st.empty()){
			System.out.println(ans);
		}else{
			System.out.println(0);
		}


	}
}