import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex03_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(token.nextToken());
        int k=Integer.parseInt(token.nextToken());

        int answer=0;

        while(true){
            int target=(n/k)*k;
            answer+=(n-target);
            n=target;
            
            if(n<k)
                break;

            answer++;
            n/=k;
        }

        answer+=(n-1);
        
        System.out.println("answer : "+answer);
    }
}
