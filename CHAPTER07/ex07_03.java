import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex07_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(token.nextToken());
        int target=Integer.parseInt(token.nextToken());

        token=new StringTokenizer(br.readLine());
        int[] array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(token.nextToken());

        int result=binary_search(array, target, 0, n-1);

        if(result==-1)
            System.out.println("원소가 존재하지 않습니다.");
        else
            System.out.println(result+1);
    }

    public static int binary_search(int[] array, int target, int start, int end){
        while (start<=end) {
            int mid=(start+end)/2;
            if(array[mid]==target)
                return mid;
            else if(array[mid]>target)
                return binary_search(array, target, start, mid-1);
            else
                return binary_search(array, target, mid+1, end);    
        }
        return -1;
    }
}