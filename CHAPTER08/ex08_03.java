public class ex08_03 {

    static long[] d=new long[100];

    public static void main(String[] args) {
        System.out.println(fibo(6));
    }

    static long fibo(int x){
        System.out.print("f("+x+") ");

        if(x==1 || x==2)
            return 1;
        if(d[x]!=0)
            return d[x];
        d[x]=fibo(x-1)+fibo(x-2);
        return d[x];
    }
}