import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        
        while(st.hasMoreTokens()){
            list1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            list2.add(Integer.parseInt(st.nextToken()));
        }

        int cnt1 = 0;
        int cnt2 = 0;

        boolean chk = false;
        int draw_cnt = 0;


        for(int i=0; i<list1.size(); i++){
            if(list1.get(i) > list2.get(i)){
                cnt1 = cnt1 + 3;
                chk = false;
            }else if(list1.get(i) < list2.get(i)){
                cnt2 = cnt2 + 3;
                chk = true;
            }else{
                cnt1++;
                cnt2++;
                draw_cnt++;

            }
        }

        System.out.println(cnt1 + " " + cnt2);
        if(cnt1 > cnt2){
            System.out.println('A');
        }else if(cnt1 < cnt2){
            System.out.println("B");
        }else{
            if(draw_cnt == 10){
                System.out.println("D");
            }else{
                if(chk){
                    System.out.println("B");
                }else{
                    System.out.println("A");
                }
            }
        }

    }
}