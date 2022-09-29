import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> zero = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());

            if(a == 1){
                one.add(1);
                continue;
            }
            if(a == 0){
                zero.add(0);
                continue;
            }
            if(a > 0){
                positive.add(a);
                continue;
            }
            if(a < 0){
                negative.add(a);
                continue;
            }
        }

        Collections.sort(negative);
        Collections.sort(positive);

        int ans = 0;

        if(positive.size() % 2 == 1){
            ans += positive.get(0);    
            positive.remove(0);        
        }

        for(int i=0; i<positive.size(); i+=2){
            int a = positive.get(i);
            int b = positive.get(i+1);
            ans += (a*b);
        }

        if(negative.size() % 2 == 1 && zero.size() >= 1){
            negative.remove(negative.size()-1);
        }

        if(negative.size() % 2 == 1){
            ans += negative.get(negative.size()-1);   
            negative.remove(negative.size()-1);
        }

        for(int i=0; i<negative.size(); i+=2){
            int a = negative.get(i);
            int b = negative.get(i+1);
            ans += (a*b);
        }

        ans += 1 * one.size();

        System.out.println(ans);
        
        
    }
}