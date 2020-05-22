package 力扣;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TOP100_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1,ListNode o2){
                return o1.val-o2.val;
            }
        });
        for(ListNode node:lists){
            queue.offer(node);
        }
        ListNode node=new ListNode(0);
        ListNode cur=node;
        while(!queue.isEmpty()){
            ListNode node1=queue.poll();
            cur.next=node1;
            cur=node1;
            if(node1.next!=null){
                queue.offer(node1.next);
            }
        }
        return  node.next;
    }
}
