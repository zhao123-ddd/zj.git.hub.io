package 力扣;
class  ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.next=null;
        this.val=val;
    }
}
public class TOP100_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur=head;
        int m=0;
        while(cur!=null){
            m++;
            cur=cur.next;
        }
        if(m-n!=0){
            cur=head;
            for(int i=0;i<(m-n-1);i++){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        TOP100_19 m=new TOP100_19();
        ListNode p1=new ListNode(1);
        System.out.println(m.removeNthFromEnd(p1, 1).val);
    }
}
