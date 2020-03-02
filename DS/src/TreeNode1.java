import java.util.Stack;
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.value=value;
    }

    public TreeNode() {

    }
}
//非递归中序
    public class TreeNode1 {
        public void midTree(TreeNode root){
            Stack<TreeNode> stack=new Stack<>();
            TreeNode curnode=root;
          while(curnode!=null||!stack.isEmpty()){
           while(curnode!=null) {
               stack.push(curnode);
               curnode=curnode.left;
           }
            curnode=stack.pop();
              System.out.println(curnode.value);
           curnode=curnode.right;
        }
        }
        //非递归后序
        public  void postTree(TreeNode root){
            Stack<TreeNode> stack=new Stack<>();
            TreeNode curnode=root;
            TreeNode prev=null;
            while(curnode!=null||!stack.isEmpty()){
                while(curnode!=null){
                    stack.push(curnode);
                    curnode=curnode.left;
                }
                curnode=stack.peek();
                if(curnode.right==null||curnode.left==prev){
                    System.out.println(curnode.value);
                    prev=curnode;
                    stack.pop();
                    curnode=null;
                }
                else {
                    curnode=curnode.right;
                }
            }
        }
}
