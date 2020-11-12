import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ex05_02 {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();

        queue.offer(5);
        queue.offer(2);
        queue.offer(3);
        queue.offer(7);
        queue.poll();
        queue.offer(1);
        queue.offer(4);
        queue.poll();

        System.out.println(Arrays.toString(queue.toArray()));
    }
}
