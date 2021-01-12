import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex11_03 {

    static String str;
    static int count0 = 0; // 전부 0으로 바꾸는 경우
    static int count1 = 0; // 전부 1로 바꾸는 경우

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        if (str.charAt(0) == '1') {
            count0++;
        } else {
            count1++;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                // 다음 수에서 숫자가 변경
                if (str.charAt(i + 1) == '1') {
                    count0++;
                } else {
                    count1++;
                }
            }
        }

        System.out.println(Math.min(count0, count1));

        // answer를 정수 최댓값으로 변환
        // answer = Integer.MAX_VALUE;

        // // 변환시키기 위한 배열
        // boolean[] check = new boolean[str.length()];
        // for (int i = 0; i < check.length; i++) {
        // if (str.charAt(i) == '1') {
        // check[i] = true;
        // }
        // }

        // greedy(check, 0);

        // System.out.println(answer);
    }

    static void greedy(boolean[] check, int cnt) {
        if (allSame(check)) {
            // 모두가 같으면 answer를 변경
            answer = Integer.min(answer, cnt);
            return;
        }

        // 가지치기
        if (cnt > answer)
            return;

        // 위치를 잡아서 변경해서 탐색
        for (int i = 0; i < check.length - 1; i++) {
            for (int j = i + 1; j < check.length; j++) {
                greedy(reverse(check, i, j), cnt + 1);
            }
        }
    }

    // 숫자를 변경
    static boolean[] reverse(boolean[] check, int i, int j) {
        for (; i < j; i++) {
            check[i] = !check[i];
        }

        return check;
    }

    // 모두가 같은지 확인
    static boolean allSame(boolean[] check) {
        for (int i = 1; i < check.length; i++) {
            if (check[i] != check[0]) {
                return false;
            }
        }

        return true;
    }
}

// 0001100

// 1