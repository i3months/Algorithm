import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int N;
    static int cnt;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            

        int N = Integer.parseInt(br.readLine());

        ArrayList<Popularity> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            list.add(new Popularity());
            list.get(i).name = st.nextToken();
        }

        // for(Popularity k : list){
        //     System.out.println(k.name + " " + k.num);
        // }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()){
                Popularity tmp = new Popularity();
                tmp.name = st.nextToken();

                int idx = list.indexOf(tmp);
                
                list.get(idx).num++;            
            }
        }

        Collections.sort(list);

        for(Popularity k : list){
            System.out.println(k.name + " " + k.num);
        }
        
    }
}

class Popularity implements Comparable<Popularity>{
    String name;
    int num;

    public int compareTo(Popularity o2){
        if(num > o2.num){
            return -1;
        }else if(num < o2.num){
            return 1;
        }else{
            return name.compareTo(o2.name);
        }
    }

    @Override
    public boolean equals(Object o2){
            
        if(this.name.compareTo(((Popularity)o2).name) == 0){
            return true;
        }else{
            return false;
        }
    }

}