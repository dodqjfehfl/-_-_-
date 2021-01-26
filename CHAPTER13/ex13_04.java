import java.io.*;
import java.util.*;

public class ex13_04 {

    static int N;
    static int[] numbers;
    static int[] oper;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        numbers = new int[N];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(token.nextToken());
        }

        oper = new int[4];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(token.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        cal(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void cal(int idx, int num) {
        if (idx == N) {
            max = Integer.max(max, num);
            min = Integer.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                switch (i) {
                    case 0:
                        cal(idx + 1, num + numbers[idx]);
                        break;
                    case 1:
                        cal(idx + 1, num - numbers[idx]);
                        break;
                    case 2:
                        cal(idx + 1, num * numbers[idx]);
                        break;
                    case 3:
                        if (num > 0)
                            cal(idx + 1, num / numbers[idx]);
                        else
                            cal(idx + 1, ((num * -1) / numbers[idx]) * -1);
                        break;
                }
                oper[i]++;
            }
        }
    }
}

// 2
// 5 6
// 0 0 1 0
// 30
// 30

// 3
// 3 4 5
// 1 0 1 0

// 35
// 17

// 6
// 1 2 3 4 5 6
// 2 1 1 1

// 54
// -24