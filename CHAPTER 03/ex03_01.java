public class ex03_01{
    public static void main(String[] args) {
        int n=1260;

        int count=0;
        int[] coins={500,100,50,10};
        
        // for(int i=0;i<coins.length;i++){
        //     count+=n/coins[i];
        //     n%=coins[i];
        // }

        for(int coin: coins){
            count+=n/coin;
            n%=coin;
        }

        System.out.println("count : "+count);
    }
}