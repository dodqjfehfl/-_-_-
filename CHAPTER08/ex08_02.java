public class ex08_02 {

    static long[] d;

    public static void main(String[] args) {
        d=new long[100];
        System.out.println(fibo(50));
    }

    static long fibo(int x){
        if(x==1 || x==2)
            return 1;
        if(d[x]!=0)
            return d[x];
        d[x]=fibo(x-1)+fibo(x-2);
        return d[x];
    }
}