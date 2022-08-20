import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        
        Node root = new Node(Integer.parseInt(br.readLine()));

        String str = "";

        while((str = br.readLine()) != null){
            root.insert(Integer.parseInt(str));
        }

        postOrder(root);
        
    }
    static void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }
}

class Node{
    int val;
    Node left, right;

    Node(int val){
        this.val = val;
    }

    Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void insert(int N){
        if(N < this.val){
            if(this.left == null){
                this.left = new Node(N);
            }else{
                this.left.insert(N);
            }
        }

        if(N > this.val){
            if(this.right == null){
                this.right = new Node(N);
            }else{
                this.right.insert(N);
            }
        }

    }
}