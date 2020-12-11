import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex08_08 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(token.nextToken());
        int m=Integer.parseInt(token.nextToken());

        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=Integer.parseInt(br.readLine());
        }

        int[] d=new int[m+1];
        Arrays.fill(d, 10001);

        d[0]=0;

        for(int i=0;i<n;i++){
            for(int j=array[i];j<=m;j++){
                if(d[j-array[i]]!=10001)
                    d[j]=Math.min(d[j], d[j-array[i]]+1);
            }
        }

        if(d[m]==10001)
            System.out.println(-1);
        else
            System.out.println(d[m]);
    }
}

// 2 15
// 2
// 3
// 5

// 3 4
// 3
// 5
// 7
// -1