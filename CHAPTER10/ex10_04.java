import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex10_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        int[] parent = new int[v + 1];

        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        boolean cycle = false;

        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            if (find_parent(parent, a) == find_parent(parent, b)) {
                cycle = true;
                break;
            } else {
                union_parent(parent, a, b);
            }
        }

        if (cycle)
            System.out.println("사이클이 발생했습니다.");
        else
            System.out.println("사이클이 발생하지 않았습니다.");
    }

    static int find_parent(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find_parent(parent, parent[x]);
        return parent[x];
    }

    static void union_parent(int[] parent, int a, int b) {
        int pa = find_parent(parent, a);
        int pb = find_parent(parent, b);

        if (pa < pb)
            parent[b] = a;
        else
            parent[a] = b;
    }
}

// 3 3
// 1 2
// 1 3
// 2 3

// 사이클이 발생했습니다.