import java.util.*;
import java.io.*;
import java.math.*;

public class Main{

	static BigInteger[] arr;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new BigInteger[N+1];

		arr[0] = new BigInteger("0");
		arr[1] = new BigInteger("1");		

		System.out.println(fibo(N));



	}

	static BigInteger fibo(int n){		
		if(arr[n] == null){
			arr[n] = fibo(n-1).add(fibo(n-2));
		}
		return arr[n];
	}
}