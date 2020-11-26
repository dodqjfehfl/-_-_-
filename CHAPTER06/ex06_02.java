public class ex06_02 {
    public static void main(String[] args) {
        int[] array={3,5};

        int temp=array[0];
        array[0]=array[1];
        array[1]=temp;

        System.out.println(array[0]+" "+array[1]);
    }
}