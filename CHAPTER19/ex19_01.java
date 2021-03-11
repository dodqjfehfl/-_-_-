package CHAPTER19;

import java.io.*;
import java.util.*;

public class ex19_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][N];
        Point shark = null;
        PriorityQueue<Point> fish = new PriorityQueue<>();

        int answer = 0;

        for (int i = 0; i < N; i++) { // 물고기 입력
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());

                if (map[i][j] == 9) { // 아기 상어 저장
                    shark = new Point(i, j, 2);
                } else if (map[i][j] != 0) { // 물고기
                    fish.add(new Point(i, j, map[i][j]));
                }
            }
        }

        // 탐색
        while (fish.isEmpty() || fish.peek().size > shark.size) {
            // 기저조건 fish 가 empty, fish.peek.size>=shark

            // shark 사이즈보다 작은 물고기 찾기
        }

        // for (int[] rows : map) {
        // System.out.println(Arrays.toString(rows));
        // }

        // System.out.println("shark : " + shark.toString());

        // while (!fish.isEmpty()) {
        // System.out.println(fish.poll().toString());
        // }

        System.out.println(answer);
    }

    static class Point implements Comparable<Point> {
        int r, c;
        int size;

        public Point(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }

        @Override
        public int compareTo(Point o) {
            if (this.size == o.size) {
                if (this.r == this.c) {
                    return this.c - o.c;
                }
                return this.r - o.r;
            }
            return this.size - o.size;
        }

        @Override
        public String toString() {
            return "Point [c=" + c + ", r=" + r + ", size=" + size + "]";
        }
    }
}
