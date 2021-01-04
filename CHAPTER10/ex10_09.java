import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex10_09 {

    static int v;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        v = Integer.parseInt(token.nextToken());
        indegree = new int[v + 1];
        graph = new ArrayList<ArrayList<Integer>>();
        times = new int[v + 1];

        for (int i = 0; i < v + 1; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 1; i < v + 1; i++) {
            token = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(token.nextToken());
            times[i] = x;

            while (true) {
                x = Integer.parseInt(token.nextToken());
                if (x == -1)
                    break;

                indegree[i] += 1;
                graph.get(x).add(i);
            }
        }

        topology_sort();
    }

    static void topology_sort() {
        int[] result = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            result[i] = times[i];
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i < v + 1; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)],
                        result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)]--;
                if (indegree[graph.get(now).get(i)] == 0)
                    queue.add(graph.get(now).get(i));
            }
        }

        for (int i = 1; i < v + 1; i++)
            System.out.println(result[i] + " ");
    }
}

// 5
// 10 -1
// 10 1 -1
// 4 1 -1
// 4 3 1 -1
// 3 3 -1

// 10
// 20
// 14
// 18
// 17