import java.io.*;
import java.util.*;

public class ex09_04 {

    static final int INF=(int)1e9;
    static int n,m,x,k;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(token.nextToken());
        m=Integer.parseInt(token.nextToken());
        
        graph=new int[n+1][n+1];
        for(int i=0;i<n+1;i++)
            Arrays.fill(graph[i], INF);

        for(int i=0;i<n+1;i++)
            graph[i][i]=0;

        for(int i=0;i<m;i++){
            token=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(token.nextToken());
            int b=Integer.parseInt(token.nextToken());

            graph[a][b]=1;
            graph[b][a]=1;
        }

        token=new StringTokenizer(br.readLine());
        x=Integer.parseInt(token.nextToken());
        k=Integer.parseInt(token.nextToken());

        for(int k=1;k<n+1;k++){
            for(int a=1;a<n+1;a++){
                for(int b=1;b<n+1;b++){
                    graph[a][b]=Math.min(graph[a][b], graph[a][k]+graph[k][b]);
                }
            }
        }

        int distance=graph[1][k]+graph[k][x];

        if(distance>=INF){
            System.out.println(-1);
        }else{
            System.out.println(distance);
        }
    }
}

// 5 7
// 1 2
// 1 3
// 1 4
// 2 4
// 3 4
// 3 5
// 4 5
// 4 5

// 3

// 4 2
// 1 3
// 2 4
// 3 4

// -1