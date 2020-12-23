import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex09_05 {

    static final int INF = (int) 1e9;
    static int n, m, start;
    static ArrayList<ArrayList<Node>> graph;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(token.nextToken());
        m=Integer.parseInt(token.nextToken());
        start=Integer.parseInt(token.nextToken());

        graph=new ArrayList<>();
        for(int i=0;i<n+1;i++)
            graph.add(new ArrayList<Node>());

        d=new int[n+1];
        Arrays.fill(d, INF);
        
        for(int i=0;i<m;i++){
            token=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(token.nextToken());
            int y=Integer.parseInt(token.nextToken());
            int z=Integer.parseInt(token.nextToken());

            graph.get(x).add(new Node(y, z));
        }

        dijkstra(start);

        int count=0;
        int max_distance=0;
        for(int i : d){
            if(i!=INF){
                count++;
                max_distance=Integer.max(max_distance, i);
            }
        }

        System.out.println(count-1+" "+max_distance);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start]=0;

        while (!pq.isEmpty()) {
            Node node=pq.poll();
            int dist=node.distance;
            int now=node.index;

            if(d[now]<dist)
                continue;
            
            for(int i=0;i<graph.get(now).size();i++){
                int cost=d[now]+graph.get(now).get(i).getDistance();
                if(cost<d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()]=cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
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
        public int compareTo(ex09_05.Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }
}

// 3 2 1
// 1 2 4
// 1 3 2

// 2 4