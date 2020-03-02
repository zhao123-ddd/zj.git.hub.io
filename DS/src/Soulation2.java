

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Soulation2 {
    //深度小于1
    public boolean isBanlanced(TreeNode root) {
         if(root==null)
             return  true;
         int left=getHeight(root.left);
         int right=getHeight(root.right);
         return Math.abs(left-right)<2&&isBanlanced(root.left)&&isBanlanced(root.right);
    }

    private int getHeight(TreeNode root) {
        return root==null?0:(Integer)Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    //镜像
    public  boolean isSymmetric1(TreeNode left,TreeNode right){
         if( left==null&& right==null)
             return true;
         if(  left==null|| right==null)
             return false;
         return left.value==right.value&&isSymmetric1(left.left,right.right)&&isSymmetric1(left.right,right.left);
    }
    public  boolean isSymmetric(TreeNode root){
     if(root==null)
         return true;
     return isSymmetric1(root.left,root.right);
}
//分层遍历
         public void a(TreeNode root){
        Queue<TreeNode> a=new LinkedList<>();
        if(root!=null){
            a.offer(root);
        }
        while(!a.isEmpty()){
            TreeNode node=new TreeNode();
            node=a.poll();
            System.out.printf(String.valueOf(node.value));
            if(root.left!=null){
                a.offer(root.left);
            }
            if(root.right!=null){
                a.offer(root.right);
            }
        }
    }
    //完全二叉树
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> a=new LinkedList<>();
        Queue<TreeNode> b=new LinkedList<>();
        if(root!=null){
            a.offer(root);
        }
        while(!a.isEmpty()){
            TreeNode node=new TreeNode();
            node=a.poll();
            b.offer(node);

            if(root.left!=null){
                a.offer(root.left);
            }
            if(root.right!=null){
                a.offer(root.right);
            }
        }
        while(!b.isEmpty()){
            if(b.poll()==null){
                if(b.poll()!=null)
                    return false;
            }
        }
        return true;
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
        Soulation2 a=new Soulation2();
        TreeNode node=a.bulidtree();
          a.isCompleteTree(node);
    }
}
class Node11{
    int val;
    Node11 next;
    Node11(int x){
        val=x;
    }
}
class Solution {
     public List<List<Integer>> a (TreeNode root) {
         Queue<TreeNode> a = new LinkedList<>();
         List<List<Integer>> b=new ArrayList<>();
         List<Integer> c=new ArrayList<>();
         if (root != null) {
             a.offer(root);
         }
        while(!a.isEmpty()){
            int size=a.size();
            while(size>0) {
                TreeNode node = a.poll();
                c.add(node.value);
                if (node.left != null) {
                    a.offer(node.left);
                }
                if(node.right!=null){
                    a.offer(node.right);
                }
                --size;
            }
            b.add(c);
        }
        return b;
     }
}


