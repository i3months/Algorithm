import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Maan{
	static char number[];//받는 배열
	static int n;//찾을 순열의 위치
	static int M;//입력받은 배열의 크기
	static String str;
	static char arr[];//입력받는애들 담는 배열
	static boolean isSelected[];
	static int max = Integer.MAX_VALUE;
	static int total;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        String input = "";

		while((input = br.readLine()) != null) {			
            String[] st = input.split(" ");
			str = st[0];//입력
			arr = new char[str.length()];
			M=str.length();
			for(int i=0;i<str.length();i++) {
				arr[i]=str.charAt(i);
			}
			n = Integer.parseInt(st[1]);//찾을 순열의 위치
			isSelected = new boolean[str.length()];
			total = 0;
			number = new char[str.length()];
			permutation(0);

			if(total<n) {
				System.out.println(str+" "+n+" "+"="+" "+"No permutation");
			}
		}
	}

	private static void permutation(int cnt) {
		if(cnt==str.length()) {
			total++;
			if(total==n) {
				System.out.print(str+" "+n+" "+"="+" ");
				for(int i=0;i<str.length();i++) {
					System.out.print(number[i]);
				}
				System.out.println();
				return;
			}
		}
		
		for(int i=0;i<str.length();i++) {
			if(isSelected[i]) continue;
			number[cnt]=arr[i];
			isSelected[i]=true;
			permutation(cnt+1);
			isSelected[i]=false;
		}
	}
}

