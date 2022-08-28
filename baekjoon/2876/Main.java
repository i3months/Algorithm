import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                    

        int N = Integer.parseInt(br.readLine());

        Desk[] arr = new Desk[N];

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=1; i<6; i++){
            hm.put(i, 0);
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Desk(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int target = 1; target < 6; target++){
            int cnt = 0;            

            for(int i=0; i<N; i++){
                int A = arr[i].A;
                int B = arr[i].B;

                if((A == target || B == target)){
                    cnt++;

                    int tmp = hm.getOrDefault(target, 0);
                    int max = Math.max(tmp, cnt);

                    hm.put(target, max);                    
                }

                if(!(A == target || B == target)){
                    cnt = 0;                    
                }
            
            }
        }

        ArrayList<Student> list = new ArrayList<>();

        for(int i=1; i<6; i++){
            list.add(new Student(hm.get(i), i));
        }

        Collections.sort(list);

        System.out.println(list.get(0).num + " " + list.get(0).grade);

        // System.out.println("bg");

        // for(Student k : list){
        //     System.out.println(k.grade + " " + k.num);
        // }

        

        

    }
}
class Student implements Comparable<Student>{
    int num, grade;

    Student(int num, int grade){
        this.num = num;
        this.grade = grade;
    }

    public int compareTo(Student o2){
        if(num > o2.num){
            return -1;        
        }else if(num < o2.num){
            return 1;
        }else{
            if(grade > o2.grade){
                return 1;
            }else{
                return -1;
            }
        }
    }
}

class Desk{
    int A,B;
    Desk(int A, int B){
        this.A = A;
        this.B = B;
    }
}