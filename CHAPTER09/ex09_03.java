import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex09_03 {

    static final int INF=(int)1e9;
    
    static int n,m;
    static int[][] graph;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        graph=new int[n+1][n+1];
        for(int i=0;i<n+1;i++)
            Arrays.fill(graph[i], INF);

        for(int i=0;i<n+1;i++){
            graph[i][i]=0;
        }

        StringTokenizer token=null;
        for(int i=0;i<m;i++){
            token=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(token.nextToken());
            int b=Integer.parseInt(token.nextToken());
            int c=Integer.parseInt(token.nextToken());
            graph[a][b]=c;
        }

        for(int k=1;k<n+1;k++){
            for(int a=1;a<n+1;a++){
                for(int b=1;b<n+1;b++){
                    graph[a][b]=Math.min(graph[a][b], graph[a][k]+graph[k][b]);
                }
            }
        }

        for(int a=1;a<n+1;a++){
            for(int b=1;b<n+1;b++){
                if(graph[a][b]==INF){
                    System.out.print("INFINITY ");
                }else{
                    System.out.print(graph[a][b]+" ");
                }
            }
            System.out.println();
        }
    }
}

// 4
// 7
// 1 2 4
// 1 4 6
// 2 1 3
// 2 3 7
// 3 1 5
// 3 4 4
// 4 3 2

// 0 4 8 6
// 3 0 7 9
// 5 9 0 4
// 7 11 2 0