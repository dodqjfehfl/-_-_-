import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex04_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(token.nextToken());
        int m=Integer.parseInt(token.nextToken());

        boolean[][] check=new boolean[n][m];
        
        token=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(token.nextToken());
        int y=Integer.parseInt(token.nextToken());
        int dir=Integer.parseInt(token.nextToken());
        check[x][y]=true;

        int[][] map=new int[n][m];
        for(int i=0;i<n;i++){
            token=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(token.nextToken());
            }
        }

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        int count=1;
        int turnTime=0;

        while (true) {
            turnLeft(dir);
            int nx=x+dx[dir];
            int ny=y+dy[dir];

            if(!check[nx][ny] && map[nx][ny]==0){
                check[nx][ny]=true;
                x=nx;
                y=ny;
                count++;
                turnTime=0;
                continue;
            }else{
                turnTime++;
            }

            if(turnTime==4){
                nx=x-dx[dir];
                ny=y-dy[dir];

                if(map[nx][ny]==0){
                    x=nx;
                    y=ny;
                }else{
                    break;
                }
                turnTime=0;
            }
        }

        System.out.println(count);
    }

    static int turnLeft(int dir) {
        dir--;
        if(dir==-1)
            dir=3;

		return dir;
    }
}

// 4 4
// 1 1 0
// 1 1 1 1
// 1 0 0 1
// 1 1 0 1
// 1 1 1 1