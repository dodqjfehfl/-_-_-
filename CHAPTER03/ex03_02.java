import java.util.Arrays;
import java.util.Scanner;

public class ex03_02 {
    public static void main(String[] args) {
        int n,m,k;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();

        int[] data=new int[n];
        for(int i=0;i<n;i++){
            data[i]=sc.nextInt();
        }

        Arrays.sort(data);

        int count=(int)(m/(k+1))*k;
        count+=m%(k+1);

        int answer=0;
        answer+=(count)*data[data.length-1];
        answer+=(m-count)*data[data.length-2];

        System.out.println("answer : "+answer);
        
        sc.close();
    }
}

//5 8 3
//2 4 5 4 6