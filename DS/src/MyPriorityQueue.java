import java.util.Arrays;

public class MyPriorityQueue {
    private int arr[]=new int[10];
    private  int size;
    //入队
    public void offer(int value){
        if(size==arr.length){
            arr= Arrays.copyOf(arr,arr.length*2);
        }
        arr[size++]=value;
       heapDemo.shifUpSmall(arr,size,size-1);
    }
    //出队
    public int poll(){
        if(size>0){
            int peek=arr[0];
            heapDemo.swap(arr,0,size-1);
            size--;
            heapDemo.shifDownSmall(arr,size,0);
            return peek;
        }
        return -1;
    }
    //队首
    public int peek(){
        return arr[0];
    }
    public boolean isEmpty(){
        return size==0;
    }
}
