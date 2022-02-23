import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();


		String str = br.readLine();

		int sum = 0;

		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)>= 'a' && str.charAt(i) <= 'z'){
				sum = sum + str.charAt(i) - 'a' +1 ;
			}else{
				sum = sum + str.charAt(i) - 'A' + 26 + 1;
			}
		}

		if(isPrime(sum)==0){
			System.out.println("It is not a prime word.");
		}else{
			System.out.println("It is a prime word.");
		}

	}
	static int isPrime(int n) {
		for (int i = 2; i<=(int)Math.sqrt(n); i++) {
				if (n % i == 0) {
						return 0;
				}
		}
		return 1;
	}
}

		
