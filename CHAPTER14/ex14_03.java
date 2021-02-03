import java.util.Arrays;

public class ex14_03 {
    public static void main(String[] args) {
        int[] stages1 = { 2, 1, 2, 6, 2, 4, 3, 3 };
        System.out.println(Arrays.toString(solution(5, stages1)));
        // [3,4,2,1,5]
        int[] stages2 = { 4, 4, 4, 4, 4 };
        System.out.println(Arrays.toString(solution(4, stages2)));
        // [4,1,2,3]
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] rate = new double[N]; // 실패율
        // System.out.println(Arrays.toString(stages));

        for (int i = 0; i < N; i++) {
            int now_stage = i + 1; // 현재 스테이지
            int stage_passed = 0; // 현재 스테이지를 플레이한 플레이어
            int stay_player = 0; // 현재 스테이지에 머물러 있는 플레이어

            for (int j = 0; j < stages.length; j++) {
                // System.out.println(stages[j]);
                if (stages[j] >= now_stage) {
                    if (stages[j] == now_stage) {
                        stay_player++;
                    }
                    stage_passed++;
                }
            }
            // System.out.println("stage = " + i + " pass : " + stage_passed + " stay : " +
            // stay_player);

            if (stage_passed == 0) {
                rate[i] = 0.0;
            } else {
                rate[i] = (double) stay_player / (double) stage_passed;
            }
        }
        // System.out.println(Arrays.toString(rate));

        boolean[] visited = new boolean[N];// 스테이지 확인을 위한 배열

        for (int i = 0; i < N; i++) {
            // 가장 큰 값과 인덱스를 찾고
            double max = -1;
            int max_idx = -1;
            for (int j = 0; j < N; j++) {
                if (!visited[j]) {
                    if (rate[j] > max) {
                        max = rate[j];
                        max_idx = j;
                    }
                }
            }
            // 정답에 넣고 방문 체크
            answer[i] = max_idx + 1;
            visited[max_idx] = true;
        }

        return answer;
    }
}
