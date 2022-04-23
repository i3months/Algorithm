import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            tm.put(temp1, temp2);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());            

            if(command == 1){
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                tm.put(key, value);
            }

            if(command == 2){
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                if(tm.containsKey(key)){
                    tm.put(key, value);

                }else{
                    int up = 0;
                    int down = 0;
    
                    boolean up_chk = false;
                    boolean down_chk = false;
    
                    if(tm.ceilingKey(key) != null){
                        up = tm.ceilingKey(key);
                    }else{
                        up_chk = true;
                    }
    
                    if(tm.floorKey(key) != null){
                        down = tm.floorKey(key);
                    }else{
                        down_chk = true;
                    }
    
                    if(up_chk && down_chk){
    
                    }else{
                        if(up_chk && up - key <= K){
                            tm.put(down, value);
                        }else if(down_chk && key - down <= K){
                            tm.put(up, value);
                        }else if(up_chk == false && down_chk == false){
                            if(up - key < key - down && up - key <= K){
                                tm.put(up, value);
                            }else if(up - key > key - down && key - down <= K){
                                tm.put(down, value);
                            }
                        }
                    }

                }

            } // end of command 2

            if(command == 3){
                int key = Integer.parseInt(st.nextToken());
                
                if(tm.containsKey(key)){
                    sb.append(tm.get(key) + "\n");
                }else{
                    int up = 0;
                    int down = 0;
    
                    boolean up_chk = false;
                    boolean down_chk = false;
    
                    if(tm.ceilingKey(key) != null){
                        up = tm.ceilingKey(key);
                    }else{
                        up_chk = true;
                    }
    
                    if(tm.floorKey(key) != null){
                        down = tm.floorKey(key);
                    }else{
                        down_chk = true;
                    }
    
                    if(up_chk && down_chk){
                        sb.append("-1\n"); // 둘다 null이면 만족하는 키가 없는것. -1 출력
                    }else{
                        if(up_chk && key - down <= K){
                            sb.append(tm.get(down) + "\n"); // 하나만 null이고 K조건 맞으면 
                        }else if(down_chk && up - key <= K){
                            sb.append(tm.get(up) + "\n");// 하나만 null이고 K조건 맞으면
                        }else if(up_chk == false && down_chk == false){
                            if(up - key == key - down && up - key <= K){
                                sb.append("?\n");
                            }else if(up - key < key - down && up - key <= K){
                                sb.append(tm.get(up) + "\n"); 
                            }else if(up - key > key - down && key - down <= K){
                                sb.append(tm.get(down) + "\n");
                            }else{
                                sb.append("-1\n");
                            }
                        }else{
                            sb.append("-1\n");
                        }
                    }

                }
                
                
            } // end of command 3
            
        }

        System.out.println(sb);

    }

}
