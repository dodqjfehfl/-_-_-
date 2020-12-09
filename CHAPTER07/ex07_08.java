import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex07_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(token.nextToken());
        int m=Integer.parseInt(token.nextToken());

        int[] array=new int[n];
        token=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            array[i]=Integer.parseInt(token.nextToken());
        }

        int start=0;
        int end=(int)1e9;

        int result=0;
        while (start<=end) {
            long total=0;
            int mid=(start+end)/2;
            for(int i:array){
                if(i>mid){
                    total+=i-mid;
                }
            }

            if(total<m){
                end=mid-1;
            }else{
                result=mid;
                start=mid+1;
            }
        }

        System.out.println(result);
    }
}

// 4 6
// 19 15 10 17