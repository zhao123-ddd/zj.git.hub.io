import java.util.Arrays;
import java.util.Stack;

class SolutionDemo {
    public int evalRPN(String[] tokens) {
        Stack  <Integer>a=new Stack<>();
        Integer m, n;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    m = a.pop();
                    n = a.pop();
                    a.push(n + m);
                    break;
                case "-":
                    m= a.pop();
                    n = a.pop();
                    a.push(n - m);
                    break;
                case "*":
                    m = a.pop();
                    n = a.pop();
                    a.push(n * m);
                    break;
                case "/":
                    m = a.pop();
                    n = a.pop();
                    a.push(n / m);
                    break;
                default:
                    a.push(Integer.parseInt(s));
                    break;
            }
        }
        return a.pop();

    }
        
}