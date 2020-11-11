import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ex04_01{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(token.nextToken());
        
        int x=1;
        int y=1;

        token=new StringTokenizer(br.readLine());
        String[] plans=new String[token.countTokens()];
        for(int i=0;i<plans.length;i++)
            plans[i]=token.nextToken();

        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        String[] move_type={"L","R","U","D"};

        for(String plan:plans){
            for(int d=0;d<4;d++){
                if(plan==move_type[i]){
                    x+=dx[d];
                    y+=dy[d];

                    if(x<1)
                        x=1;
                    if(x>N)
                        x=N;
                    if(y<1)
                        y=1;
                    if(y>N)
                        y=N;
                }
            }
        }

        System.out.println(x+" "+y);
    }
}

//5
//R R R U D D