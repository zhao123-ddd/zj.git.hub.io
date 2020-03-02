import java.util.ArrayList;
import java.util.List;

public class Soulation {
    public void b(TreeNode root , List<Integer> list) {
        if (root != null) {
            b(root.left, list);
            list.add(root.value);
            b(root.right, list);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list=new ArrayList<>();
        b(root,list);
        return  list;
    }
    public TreeNode bulidtree(){
        TreeNode root =new TreeNode('A');
        TreeNode root1=new TreeNode('B');
        TreeNode root2=new TreeNode('C');
        TreeNode root3=new TreeNode('D');
        root.left=root1;
        root.right=root2;
        root1.left=root3;
        return  root;
    }

    public static void main(String[] args) {
        Soulation a=new Soulation();
        TreeNode node=a.bulidtree();
        List<Integer> list1=new ArrayList<>();
        list1=a.inorderTraversal(node);
        for(Integer b:list1){
            System.out.println(b.intValue());
        }
    }
}
