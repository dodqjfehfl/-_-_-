import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex06_12 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(token.nextToken());
        int K=Integer.parseInt(token.nextToken());

        Integer[] a=new Integer[N];
        token=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            a[i]=Integer.parseInt(token.nextToken());
        }
        
        Integer[] b=new Integer[N];
        token=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            b[i]=Integer.parseInt(token.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for(int i=0;i<K;i++){
            if(a[i]<b[i]){
                int temp=a[i];
                a[i]=b[i];
                b[i]=temp;
            }else{
                break;
            }
        }

        int sum=0;
        for(int i=0;i<N;i++){
            sum+=a[i];
        }

        System.out.println(sum);
    }
}

// 5 3
// 1 2 5 4 3
// 5 5 6 6 5