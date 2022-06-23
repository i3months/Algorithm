import java.util.*;
import java.io.*;
import java.math.*;

public class Main {	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			

			int N = Integer.parseInt(br.readLine());

			char[][] dictionary = new char[3][10];			

			String str1 = "qwertyuiop";
			String str2 = "asdfghjkl ";
			String str3 = "zxcvbnm   ";

			char[] a1 = str1.toCharArray();
			char[] a2 = str2.toCharArray();
			char[] a3 = str3.toCharArray();

			dictionary[0] = a1;
			dictionary[1] = a2;
			dictionary[2] = a3;
			

			for(int i=0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());

				String input = st.nextToken();
				int M = Integer.parseInt(st.nextToken());

				Word[] arr = new Word[M];

				for(int j=0; j<M; j++){
					arr[j] = new Word(br.readLine(), 0);
				}
				
				for(int j=0; j<M; j++){

					String target = arr[j].word;					
					int cnt = 0;

					for(int k=0; k<target.length(); k++){
						if(target.charAt(k) != input.charAt(k)){
							int r1 = 0, c1 = 0, r2 =0 , c2 = 0;

							loop1 : for(int m = 0; m<3; m++){
								for(int n = 0; n<10; n++){
									if(dictionary[m][n] == target.charAt(k)){
										r1 = m;
										c1 = n;
										break loop1;
									}
								}
							}

							loop1 : for(int m = 0; m<3; m++){
								for(int n = 0; n<10; n++){
									if(dictionary[m][n] == input.charAt(k)){
										r2 = m;
										c2 = n;
										break loop1;
									}
								}
							}

							cnt = cnt + Math.abs(r1 - r2) + Math.abs(c1 - c2);							

						}
					}
										
					arr[j].dis = cnt;
				}

				Arrays.sort(arr);

				for(int a=0; a<M; a++){
					System.out.println(arr[a].word + " " + arr[a].dis);
				}
				
			}


	}
}

class Word implements Comparable<Word>{
	String word;
	int dis;

	Word(String a, int b){
		word = a;
		dis = b;
	}

	public int compareTo(Word o2){
		if(dis > o2.dis){
			return 1;
		}else if(dis < o2.dis){
			return -1;
		}else{
			return word.compareTo(o2.word);
		}
	}

}