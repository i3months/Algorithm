import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();      
    static final int INF = 987654321;  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            PriorityQueue<Student> students = new PriorityQueue<>();

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                students.add(new Student(a, b));
            }            

            int ans = 0;
            boolean[] visit = new boolean[n+1];

            while(!students.isEmpty()) {
                Student cur = students.poll();

                for(int i=cur.start; i<cur.end+1; i++) {
                    if(!visit[i]) {
                        visit[i] = true;
                        ans++;
                        break;
                    }
                }
            }

            System.out.println(ans);

        }

    }
}

class Student implements Comparable<Student>{
    int start, end;

    Student(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Student s) {
        return end - s.end;
    }

    
}