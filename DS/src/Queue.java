 class Node{
    int value;
    Node next;
     Node(){
         value=0;
         next=null;
     }
     Node(int value){
         this.value=value;
         next=null;
     }
}
public class Queue {
Node head;
Node last;
int size;
public  Queue(){
    head=last=null;
    size=0;
}
public  void offer(int x){
    Node newnode=new Node(x);
if(head==null){
    head=last=newnode;
}
else
    last.next=newnode;
    last=newnode;
    ++size;
}
public void poll(){
if(head==null){
    return ;
}
head=head.next;
if(head==null){
    head=last=null;
}
size--;
}
public int peek(){
  if(head==null)
      return -1;
  return head.value;
}
public int size(){
        return  size;
}
public boolean isEmpty(){
    return size==0;
}

    public static void main(String[] args) {
        Queue queue=new Queue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        queue.offer(5);
        queue.offer(6);
        queue.offer(4);
        queue.offer(3);
        queue.offer(7);
        queue.offer(9);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        while(!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.poll();
        }
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
    }
}
