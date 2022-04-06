import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Student[] arr = new Student[N];
        
        for(int i=0;i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());                    
            arr[i] = new Student(s,e);    
        }

        Arrays.sort(arr, new Comparator<Student>(){
            public int compare(Student o1, Student o2){
                if(o1.end > o2.end){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        int temp1 = arr[0].end;

        Arrays.sort(arr, new Comparator<Student>(){
            public int compare(Student o1, Student o2){
                if(o1.start > o2.start){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        int temp2 = arr[0].start;

        if(temp2 - temp1 > 0){
            System.out.println(temp2 - temp1);
        }else{
            System.out.println(0);
        }

    }
    

    static class Student{

        int start;
        int end;

        Student(int a, int b){
            start = a;
            end = b;
        }
    }

}