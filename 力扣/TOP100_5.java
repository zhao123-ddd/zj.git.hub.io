package 力扣;
/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
*/
public class TOP100_5 {
    public String longestPalindrome(String s) {
        int minindex=0,max=0,maxindex=0;
        if(s==null||s.length()==0)
            return  s;

        boolean[][]dp=new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            for (int j=0;j<=i;j++){
                dp[j][i]=s.charAt(i)==s.charAt(j)&&(i-j<2||dp[j+1][i-1]);
                if(dp[j][i]&&(i-j+1)>max){
                  max=i-j+1;
                  minindex=j;
                  maxindex=i;
                }
            }
        }
        return  s.substring(minindex,maxindex+1);
    }

    public static void main(String[] args) {
        TOP100_5 a=new TOP100_5();
        System.out.println(a.longestPalindrome("babad"));
    }
}
