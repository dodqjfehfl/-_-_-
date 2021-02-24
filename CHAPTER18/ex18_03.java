package CHAPTER18;

import java.io.*;
import java.util.*;

public class ex18_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        boolean[] visited = new boolean[N];
        PriorityQueue<road> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(token.nextToken());
            int Y = Integer.parseInt(token.nextToken());
            int Z = Integer.parseInt(token.nextToken());

            pq.add(new road(X, Y, Z));
        }

        while (!pq.isEmpty()) {
            road r = pq.poll();
            // 도로 연결
        }

        System.out.println(pq.toString());
    }

    static class road implements Comparable<road> {
        int from, to, cost;

        public road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(road o) {
            if (o.cost == this.cost)
                return this.from - o.from;
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "road [cost=" + cost + ", from=" + from + ", to=" + to + "]";
        }
    }
}

// 7 11
// 0 1 7
// 0 3 5
// 1 2 8
// 1 3 9
// 1 4 7
// 2 4 5
// 3 4 15
// 3 5 6
// 4 5 8
// 4 6 9
// 5 6 11