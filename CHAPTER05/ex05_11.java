import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex05_11 {
    static int n;
    static int m;
    static int[][] graph;

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        n=Integer.parseInt(token.nextToken());
        m=Integer.parseInt(token.nextToken());

        graph=new int[n][m];
        for(int i=0;i<n;i++){
            String str=br.readLine();
            for(int j=0;j<m;j++){
                graph[i][j]=str.charAt(j)-'0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y){
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(x,y));
        
        while (!queue.isEmpty()) {
            Node newNode=queue.poll();

            for(int d=0;d<4;d++){
                int nx=newNode.x+dx[d];
                int ny=newNode.y+dy[d];
                if(0>nx || nx>=n || 0>ny || ny>=m)
                    continue;

                if(graph[nx][ny]==0)
                    continue;

                if(graph[nx][ny]==1){
                    graph[nx][ny]=graph[x][y]+1;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        return graph[n-1][m-1];
    }

    static class Node{
        int x,y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
    }
}

// 5 6
// 101010
// 111111
// 000001
// 111111
// 111111