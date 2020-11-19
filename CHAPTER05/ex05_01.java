import java.util.Stack;

public class ex05_01 {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<Integer>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        for(int i=0;i<stack.size();i++)
            System.out.println(stack.get(i));
        for(int i=stack.size()-1;i>=0;i--)
            System.out.println(stack.get(i));
    }
}
