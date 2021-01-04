import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex10_06 {

    static int v, e;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        v = Integer.parseInt(token.nextToken());
        e = Integer.parseInt(token.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();
        indegree = new int[v + 1];

        for (int i = 0; i < v + 1; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        topology_sort();
    }

    static void topology_sort() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i < v + 1; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;
                if (indegree[graph.get(now).get(i)] == 0) {
                    queue.add(graph.get(now).get(i));
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

}

// 7 8
// 1 2
// 1 5
// 2 3
// 2 6
// 3 4
// 4 7
// 5 6
// 6 4

// 1 2 5 3 6 4 7