import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex10_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        int[] parent = new int[v + 1];
        ArrayList<Edge> edges = new ArrayList<Edge>();
        int result = 0;

        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            edges.add(new Edge(cost, a, b));
        }

        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            if (find_parent(parent, a) != find_parent(parent, b)) {
                union_parent(parent, a, b);
                result += cost;
            }
        }

        System.out.println(result);
    }

    static int find_parent(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find_parent(parent, parent[x]);
        return parent[x];
    }

    static void union_parent(int[] parent, int a, int b) {
        int pa = find_parent(parent, a);
        int pb = find_parent(parent, b);

        if (pa < pb)
            parent[b] = a;
        else
            parent[a] = b;
    }

    static class Edge implements Comparable<Edge> {
        int distance;
        int nodeA;
        int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getDistance() {
            return distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        @Override
        public int compareTo(ex10_05.Edge o) {
            return this.distance - o.distance;
        }
    }
}

// 7 9
// 1 2 29
// 1 5 75
// 2 3 35
// 2 6 34
// 3 4 7
// 4 6 23
// 4 7 13
// 5 6 53
// 6 7 25

// 159