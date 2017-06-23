import java.util.Stack;
/**
 * Created by fatjimmy on 17/5/29.
 */
//leetcode 232 offer 7
public class ImplentingQueueUsingStack {

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();
    public ImplentingQueueUsingStack() {
    }
    public void push(int x) {
        stack1.push(x);
    }
    public int pop() {
        peek();
        return (int) stack2.pop();
    }
    public int peek() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return (int) stack2.peek();
    }
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
    public static void main(String[] args) {
        ImplentingQueueUsingStack obj = new ImplentingQueueUsingStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        System.out.println("int param_2 "+param_2);
        int param_3 = obj.peek();
        System.out.println("int param_3 "+param_3);;
    }
}
