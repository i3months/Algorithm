import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        str = '.' + str;

        char[] Adrian = new char[101];
        char[] Bruno = new char[101];  
        char[] Goran = new char[101];

        for(int i=1; i<101; i++){
            if(i % 3 == 0){
                Adrian[i] = 'C';
            }else if(i % 3 == 1){
                Adrian[i] = 'A';
            }else if(i % 3 == 2){
                Adrian[i] = 'B';
            }
        }

        for(int i=1; i<101; i++){
            if(i % 4 == 0){
                Bruno[i] = 'C';
            }else if(i % 4 == 1){
                Bruno[i] = 'B';
            }else if(i % 4 == 2){
                Bruno[i] = 'A';
            }else if(i % 4 == 3){
                Bruno[i] = 'B';
            }
        }

          for(int i=1; i<101; i++){
            if(i % 6 == 0){
                Goran[i] = 'B';
            }else if(i % 6 == 1){
                Goran[i] = 'C';
            }else if(i % 6 == 2){
                Goran[i] = 'C';
            }else if(i % 6 == 3){
                Goran[i] = 'A';
            }else if(i % 6 == 4){
                Goran[i] = 'A';
            }else if(i % 6 == 5){
                Goran[i] = 'B';
            }
        }

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        for(int i=1; i<str.length(); i++){
            if(Adrian[i] == str.charAt(i)){
                cnt1++;
            }
            if(Bruno[i] == str.charAt(i)){
                cnt2++;
            }
            if(Goran[i] == str.charAt(i)){
                cnt3++;
            }
        }

        if(cnt1 == cnt2 && cnt2 == cnt3){
            sb.append(cnt1 + "\nAdrian\nBruno\nGoran");            
        }else if(cnt1 > cnt2 && cnt1 > cnt3){
            sb.append(cnt1 + "\nAdrian");
        }else if(cnt2 > cnt1 && cnt2 > cnt3){
            sb.append(cnt2 + "\nBruno");
        }else if(cnt3 > cnt1 && cnt3 > cnt2){
            sb.append(cnt3 + "\nGoran");
        }else if(cnt1 == cnt2 && cnt1 > cnt3){
            sb.append(cnt1 + "\nAdrian\nBruno");
        }else if(cnt1 == cnt3 && cnt1 > cnt2){
            sb.append(cnt1 + "\nAdrian\nGoran");
        }else if(cnt2 == cnt3 && cnt2 > cnt1){
            sb.append(cnt2 + "\nBruno\nGoran");
        }

        System.out.println(sb);


    }
}

