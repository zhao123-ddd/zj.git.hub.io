package 力扣;

public class GoUpstairs {
    public int countWays(int n) {
        int m=(int)demo(n);
        return m;
    }
    public long demo(int n){
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        else if(n==3){
            return 4;
        }

        return ((demo(n-1)+demo(n-2))%1000000007+demo(n-3))%1000000007;

    }

    public static void main(String[] args) {
        GoUpstairs m=new GoUpstairs();
        System.out.println(m.countWays(1000011));
    }
}
