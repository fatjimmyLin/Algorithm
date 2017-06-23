import java.util.Stack;
/**
 * Created by fatjimmy on 17/6/11.
 */
// leetcode 155 offer 21
public class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int a = stack.pop();
        int b = minStack.pop();
        if(a != b){
            minStack.push(b);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        int param_3 = obj.getMin();
        System.out.println("Min is : "+param_3);
        obj.pop();
        int param_4 = obj.getMin();
        System.out.println("Min is : "+param_4);
        obj.pop();
        int param_5 = obj.getMin();
        System.out.println("Min is : "+param_5);
    }
}

