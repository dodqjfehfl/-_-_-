import java.io.*;
import java.util.StringTokenizer;

public class ex03_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(token.nextToken());
        int k=Integer.parseInt(token.nextToken());

        int answer=0;

        while(n>=k){
            while(n%k!=0){
                n-=1;
                answer++;
            }
            n/=k;
            answer++;
        }

        while(n>1){
            n--;
            answer++;
        }

        System.out.println("answer : "+answer);
    }
}

//25 5