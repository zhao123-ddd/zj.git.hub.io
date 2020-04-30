package 力扣;

import java.util.Scanner;
/*
三个串联条件：
1.长度大于8
2.至少包含大小字母，符号，数字四种其中3中
3.不能包含长度大于2的重复子串
 */
public class 合格程序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String sb=scanner.next();
            System.out.println(count(sb));
        }
    }

    private static String count(String sb) {
        if(sb.length()<=8){
            return "NG";
        }
        boolean f1=false,f2=false,f3=false,f4=false;
        for(int i=0;i<sb.length();i++){
            if('a'<=sb.charAt(i)&&sb.charAt(i)<='z'){
                f1=true;
            }
            if(sb.charAt(i)<='Z'&&sb.charAt(i)>='A'){
                f2=true;
            }
            if(sb.charAt(i)<='9'&&sb.charAt(i)>='0'){
                f3=true;
            }
            if((sb.charAt(i)<'a'||sb.charAt(i)>'z')&&(sb.charAt(i)>'Z'||sb.charAt(i)<'A')&&(sb.charAt(i)<'0'||sb.charAt(i)>'9')){
                f4=true;
            }
        }
        int count=0;
        if(f1) count++; if(f2) count++; if(f3) count++;if(f4) count++;
        if(count<3) return "NG";
        for(int i=3;i<= sb.length()/2;i++){
            for(int j=0;j<=sb.length()-i;j++){
                String str=sb.substring(j,j+i);
                String str1=sb.substring(j+i,sb.length());
                if(str1.contains(str)){
                    return  "NG";
                }
            }
        }
        return  "OK";
    }
}
