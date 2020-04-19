package 力扣;

import java.util.ArrayList;
import java.util.Stack;

/*堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，
我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，
并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同
（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，
执行pop操作。
当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
*/
public class 堆盘子 {
    ArrayList<Stack<Integer>> stacks=new ArrayList<>();
    int size;



    public   堆盘子(int cap){
        size=cap;
    }
    public void push(int val){
        if(stacks.size()==0||stacks.get(stacks.size()-1).size()==size){
            Stack stack=new Stack();
            stack.push(val);
            stacks.add(stack);
        }else{
            stacks.get(stacks.size()-1).push(val);
        }
    }
    public int pop(){
        if(stacks.size()==0){
            return  -1;
        }else{
            int m=stacks.get(stacks.size()-1).pop();
            if(stacks.get(stacks.size()-1).size()==0){
                stacks.remove(stacks.size()-1);
            }
            return  m;
        }
    }
    public int popAt(int index){
        if(stacks.size()==0||index>=stacks.size()) return  -1;
        int m=stacks.get(index).pop();
        if(stacks.get(index).size()==0) stacks.remove(index);
        return  m;
    }

    public static void main(String[] args) {
        堆盘子 a=new 堆盘子(1);
        a.push(1);
        a.push(2);
        System.out.println(a.popAt(1));
        System.out.println(a.pop());
        System.out.println(a.pop());

    }
}
