import java.util.Stack;

public class a {
    public static boolean chkParenthesis(String A, int n) {
        if(A.length()==0||A==null||n!=A.length())
            return false;
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<n;i++){
            if(i==0&&A.charAt(i)==')')
                return false;
            if(A.charAt(i)!='('&&A.charAt(i)!=')')
                return false;
            if(A.charAt(i)=='('||A.charAt(i)==')'){
                if(A.charAt(i)=='('){
                    stack.push(A.charAt(i));
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String A="())()()(((d";
        System.out.println(a.chkParenthesis(A,11));
    }
}
