import java.util.*;

class Solution {
    static int n, addedNode, type1, type2, type3;
    static List<List<Integer>> graph;
    static List<Integer> graphCnt;
    static boolean[] visited;
        
    public int[] solution(int[][] edges) {        
        
        for(int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        
        graph = new ArrayList<>();
        graphCnt = new ArrayList<>();
        visited = new boolean[n+1];
        
        for(int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
            graphCnt.add(0);
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graphCnt.set(edge[1], graphCnt.get(edge[1]) + 1);
        }
        
        for (int i=1; i<n+1; i++) {
            if (graphCnt.get(i) == 0 && graph.get(i).size() >= 2) addedNode = i;
        }
        
        for(int curNode : graph.get(addedNode)) {
            graphCnt.set(curNode, graphCnt.get(curNode) - 1);
        }
        
        visited[addedNode] = true;
        for (int curNode : graph.get(addedNode)) {
            if (!visited[curNode]) {
                bfs(curNode);
            }
        }
        
        return new int[]{addedNode, type1, type2, type3};
    }
    
    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        
        while(!q.isEmpty()) {
            int curNode = q.poll();
            
            if (graph.get(curNode).isEmpty()) {
                type2++;
                return;
            }
            
            if (graph.get(curNode).size() == 2 && graphCnt.get(curNode) == 2) {
                type3++;
                return;
            }
            
            for (int traverseNode : graph.get(curNode)) {
                if (!visited[traverseNode]) {
                    q.add(traverseNode);
                    visited[traverseNode] = true;
                }
            }
            
        }
        
        type1++;
        return;
        
        
    }
}