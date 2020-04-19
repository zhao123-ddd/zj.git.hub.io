package JDBC;
public class Solution {
    public boolean isNumeric(char[] str) {
        if(str==null)
            return false;
        int m=0;
        int n=0;

        for(int i=0;i<str.length;i++){
            if(str[i]=='+'||str[i]=='-'){
                if(i!=0&&(str[i-1]!='E'&&str[i-1]!='e')){
                    return false;
                }if(i+1==str.length||!(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '.')){
                    return false;
                }
            }
            if(str[i]=='e'||str[i]=='E'){
                if(i+1==str.length) {
                    return false;
                }else if (n!=0){
                    return false;
                }else {
                    n++;
                }

            }
            if(str[i]=='.'){
                if(m==0&&n==0){
                    m++;
                }else{
                    return false;
                }
            }

            if(str[i]!='e' && str[i]!='E'&&!(str[i]>='0'&&str[i]<='9')&&str[i]!='.'&&str[i]!='+'&&str[i]!='-'){
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        char a[]=new char[]{'1','2','3','4','5','e','+','6'};
        Solution b=new Solution();
        System.out.println(b.isNumeric(a));
    }
}
