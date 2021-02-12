package CHAPTER16;

import java.io.*;
import java.util.*;

public class ex16_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(token.nextToken());

        for (int t = 1; t <= TC; t++) {
            token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());

            int[][] map = new int[N][M];

            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            for (int j = 1; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    int max = 0;
                    if (i == 0) {
                        max = Math.max(map[i][j - 1], map[i + 1][j - 1]);
                    } else if (i == N - 1) {
                        max = Math.max(map[i][j - 1], map[i - 1][j - 1]);
                    } else {
                        max = Math.max(Math.max(map[i][j - 1], map[i + 1][j - 1]), map[i - 1][j - 1]);
                    }

                    map[i][j] += max;
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                answer = Math.max(answer, map[i][M - 1]);
            }
            System.out.println(answer);
        }
    }
}

// 2
// 3 4
// 1 3 3 2 2 1 4 1 0 6 4 7
// 4 4
// 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2

// 19
// 16