import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex11_02 {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 입력
        String str = br.readLine();

        // answer를 작은 값으로 초기화
        answer = Integer.MIN_VALUE;

        // 그리디 탐색
        greedy(str, 0, 0);

        System.out.println(answer);
    }

    static void greedy(String str, int idx, int number) {
        if (str.length() == idx) {
            // 기저 조건시 max 값으로 변경
            answer = Integer.max(answer, number);
            return;
        }

        // 현재 위치의 값을 더하거나 빼거나
        greedy(str, idx + 1, number + (str.charAt(idx) - '0'));
        greedy(str, idx + 1, number * (str.charAt(idx) - '0'));
    }
}