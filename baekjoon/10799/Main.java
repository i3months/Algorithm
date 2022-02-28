import java.util.*;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		String str = sc.nextLine();
		
		Stack<Character> st = new Stack();
		
		int count = 0;
		int sum = 0;
		int stick = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				st.push('(');
				count++;
			}else if(str.charAt(i)==')') {
				count--;
				if(st.peek()=='(') {
					sum = sum + count;
					st.push(')');
				}else {
					st.push(')');
					stick++;
				}
			}
		}
		
		System.out.print(sum+stick);
 
	}
}