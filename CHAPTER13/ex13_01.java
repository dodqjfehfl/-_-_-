import java.io.*;
import java.util.*;

public class ex13_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            map[Integer.parseInt(token.nextToken()) - 1][Integer.parseInt(token.nextToken()) - 1] = 1;
        }

        int[] min = new int[N];
        Arrays.fill(min, 987654321);
        Queue<dist> queue = new LinkedList<dist>();
        queue.add(new dist(X - 1, 0));

        while (!queue.isEmpty()) {
            dist front = queue.poll();
            min[front.node] = Math.min(min[front.node], front.dist);

            for (int i = 0; i < N; i++) {
                if (map[front.node][i] != 0) {
                    queue.add(new dist(i, front.dist + 1));
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (min[i] == K) {
                pq.add(i);
            }
        }

        if (pq.size() == 0) {
            System.out.println(-1);
        } else {
            while (!pq.isEmpty()) {
                System.out.println((pq.poll() + 1) + " ");
            }
        }
    }

    static class dist {
        int node;
        int dist;

        public dist(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}

// 4 4 2 1
// 1 2
// 1 3
// 2 3
// 2 4

// 4

// 4 3 2 1
// 1 2
// 1 3
// 1 4

// -1

// 4 4 1 1
// 1 2
// 1 3
// 2 3
// 2 4

// 2
// 3