import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex10_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());
        int[] parent = new int[v + 1];

        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            union_parent(parent, a, b);
        }

        System.out.print("각 원소가 속한 집합 : ");
        for (int i = 1; i < v + 1; i++) {
            System.out.print(find_parent(parent, i) + " ");
        }

        System.out.println();

        System.out.print("부모 테이블 : ");
        for (int i = 1; i < v + 1; i++) {
            System.out.print(parent[i] + " ");
        }
    }

    public static int find_parent(int[] parent, int x) {
        if (parent[x] != x)
            return find_parent(parent, parent[x]);
        return x;
    }

    public static void union_parent(int[] parent, int a, int b) {
        int pa = find_parent(parent, a);
        int pb = find_parent(parent, b);

        if (pa < pb)
            parent[b] = a;
        else
            parent[a] = b;
    }
}

// 6 4
// 1 4
// 2 3
// 2 4
// 5 6

// 각 원소가 속한 집합 : 1 1 1 1 5 5
// 부모 테이블 : 1 1 2 1 5 5