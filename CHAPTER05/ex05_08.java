import java.util.ArrayList;

public class ex05_08 {
    public static void main(String[] args) {
        int[][] graph={
            {},
            {2,3,8},
            {1,7},
            {1,4,5},
            {3,5},
            {3,4},
            {7},
            {2,6,8},
            {1,7}
        };

        boolean[] visited=new boolean[9];

        dfs(graph, 1, visited);

        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        visited=new boolean[9];

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

    static void dfs(ArrayList<ArrayList<Integer>> adj, int x, boolean[] visited){
        visited[x]=true;
        System.out.print(x+" ");

        for(int i=0;i<adj.get(x).size();i++){
            int y=adj.get(x).get(i);
            if(!visited[y])
                dfs(adj, y, visited);
        }
    }

    static void dfs(int[][] graph, int v, boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");

        for(int i=0;i<graph[i].length;i++){
            if(!visited[i]){
                dfs(graph, i, visited);
            }
        }
    }
}
