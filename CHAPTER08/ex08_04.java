public class ex08_04 {
    public static void main(String[] args) {
        long[] d=new long[100];

        d[1]=1;
        d[2]=1;

        int n=50;

        for(int i=3;i<n+1;i++){
            d[i]=d[i-1]+d[i-2];
        }

        System.out.println(d[n]);
    }
}