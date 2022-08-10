import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String sentence = br.readLine();

        Password[] arr = new Password[str.length()];        

        int cnt = 0;
        int plus = sentence.length() / str.length();        

        for(int i=0; i<str.length(); i++){
            arr[i] = new Password(str.charAt(i), "", i);            
        }

        Arrays.sort(arr);

        for(int i=0; i<str.length(); i++){
            arr[i].value = sentence.substring(cnt, cnt + plus);
            cnt += plus;
        }

        // for(Password k : arr){
        //     System.out.println(k.key + " " + k.value);
        // }

        
        Arrays.sort(arr, new Comparator<Password>(){
            public int compare(Password o1, Password o2){
                return Integer.valueOf(o1.idx).compareTo(Integer.valueOf(o2.idx));
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<plus; i++){
            for(int j=0; j<arr.length; j++){
                sb.append(arr[j].value.charAt(i) + "");
            }
        }
        
        System.out.println(sb);

    }
}

class Password implements Comparable<Password>{
    char key;
    String value;
    int idx;

    Password(char key, String value, int idx){
        this.key = key;
        this.value = value;
        this.idx = idx;
    }

    public int compareTo(Password o2){
        if(key > o2.key){
            return 1;
        }else if(key < o2.key){
            return -1;
        }else{
            return Integer.valueOf(idx).compareTo(Integer.valueOf(o2.idx));
        }
    }


}