import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());

        Member[] arr = new Member[82];

        for(int i=0; i<82; i++){
            arr[i] = new Member(0,i);
        }

        for(int i=1; i<s1+1; i++){
            for(int j = 1; j<s2+1; j++){
                for(int k=1; k<s3+1; k++){
                    arr[i + j + k].frequency++;
                }
            }
        }

        Arrays.sort(arr, new Comparator<Member>(){
           
            public int compare(Member o1, Member o2){
                if(o1.frequency > o2.frequency){
                    return -1;
                }else if(o1.frequency < o2.frequency){
                    return 1;
                }else{
                    if(o1.num > o2.num){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });

        System.out.println(arr[0].num);
        

    }
    static class Member{
        int frequency;
        int num;

        Member(int a, int b){
            frequency = a;
            num = b;
        }
    }
}

