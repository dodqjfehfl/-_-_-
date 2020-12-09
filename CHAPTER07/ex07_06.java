import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex07_06 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] array=new int[1000001];

        StringTokenizer token=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            array[Integer.parseInt(token.nextToken())]++;
        }

        int m=Integer.parseInt(br.readLine());
        token=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            if(array[Integer.parseInt(token.nextToken())]==1)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
}

// 5 
// 8 3 7 9 2
// 3
// 5 7 9