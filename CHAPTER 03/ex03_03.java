import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex03_03 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(token.nextToken());
        int m=Integer.parseInt(token.nextToken());

        int answer=0;

        for(int i=0;i<n;i++){
            token=new StringTokenizer(br.readLine());
            int[] data=new int[m];
            for(int j=0;j<m;j++){
                data[j]=Integer.parseInt(token.nextToken());
            }
            Arrays.sort(data);
            int min_value=data[0];
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