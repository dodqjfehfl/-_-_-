public class ex05_05 {
    public static void main(String[] args) {
        System.out.println("반복적으로 구현 : "+factorial_iterative(5));
        System.out.println("재귀적으로 구현 : "+factorial_recursive(5));
    }

    static int factorial_iterative(n){
        int result=1;
        for(int i=1;i<=n;i++){
            result*=i;
        }
        return result;
    }

    static int factorial_recursive(n){
        if(n<=1)
            return 1;
        return n*factorial_recursive(n-1);
    }
}