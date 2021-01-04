import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex10_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        int[] parent = new int[v + 1];
        ArrayList<Edge> edges = new ArrayList<Edge>();
        int result = 0;

        for (int i = 0; i < v + 1; i++)
            parent[i] = i;

        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            edges.add(new Edge(cost, a, b));
        }

        Collections.sort(edges);
        int last = 0;

        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            if (find_parent(parent, a) != find_parent(parent, b)) {
                union_parent(parent, a, b);
                last = cost;
                result += last;
            }
        }

        System.out.println(result - last);
    }

    static int find_parent(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find_parent(parent, parent[x]);
    }

    static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if (a < b)
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
        public int compareTo(ex10_08.Edge o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }
}

// 7 12
// 1 2 3
// 1 3 2
// 3 2 1
// 2 5 2
// 3 4 4
// 7 3 6
// 5 1 5
// 1 6 2
// 6 4 1
// 6 5 3
// 4 5 3
// 6 7 4

// 8