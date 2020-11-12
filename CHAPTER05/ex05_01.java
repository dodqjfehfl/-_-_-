import java.util.Stack;

public class ex05_01 {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();

        stack.append(5);
        stack.append(2);
        stack.append(3);
        stack.append(7);
        stack.pop();
        stack.append(1);
        stack.append(4);
        stack.pop();

        for(int i=0;i<stack.size();i++)
            System.out.println(stack.get(i));
        for(int i=stack.size()-1;i>=0;i--)
            System.out.println(stack.get(i));
    }
}
