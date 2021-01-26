import java.io.*;
import java.util.*;

public class ex13_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][N];
        PriorityQueue<virus> pq = new PriorityQueue<>();
        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new virus(0, map[i][j], i, j));
                }
            }
        }

        token = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken()) - 1;
        int Y = Integer.parseInt(token.nextToken()) - 1;

        while (!pq.isEmpty()) {
            virus front = pq.poll();

            if (front.time >= S)
                continue;

            for (int d = 0; d < 4; d++) {
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if (0 > nr || nr >= N || 0 > nc || nc >= N)
                    continue;

                if (map[nr][nc] == 0) {
                    map[nr][nc] = front.number;
                    pq.add(new virus(front.time + 1, front.number, nr, nc));
                }
            }
        }

        System.out.println(map[X][Y]);
    }

    static class virus implements Comparable<virus> {
        int time;
        int number;
        int r, c;

        @Override
        public int compareTo(ex13_03.virus o) {
            if (this.time == o.time) {
                return this.number - o.number;
            }
            return this.time - o.time;
        }

        public virus(int time, int number, int r, int c) {
            this.time = time;
            this.number = number;
            this.r = r;
            this.c = c;
        }
    }
}

// 3 3
// 1 0 2
// 0 0 0
// 3 0 0
// 2 3 2

// 3

// 3 3
// 1 0 2
// 0 0 0
// 3 0 0
// 1 2 2

// 0