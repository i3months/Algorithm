import java.util.*;
 
public class Main2 {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		Stack<Double> st = new Stack();
 
		int cycle = sc.nextInt();
		sc.nextLine();
 
		double[] arr = new double[cycle];
 
		String str = sc.nextLine();
 
		for (int i = 0; i < cycle; i++) {
			arr[i] = sc.nextInt();
		}
 
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				st.push(arr[str.charAt(i) - 'A']);
			} else if (str.charAt(i) == '*') {
				double temp1 = st.pop();
				double temp2 = st.pop();
				st.push(temp2 * temp1);
			} else if (str.charAt(i) == '+') {
				double temp1 = st.pop();
				double temp2 = st.pop();
				st.push(temp2 + temp1);
			} else if (str.charAt(i) == '-') {
				double temp1 = st.pop();
				double temp2 = st.pop();
				st.push(temp2 - temp1);
			} else if (str.charAt(i) == '/') {
				double temp1 = st.pop();
				double temp2 = st.pop();
				st.push(temp2 / temp1);
			}
		}
 
		double ans = st.pop();
 
		System.out.print(String.format("%.2f", ans));
 
	}
}