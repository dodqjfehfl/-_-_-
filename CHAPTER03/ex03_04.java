import java.io.*;
import java.util.StringTokenizer;

public class ex03_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(token.nextToken());
        int m=Integer.parseInt(token.nextToken());

        int answer=0;

        for(int i=0;i<n;i++){
            int[] data=new int[m];
            token=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                data[j]=Integer.parseInt(token.nextToken());
            }
            
            int min_value=10001;
            for(int num:data)
                min_value=Integer.min(min_value, num);
            answer=Integer.max(answer, min_value);
        }

        System.out.println("answer : "+answer);
    }
}

//3 3
//3 1 2
//4 1 4
//2 2 2

//2 4
//7 3 1 8
//3 3 3 4