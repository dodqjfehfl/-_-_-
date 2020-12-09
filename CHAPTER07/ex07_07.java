import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ex07_07 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        StringTokenizer token=new StringTokenizer(br.readLine());
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(Integer.parseInt(token.nextToken()));

        int m=Integer.parseInt(br.readLine());
        int[] targets=new int[m];
        token=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            targets[i]=Integer.parseInt(token.nextToken());
        }

        for(int i=0;i<m;i++){
            if(set.contains(targets[i]))
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