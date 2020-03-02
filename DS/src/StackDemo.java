//队列实现栈
import java.util.LinkedList;
import java.util.Queue;

public class StackDemo {
    Queue<Integer> a;
    StackDemo(){
       a=new LinkedList<>();
       }

    public void stackpush(int s)
    {
        a.offer(s);
    }

    public int stackpop(){
        for(int i=0;i<a.size()-1;i++){


                a.offer(a.poll());

        }
         return a.poll();
    }
    public int stacktop(){
        for(int i=0;i<a.size()-1;i++){

            a.offer(a.poll());
        }
        return  a.peek();
    }
    public boolean stackempty(){
        return  a.isEmpty();
    }


    public static void main(String[] args) {
        StackDemo m=new StackDemo();
        m.stackpush(1);
        m.stackpush(2);
        m.stackpush(3);
        m.stackpush(4);
        m.stackpush(5);
        m.stackpush(6);
        System.out.println(m.stackpop());
        System.out.println(m.stacktop());




    }
}
