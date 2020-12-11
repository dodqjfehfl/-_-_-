import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex08_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        int[] array=new int[n];

        StringTokenizer token=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(token.nextToken());

        int[] d=new int[100];

        d[0]=array[0];
        d[1]=Integer.max(array[0], array[1]);

        for(int i=2;i<n;i++)
            d[i]=Integer.max(d[i-1], d[i-2]+array[i]);

        System.out.println(d[n-1]);
    }
}

// 4
// 1 3 1 5
// 8