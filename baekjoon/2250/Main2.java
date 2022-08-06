import java.util.*;
import java.io.*;
import java.math.*;

public class Main2 {   
  
  static ArrayList<Node>[] list;
  static ArrayList<Integer>[] node_list;
  static int height = 1;
  static int row = 0;
  static int root = - 1;

  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
      int N = Integer.parseInt(br.readLine());

      list = new ArrayList[N + 1];
      node_list = new ArrayList[N + 1];

      for(int i=1; i<N+1; i++){
        list[i] = new ArrayList<>();
        node_list[i] = new ArrayList<>();
      }

      int[] level = new int[N+1];

      for(int i=0; i<N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        if(left != -1){
          level[left]++;          
        }

        if(right != -1){
          level[right]++;
        }

        list[num].add(new Node(left, right));
      }

      for(int i=1; i<N+1; i++){
        if(level[i] == 0){
          root = i;
          break;
        }
      } // 루트찾기

      dfs(root); //dfs돌려

      int max = -1;
      int tmp_level = 0;

      for(int i=1; i<N+1; i++){

        int len = node_list[i].size();
        if(len > 0){
          int start = node_list[i].get(0);
          int end = node_list[i].get(len - 1);
          int width = end - start + 1;

          if(max < width){
            max = width;
            tmp_level = i;
          }

        }  
      }

      System.out.println(tmp_level + " " + max);
        
      

      

        
    }

    static void dfs(int node){

      for(Node k : list[node]){
        
        if(k.left != -1){
          height++;
          dfs(k.left);
        }

        row++;

        node_list[height].add(row);

        if(k.right != -1){
          height++;
          dfs(k.right);
        }
        height--;

      }
    }


}

class Node{
  int left, right;
  Node(int left, int right){
    this.left = left;
    this.right = right;
  }
}