import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex08_05 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int x=Integer.parseInt(br.readLine());

        int[] d=new int[30001];

        for(int i=2;i<=x;i++){
            d[i]=d[i-1]+1;

            if(i%2==0)
                d[i]=Math.min(d[i], d[i/2]+1);
            if(i%3==0)
                d[i]=Math.min(d[i], d[i/3]+1);
            if(i%5==0)
                d[i]=Math.min(d[i], d[i/5]+1);
        }

        System.out.println(d[x]);
    }
}
// 26
// 3