import java.util.ArrayList;

public class QueueDemo2 {
  int array[];
    int size;
    int front;
    int rear;
    public QueueDemo2(int n){
        size=0;
        array=new int[n];
        front=0;
        rear=0;
    }
    public void push(int x){
        if((rear+1)%array.length==front)
            return  ;
        if(rear==front){
            array[front]=x;
            rear++;
        }
        else {
            array[rear++]=x;
            if(rear>array.length){
                rear=rear-array.length;
            }
        }
        size++;

    }
    public void pop(){
        if(rear==0&&front==0){
            return  ;
        }
        front++;
        if(front>array.length){
            front=front-array.length;
        }
        size --;

    }
    public int peek(){
        return array[front];
    }
    public static void main(String[] args) {
        QueueDemo2 m=new QueueDemo2(8);
        m.push(1);
        m.push(2);
        m.push(3);
        m.push(4);
        m.pop();
        m.pop();



    }
}
