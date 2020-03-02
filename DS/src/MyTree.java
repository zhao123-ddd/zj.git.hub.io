import java.util.Stack;

class Node1{
   char value;
    Node1 left;
    Node1 right;
    Node1(char value){
        this.value=value;
    }
}

public class MyTree {
    int size;
    int leafsize;
    public void getsize1(Node1 root){
        if(root!=null){
            size++;
            getsize1(root.left);
            getsize1(root.right);
        }
    }
    public Node1 bulidtree(){
    Node1 root =new Node1('A');
    Node1 root1=new Node1('B');
    Node1 root2=new Node1('C');
    Node1 root3=new Node1('D');
    root.left=root1;
    root.right=root2;
    root1.left=root3;
    return  root;
    }
    public  int getSize2(Node1 root){
        if(root==null)
            return 0;
        if(root.right==null&&root.left==null)
            return 1;
        return getSize2(root.right)+getSize2(root.left)+1;
    }
    public void getLeafSize1(Node1 root){
        if(root==null)
            return;
        if(root.right==null&&root.left==null){
            leafsize++;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    public int getLeafSize(Node1 root){
        if(root==null)
            return 0;
        if(root.right==null&&root.left==null)
            return 1;
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    //获取第k层节点数
    public int getksize(Node1 root,int k){
        if(root==null)
            return 0;
        if(k==1)
            return 1;
        return getksize(root.left,k-1)+getksize(root.right,k-1);
    }
    public void prveofer(Node1 root){
        if(root!=null){
            System.out.print(root.value);
            prveofer(root.right);
            prveofer(root.left);
        }
    }
    public void middleofer(Node1 root){
        if(root!=null){
            middleofer(root.right);
            System.out.print(root.value);
            middleofer(root.left);
        }
    }
    public void lastleofer(Node1 root){
        if(root!=null){
            lastleofer(root.right);
            lastleofer(root.left);
            System.out.print(root.value);
        }
    }
    public static void main(String[] args) {
        MyTree myTree=new MyTree();
        myTree.getsize1(myTree.bulidtree());
        myTree.prveofer(myTree.bulidtree());
        System.out.println();
        System.out.println(myTree.size);
        System.out.println(myTree.getSize2(myTree.bulidtree()));
        System.out.println(myTree.getLeafSize(myTree.bulidtree()));
        myTree.getLeafSize1(myTree.bulidtree());
        System.out.println(myTree.leafsize);
    }
}
