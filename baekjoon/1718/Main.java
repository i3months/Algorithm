import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String plainText = in.readLine(), key = in.readLine();
		System.out.println(encrypt(plainText, key));
		in.close();
	}
	private static StringBuilder encrypt(String plainText, String key){
		int i, gap, pLen = plainText.length(), kLen = key.length();
		StringBuilder ciperText = new StringBuilder();
		char a;
		for(i=0;i<pLen;i++){
			a = plainText.charAt(i);
			if(a!=' '){
				gap = (key.charAt(i%kLen)-96);
				ciperText.append((char)(a-gap<97?(a-gap+26):a-gap));
			}
			else ciperText.append(' ');
		}
		return ciperText;
	}
}