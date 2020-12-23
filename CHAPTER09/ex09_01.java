import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex09_01 {

    static final int INF = (int) 1e9;
    static ArrayList<ArrayList<Node>> graph;
    static int n, m, start;
    static boolean[] visited;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        n=Integer.parseInt(token.nextToken());
        m=Integer.parseInt(token.nextToken());
        token=new StringTokenizer(br.readLine());
        start=Integer.parseInt(token.nextToken());

        graph = new ArrayList<ArrayList<Node>>();
        for(int i=0;i<n+1;i++)
            graph.add(new ArrayList<Node>());

        visited=new boolean[n+1];
        d=new int[n+1];
        Arrays.fill(d, INF);
        
        for(int i=0;i<m;i++){
            token=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(token.nextToken());
            int b=Integer.parseInt(token.nextToken());
            int c=Integer.parseInt(token.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        dijkstra(start);

        for(int i=1;i<n+1;i++){
            if(d[i]==INF){
                System.out.println("INFINITY");
            }
            else{
                System.out.println(d[i]);
            }
        }    
    }

    static void dijkstra(int start){
        d[start]=0;
        visited[start]=true;
        for(int j=0;j<graph.get(start).size();j++){
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        for(int i=0;i<n-1;i++){
            int now=get_smallest_node();
            visited[now]=true;
            for(int j=0;j<graph.get(now).size();j++){
                int cost=d[now]+graph.get(now).get(j).getDistance();
                if(cost<d[graph.get(now).get(j).getIndex()]){
                    d[graph.get(now).get(j).getIndex()]=cost;
                }
            }
        }
    }

    static int get_smallest_node(){
        int min_value=INF;
        int index=0;

        for(int i=1;i<n+1;i++){
            if(d[i]<min_value && !visited[i]){
                min_value=d[i];
                index=i;
            }
        }

        return index;
    }    

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }
}

// 6 11
// 1
// 1 2 2
// 1 3 5
// 1 4 1
// 2 3 3
// 2 4 2
// 3 2 3 
// 3 6 5
// 4 3 3
// 4 5 1
// 5 3 1
// 5 6 2

// 0
// 2
// 3
// 1
// 2
// 4