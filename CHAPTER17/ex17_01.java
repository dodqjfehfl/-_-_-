package CHAPTER17;

import java.io.*;
import java.util.*;

public class ex17_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(token.nextToken());

        int[][] answer = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(answer[i], 987654321);
        }

        for (int i = 1; i <= n; i++) {
            answer[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            answer[a][b] = Math.min(answer[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    answer[a][b] = Math.min(answer[a][b], answer[a][k] + answer[k][b]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (answer[i][j] >= 987654321)
                    System.out.print(0 + " ");
                else
                    System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}