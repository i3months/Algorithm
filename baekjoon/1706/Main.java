import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] crossword = new char[R][C];

		for(int i=0; i<R; i++){
			String str = br.readLine();
			for(int j=0; j<C; j++){
				crossword[i][j] = str.charAt(j);
			}
		}

		ArrayList<String> dict = new ArrayList<>();

		for(int i=0; i<R; i++){
			int seq = 0;
			String str = "";
			for(int j=0; j<C; j++){
				if(crossword[i][j] != '#'){
					seq++;
					str = str + crossword[i][j];
				}else if(crossword[i][j] == '#'){
					if(seq >=2){
						dict.add(str);
					}
					str = "";
					seq = 0;
				}

				if(j == C-1){
					if(seq>=2){
						dict.add(str);
					}
				}

			}
		} // row에 대해서 조사

		for(int j=0; j<C; j++){
			int seq = 0;
			String str = "";
			for(int i=0; i<R; i++){
				if(crossword[i][j] != '#'){
					seq++;
					str = str + crossword[i][j];
				}else if(crossword[i][j] == '#'){
					if(seq >=2){
						dict.add(str);
					}
					str = "";
					seq = 0;
				}

				if(i == R-1){
					if(seq>=2){
						dict.add(str);
					}
				}

			}
		} // column에 대해서 조사

		Collections.sort(dict);

		System.out.println(dict.get(0));

	}
}