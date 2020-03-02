//栈实现队列
import java.util.LinkedList;
import java.util.Stack;

public class QueueDemo {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public QueueDemo(){
        st1=new Stack<>();
        st2=new Stack<>();
    }
    void push(int x){
        st1.push(x);
    }
    int pop(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        }
        return st2.pop();
    }
    int peek(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
    boolean empty(){
       return  st1.isEmpty()&&st2.isEmpty();
    }

    public static void main(String[] args) {
        QueueDemo m=new QueueDemo();
        m.push(1);
        m.push(2);
        m.push(3);

        System.out.println(m.peek());
        System.out.println(m.pop());
        System.out.println(m.empty());
    }
}
