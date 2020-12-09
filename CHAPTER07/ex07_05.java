import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex07_05 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int[] array=new int[n];
        StringTokenizer token=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            array[i]=Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);

        int m=Integer.parseInt(br.readLine());
        int[] targets=new int[m];
        token=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            targets[i]=Integer.parseInt(token.nextToken());
        }

        for(int i=0;i<m;i++){
            int result=binary_search(array, targets[i], 0, n-1);
            if(result!=-1)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }

    static int binary_search(int[] array, int target, int start, int end){
        while (start<=end){
            int mid=(start+end)/2;
            if(array[mid]==target)
                return mid;
            else if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}

// 5
// 8 3 7 9 2
// 3
// 5 7 9