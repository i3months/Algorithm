import java.util.*;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
 
		String str = sc.nextLine();
 
		Stack<Character> st = new Stack();
 
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				sb.append(str.charAt(i)); // 문자 나오면 문자 넣어
			} else if (str.charAt(i) == '(') {
				st.push('('); // ( 나오면 스택에 넣어
			} else if (str.charAt(i) == ')') {
				char check = '0'; // 임시값
				while (check != '(') { // ) 가 나오면 스택에 저장된게 ( 가 될때까지 뽑아낸다.
					check = st.pop();
					if (check == '(') { // ( 가 나오면 브레이크
						break;
					} else {
						sb.append(check); // (가 아니면 스택에 저장된 거 출력
					}
				}
			} else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				// +와 - 는 같고 *와 / 는 다름. 즉 계산에 우선순위가 있다.
				if (st.empty()) {
					st.push(str.charAt(i));
				} else {
					while (st.peek() == '*' || st.peek() == '/' || st.peek() == '-' || st.peek() == '+') {
 
						sb.append(st.pop());
						
						if (st.empty()) {
							break;
						}
					}
					st.push(str.charAt(i));
				}
			} else if (str.charAt(i) == '*' || str.charAt(i) == '/') {
				if (st.empty()) {
					st.push(str.charAt(i));
				} else {
					while (st.peek() == '*' || st.peek() == '/') {
 
						sb.append(st.pop());
 
						if (st.empty()) {
							break;
						} 
					}
					st.push(str.charAt(i));
				}
			}
		}
		for (int i = 0; i < st.capacity(); i++) {
			if (st.empty()) {
				break;
			} else {
				sb.append(st.pop());
			}
		}
 
		System.out.print(sb);
 
	}
}