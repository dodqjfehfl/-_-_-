import java.io.*;
import java.util.*;

public class ex09_02 {
    
    static final int INF = (int) 1e9;
    static ArrayList<ArrayList<Node>> graph;
    static int n, m, start;
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
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node node=pq.poll();
            int dist=node.distance;
            int now=node.index;

            if(d[now]<dist)
                continue;

            for(int i=0;i<graph.get(now).size();i++){
                int cost=d[now]+graph.get(now).get(i).getDistance();
                if(cost<d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()]=cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    } 

    static class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(ex09_02.Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
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