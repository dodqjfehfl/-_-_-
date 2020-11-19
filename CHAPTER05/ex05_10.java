import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex05_10 {
    static int n, m;
    static int[][] graph;

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

        int result=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(i, j))
                    result++;
            }
        }

        System.out.println(result);
    }
    static boolean dfs(int x, int y){
        if(x<=-1 || x>=n || y<=-1 || y>=m)
            return false;

        if(graph[x][y]==0){
            graph[x][y]=1;
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            return true;
        }
        return false;
    }
}

// 4 5
// 00110
// 00011
// 11111
// 00000