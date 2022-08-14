import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
        
    static char[] str;
    static ArrayList<Bracket> list = new ArrayList<>();
    static boolean[] visit;
    static boolean chk = true;

    static TreeSet<String> ts = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> st = new Stack<>();

        str = br.readLine().toCharArray();

        for(int i=0; i<str.length; i++){
            char tmp = str[i];

            if(tmp == '('){
                st.push(i);                
            }

            if(tmp == ')'){
                list.add(new Bracket(st.pop(), i));
            }
        }

        visit = new boolean[str.length];
        Arrays.fill(visit, true);
        find(0);        
        
        for(String k : ts){
            System.out.println(k);
        }

        
        
    }

    static void find(int depth){
        if(depth == list.size()){
            if(chk){
                chk = false;
            }else{
                StringBuilder sb2 = new StringBuilder();

                for(int i=0; i<str.length; i++){
                    if(visit[i]){
                        sb2.append(str[i]);
                    }
                }
                ts.add(sb2.toString());
            }
            return;
        }

        Bracket bracket = list.get(depth);
        visit[bracket.start] = true;
        visit[bracket.end] = true;
        find(depth + 1);

        visit[bracket.start] = false;
        visit[bracket.end] = false;
        find(depth + 1);


    }
}

class Bracket{
    int start, end;
    Bracket(int start, int end){
        this.start = start;
        this.end = end;
    }
}