import java.util.LinkedList;
import java.util.Queue;

public class ex05_09 {
    public static void main(String[] args) {
        boolean[] visited=new boolean[9];

        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<9;i++)
            adj.add(new ArrayList<Integer>());

        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(1).add(8);
        
        adj.get(2).add(1);
        adj.get(2).add(7);
        
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(5);
        
        adj.get(4).add(3);
        adj.get(4).add(5);
        
        adj.get(5).add(3);
        adj.get(5).add(4);
        
        adj.get(6).add(7);
        
        adj.get(7).add(2);
        adj.get(7).add(6);
        adj.get(7).add(8);
        
        adj.get(8).add(1);
        adj.get(8).add(7);

        dfs(adj, 1, visited);
    }
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }
}