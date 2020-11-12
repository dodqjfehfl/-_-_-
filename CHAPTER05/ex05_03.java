public class ex05_03 {
    public static void main(String[] args) {     
        recursive_function();
    }

    static void recursive_function(){
        System.out.println("재귀 함수를 호출합니다.");
        recursive_function();
    }
}
