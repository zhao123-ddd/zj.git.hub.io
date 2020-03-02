import java.util.Stack;

public class Stackmin {
    Stack<Integer> a;
    Stack<Integer> b;

    public Stackmin(){
        a=new Stack<>();
        b=new Stack<>();
    }
    void push(int x){
        a.push(x);
        if(b.isEmpty()){
            b.push(x);
        }else if(x<=b.peek()){
            b.push(x);
        }
    }
    void pop(){
        if(!b.isEmpty()){
        if(a.peek().equals(b.peek()) ){
            b.pop();
        }
        }
          a.pop();
    }
    int getMin(){
        return b.peek();
    }
}
