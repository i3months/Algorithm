import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Tree t = new Tree();

		for(int i=0; i<N; i++){
			String[] arr = br.readLine().split(" ");
			t.create(arr[0].charAt(0), arr[1].charAt(0), arr[2].charAt(0));	
		}

		t.preorder(t.root);
		System.out.println();

		t.inorder(t.root);
		System.out.println();

		t.postorder(t.root);


		
	}
	
	static class Node{ 
		char value = ' ';
		Node left;
		Node right;

		Node(char value){
			this.value = value;
		}
	} // 노드 객체를 만들기. 이진 트리이므로 노드는 값과 왼쪽과 오른쪽 노드로 구성됨.

	static class Tree{
		Node root;

		 void create(char value, char leftvalue, char rightvalue){
			if(root == null){ // 입력받을 때 루트 노드가 비어있으면 (제일 처음 입력받을 때) 노드를 생성한다.
				root = new Node(value);

				if(leftvalue != '.'){ // . 을 입력받으면 노드를 생성하지 않는다
					root.left = new Node(leftvalue);
				}

				if(rightvalue != '.'){// .을 입력받으면 노드를 생성하지 않는다
					root.right = new Node(rightvalue);
				}
			}else{ // 처음 상태가 아니면 어느 쪽에 노드를 생성할 지 찾아야 함.
				searchNode(root, value, leftvalue, rightvalue);
			}
		}

		void searchNode(Node root, char value, char leftvalue, char rightvalue){ // 초기 상태가 아닌 노드를 결정할 때 사용.
			if(root == null){ // 루트 노드를 입력받지 않으면 노드를 만들지 않음
				return;
			}else if(root.value == value){// 탐색에 성공했을 때 노드를 생성함

				if(leftvalue != '.'){
					root.left = new Node(leftvalue);
				}

				if(rightvalue != '.'){
					root.right = new Node(rightvalue);
				}
			}else{ // 탐색에 실패했고, 탐색할 노드가 남아있으면 계속해서 탐색을 진행함.
				searchNode(root.left, value, leftvalue, rightvalue);
				searchNode(root.right, value, leftvalue, rightvalue);
			}
		}

		void preorder(Node root){ // 전위 순회
			System.out.print(root.value); 
			if(root.left != null){
				preorder(root.left);
			}

			if(root.right != null){ 
				preorder(root.right);
			}
		}

		void inorder(Node root){ // 중위 순회
			if(root.left != null){
				inorder(root.left);
			}

			System.out.print(root.value);

			if(root.right != null){
				inorder(root.right);
			}

		}

		void postorder(Node root){ // 후위 순회
			if(root.left != null){
				postorder(root.left);
			}

			if(root.right != null){
				postorder(root.right);
			}

			System.out.print(root.value);

		}
	}

	
}