import java.util.Arrays;

public class StackDemo1 {
    int array[];
    int size;

    public StackDemo1(int n){
        array=new int[n];
        size=0;
    }


    public void push(int element){
        if(size==array.length){
            Arrays.copyOf(array,size*2);
        }
        array[size++]=element;
    }
    public void pop(){
        if(size>0);
        size--;
    }
    public int peek(){
        return array[size-1];
    }
    public int size(){
        return  size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        StackDemo1 stackDemo1 =new StackDemo1(10);
        stackDemo1.push(6);
        stackDemo1.push(5);
        stackDemo1.push(4);
        stackDemo1.push(3);
        stackDemo1.push(2);
        System.out.println(stackDemo1.size());
        System.out.println(stackDemo1.peek());
        stackDemo1.pop();
        System.out.println(stackDemo1.peek());


    }
}
