package CHAPTER16;

import java.io.*;
import java.util.*;

public class ex16_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());

        int[] T = new int[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(token.nextToken());
            P[i] = Integer.parseInt(token.nextToken());
        }

        int answer = 0;
    }
}
