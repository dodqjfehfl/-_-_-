class ex08_01{
    public static void main(String[] args) {
        System.out.println(fibo(4));
    }

    static int fibo(int x){
        if(x==1 || x==2)
            return 1;
        return fibo(x-1)+fibo(x-2);
    }
}