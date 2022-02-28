import java.util.*;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		StringBuilder sb = new StringBuilder();
 
		int cycle = sc.nextInt();
		sc.nextLine();
 
		for (int i = 0; i < cycle; i++) {
			String str = sc.nextLine();
			Stack<Character> st = new Stack();
			boolean check = false;
			for (int j = 0; j < str.length(); j++) { // 문자열 검사
				if (str.charAt(j) == '(') { // ( 들어오면 (를 스택에 넣어줌
					st.push(str.charAt(j));
				} else if (st.empty()) { // 스택이 비어있으면 ()
					check = true;
					break;
				} else if (str.charAt(j) == ')') { // ) 가 들어오면 가장 위에꺼 빼기
					st.pop();
				}
 
			}
			// 문자열 검사 이후 스택 비어있으면 ok 남아있는게 있으면 ㄴㄴ
			if (st.empty() && check) {
				sb.append("NO");
				sb.append("\n");
 
			} else if (st.empty()) {
				sb.append("YES");
				sb.append("\n");
 
			} else {
				sb.append("NO");
				sb.append("\n");
			}
		}
 
		System.out.println(sb);
 
	}
}