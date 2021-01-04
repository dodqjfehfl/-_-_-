import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex10_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] parent = new int[n + 1];

        for (int i = 1; i < n + 1; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());

            int oper = Integer.parseInt(token.nextToken());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            if (oper == 0) {
                union_parent(parent, a, b);
            } else if (oper == 1) {
                if (find_parent(parent, a) == find_parent(parent, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    static int find_parent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent, parent[x]);
        }
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

// 7 8
// 0 1 3
// 1 1 7
// 0 7 6
// 1 7 1
// 0 3 7
// 0 4 2
// 0 1 1
// 1 1 1

// NO
// NO
// YES