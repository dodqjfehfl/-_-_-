import java.io.*;
import java.util.PriorityQueue;

public class ex14_04 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (pq.size() != 1) {
            int num = pq.poll() + pq.poll();
            answer += num;
            pq.add(num);
        }

        System.out.println(answer);
    }
}
